package com.housings.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.housings.dao.UserDao;
import com.housings.pojo.User;
import com.housings.service.UserService;
import com.housings.util.PageUtil;
import com.housings.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class UserController{

    //private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    //private UserDao userDao;
    private UserService userDao;
    @Autowired
    private UserDao userMapper;

    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String loginGet(Model model){
        return "loginPage";
    }

    @GetMapping("/loginOut")
    public String loginOut(){
        //销毁session
        session.invalidate();
        return "loginPage";
    }

    @PostMapping("/login")
    public String loginPost(User user, Model model) {
        User user1 = userDao.getUserByNamePassword(user.getName(),
                user.getPassword());
        if (user1 != null) {
            session.setAttribute("user", user1);
            User name = (User) session.getAttribute("user");
            //设置session失效时间(单位/s)
            //session.setMaxInactiveInterval(5*60);
            return "redirect:index_0_0_0";
        }else{
            model.addAttribute("msg", "用户名或密码错误，请重新登录！");
            return "loginPage";
        }
    }

    @GetMapping("/register")
    public String registerGet(Model model, HttpServletRequest request) {
        String msg = request.getParameter("msg");
        if (msg != null) {
            model.addAttribute("msg", msg);
        }
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(User user, Model model) {
        try {
            User u  = userDao.validate(user.getName());
            if (u != null) {
                model.addAttribute("msg", "该账号已存在！");
                return "redirect:register?msg="+ URLEncoder.encode("该用户名已被使用，请重新输入！","utf-8");
            }
            user.setRole(2);
            userDao.insertUser(user);

            return "loginPage";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "register";
    }

    @GetMapping("/users_{pageCurrent}_{pageSize}_{pageCount}")
    public String userManager(Model model,
                              @PathVariable Integer pageCurrent,
                              @PathVariable Integer pageSize,
                              @PathVariable Integer pageCount,
                              HttpServletRequest request
                              ) {
        try {
            User user = (User)session.getAttribute("user");
            user.setIsDelete(0);
            if (user == null) {
                model.addAttribute("msg", "您还未登录，请登录！");
                return "loginPage";
            }
            if (user.getRole() != 1) {
                model.addAttribute("msg", "您没有权限");
                return "redirect:index_0_0_0";
            }
            int pageNum = StringHelper.intValue(request.getParameter("pageNum"));
            if (pageNum == 0) {
                pageNum = 1;
            }
            //初始化分页信息
            //每页显示条数
            if (pageSize == 0){
                pageSize = 5;
            }
            //当前页
            if (pageCurrent == 0){
                pageCurrent = 1;
            }
            //统计总记录数
            int rows = userMapper.countItem();
            //总页数
            if (pageCount == 0){
                pageCount = (rows + pageSize -1) / pageSize;
            }

            int size = 5 ;
            PageHelper.startPage(pageNum, size);
            List<User> list = userMapper.queryAll();
            PageInfo<User> pageInfo = new PageInfo<>(list,size);

            model.addAttribute("pageInfo", pageInfo);

            return "users";

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
    }
        return "users";
    }

    @PostMapping("/searchUser")
    public String searchUser(User user, Model model) {
        User u = (User)session.getAttribute("user");
        if (u == null) {
            model.addAttribute("msg", "您还未登录，请登录！");
            return "loginPage";
        }
        if (u.getRole() != 1) {
            model.addAttribute("msg", "您没有权限");
            return "redirect:index_0_0_0";
        }
        String name = user.getName();
        if (name != null) {
            PageHelper.startPage(1, 5);
            List<User> list = userMapper.searchUser(user.getName());
            PageInfo<User> pageInfo = new PageInfo<>(list);

            model.addAttribute("pageInfo", pageInfo);
            return "users";
        } else {
            model.addAttribute("msg", "请输入搜索条件");

        }
        return "users_0_0_0";
    }


    /**
     * 新增用户信息页
     * @return
     */
    @GetMapping("/editUser")
    public String projectGet(Model model, User user,HttpServletRequest request){
        String msg= null;
        try {
            //msg = new String(request.getParameter("msg").getBytes("ISO8859-1"),"UTF-8");
            msg = request.getParameter("msg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (msg != null) {
            model.addAttribute("msg", msg);
        }
        User obj = new User();
        if(user.getId() != null){
            obj = userMapper.findByUserId(user);
            model.addAttribute("data", obj);
            return "userManager";
        }
        //如果是新增，则初始化时间
        model.addAttribute("data", obj);
        return "userManager";
    }

    /**
     * 新增或修改用户信息
     * @param model
     * @param user
     * @return
     */
    @PostMapping("/userManager")
    public String editProjectPost(Model model, User user){
        try {
            if (user.getRole() == 0) {
                user.setRole(2);
            }
            User u  = userMapper.validate(user.getName());
            if (u != null) {
                String s = "用户名已被使用，请重新输入！";
                model.addAttribute("msg",s );
                return "redirect:editUser?msg="+ URLEncoder.encode(s,"utf-8");
            }
            if(user.getId() != null){
                userMapper.updateUser(user);
            }else{

                userMapper.insertUser(user);
            }
            return "redirect:users_0_0_0";
        }catch (Exception e){
            model.addAttribute("msg", "提交失败！");
        }
        return "users";

    }

    /**
     * 新增或修改用户信息
     * @param model
     * @return
     */
    @GetMapping("/deleteUser")
    public String deleteUser(Model model,HttpServletRequest request){
        try {
            User u = (User) session.getAttribute("user");
            if (u == null) {
                model.addAttribute("msg", "您还未登录，请登录！");
                return "loginPage";
            }
            if (u.getRole() != 1) {
                model.addAttribute("msg", "您没有权限");
                return "users_0_0_0";
            }
            String ids = request.getParameter("id");
            int id = StringHelper.intValue(ids);
            userMapper.delete(id);
            model.addAttribute("msg", "提交成功！");
            return "redirect:users_0_0_0";
        }catch (Exception e){
            model.addAttribute("msg", "提交失败！");
        }
        return "users";

    }
}
