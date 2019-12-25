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
    private String banner_image1;
    private String banner_image2;
    private String banner_image3;
    private String status;
    private int user_id;
}
;