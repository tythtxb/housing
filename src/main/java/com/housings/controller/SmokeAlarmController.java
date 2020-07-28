
package com.housings.controller;

import com.housings.pojo.SmokeAlarm;
import com.housings.service.SmokeAlarmService;
import com.housings.util.DateHelper;
import com.housings.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 产品Controller
 */
@Controller
public class SmokeAlarmController{

    @Autowired
    private SmokeAlarmService smokeAlarmService;

    /**
     * 进入主页
     * @return
     */
    @GetMapping("/index_{pageCurrent}_{pageSize}_{pageCount}")
    public String main(SmokeAlarm smokeAlarm, @PathVariable Integer pageCurrent,
                       @PathVariable Integer pageSize,
                       @PathVariable Integer pageCount,
                       Model model) {
        //初始化分页信息
        //每页显示条数
        if (pageSize == 0){
            pageSize = 5;
        }
        //当前页
        if (pageCurrent == 0){
            pageCurrent = 1;
        }

        smokeAlarm.setStart((pageCurrent - 1)  * pageSize);
        smokeAlarm.setEnd(pageSize);

        //统计总记录数
        int rows = smokeAlarmService.countItem(smokeAlarm);
        //总页数
        if (pageCount == 0){
            pageCount = (rows + pageSize -1) / pageSize;
        }

        List<SmokeAlarm> list = smokeAlarmService.queryAll(smokeAlarm);

        model.addAttribute("dataList", list);
        String pageHTML = PageUtil.getPageContent("index_{pageCurrent}_{pageSize}_{pageCount}?userId="+smokeAlarm.getUserId(), pageCurrent, pageSize, pageCount);
        model.addAttribute("pageHTML", pageHTML);
        model.addAttribute("smokeAlarm", smokeAlarm);
        return "index";
    }


    /**
     * 新增产品信息页
     * @return
     */
    @GetMapping("/editProject")
    public String projectGet(Model model, SmokeAlarm smokeAlarm){
        //ID不为空说明是修改
        if(smokeAlarm.getId() != null){
            SmokeAlarm obj = smokeAlarmService.findById(smokeAlarm);
            model.addAttribute("item", obj);
        }else{
            //如果是新增，则初始化时间
            SmokeAlarm addObj = new SmokeAlarm();
            addObj.setInstallDate(DateHelper.getNowFormatDate());
            addObj.setDetectionDate(DateHelper.getNowFormatDate());
            model.addAttribute("item", addObj);
        }

        return "projectManager";
    }

    /**
     * 新增或修改产品信息
     * @param model
     * @param smokeAlarm
     * @return
     */
    @PostMapping("/editProject")
    public String editProjectPost(Model model, SmokeAlarm smokeAlarm){
        try {
            if(smokeAlarm.getId() != null){
                smokeAlarmService.update(smokeAlarm);
            }else{
                smokeAlarmService.insert(smokeAlarm);
            }
            model.addAttribute("msg", "提交成功！");
            return "redirect:index_0_0_0";
        }catch (Exception e){
            model.addAttribute("msg", "提交失败！");
        }
        return null;
    }

    /**
     * 删除产品
     * @param model
     * @param smokeAlarm
     * @return
     */
    @PostMapping("/delProject")
    @ResponseBody
    public String delProjectPost(Model model, SmokeAlarm smokeAlarm){

        try {
            if(smokeAlarm.getId() != null){
                smokeAlarmService.delete(smokeAlarm);
            }
            return "success";
        }catch (Exception e){
            return "error";
        }

    }

}

