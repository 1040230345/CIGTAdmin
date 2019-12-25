package com.cigt.dto;

import lombok.Data;

@Data
public class OrderDto {
    private int id;
    private int Goods_id;
    private String name;
    private int user_id;
    private String real_name;
    private int number;
    private String user_address;
    private int status;
    private String created_at;
    private String updated_at;
}
