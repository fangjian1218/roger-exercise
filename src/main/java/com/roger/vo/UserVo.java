package com.roger.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class UserVo {
    private Integer id;
    private String email;
    private String user_name;
    private String name;
    private String phone;
    private String address;
    private String status;
    private Timestamp create_time;
}
