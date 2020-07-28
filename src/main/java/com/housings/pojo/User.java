package com.housings.pojo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User extends BaseObject{

    private Integer id;
    private String name;
    private String password;
    private String address;
    private String tel;
    private int role;
    private int isDelete;

}
