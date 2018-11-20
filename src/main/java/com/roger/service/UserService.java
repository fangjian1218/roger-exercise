package com.roger.service;

import com.roger.model.UserModel;
import com.roger.vo.UserVo;

import java.util.List;

public interface UserService {
    List<UserVo> geUsers();

    void insertUser(UserModel userModel);

    void setPasswd(UserModel userModel);

    UserVo queryUserByEmail(UserModel userModel);

    UserVo queryUserByEmailAndPasswd(UserModel userModel);
}
