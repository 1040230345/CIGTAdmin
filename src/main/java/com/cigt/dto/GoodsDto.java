package com.cigt.dto;

import lombok.Data;

@Data
public class GoodsDto {
    private int id;
    private String name;
    private Double price;
    private String images;
    private String time;
    private  String  updated_at;
    private int num;
    private String category;
    private int user_id;
}
;