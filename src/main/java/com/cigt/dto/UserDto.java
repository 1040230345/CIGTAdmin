package com.cigt.dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String name;
    private  String imge;
    private  String password;
    private  String address;
    private  String  sex;
    private String phone;
    private  int Information_state;
    private  String autograph;
    private String created_at;
    private String updated_at;
    private String real_name;
}
