package com.roger.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserModel {
    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "邮箱", name = "email", example = "790835227@qq.com", required = true)
    private String email;

    @ApiModelProperty(value = "用户名", name = "user_name", example = "fangjian", required = true)
    private String user_name;

    @ApiModelProperty(value = "用户姓名", name = "name", example = "方建", required = true)
    private String name;

    @ApiModelProperty(value = "用户密码", name = "password", example = "123")
    private String password;

    @ApiModelProperty(value = "用户旧密码", name = "old_password", example = "")
    private String new_password;

    @ApiModelProperty(value = "通讯号码", name = "phone", example = "17755057545")
    private String phone;

    @ApiModelProperty(value = "通讯地址", name = "address", example = "上海市浦东新区周浦镇繁荣东路150弄繁荣馨苑8号楼201室")
    private String address;
}
