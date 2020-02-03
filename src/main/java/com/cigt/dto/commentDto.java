package com.cigt.dto;

import lombok.Data;

@Data
public class commentDto {
    private int id;
    private String goods_name;
    private String user_name;
    private String content;
    private int pid;
}
