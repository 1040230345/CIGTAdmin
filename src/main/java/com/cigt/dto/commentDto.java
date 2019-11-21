package com.cigt.dto;

import lombok.Data;

@Data
public class commentDto {
    private int id;
    private String goods_id;
    private String user_id;
    private String user_name;
    private String content;
    private String reply_user_id;
    private String reply_user_name;
}
