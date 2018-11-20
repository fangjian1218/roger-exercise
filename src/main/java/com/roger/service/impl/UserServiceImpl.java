package com.roger.service.impl;

import com.roger.mapper.primary.UserMapper;
import com.roger.model.UserModel;
import com.roger.service.UserService;
import com.roger.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserVo> geUsers() {
        return userMapper.getUsers();
    }

    @Override
    public void insertUser(UserModel userModel) {
        userMapper.insertUser(userModel);
    }

    @Override
    public void setPasswd(UserModel userModel) {
        userMapper.setPasswd(userModel);
    }

    @Override
    public UserVo queryUserByEmail(UserModel userModel) {
        return userMapper.queryUserByEmail(userModel);
    }

    @Override
    public UserVo queryUserByEmailAndPasswd(UserModel userModel) {
        return userMapper.queryUserByEmailAndPasswd(userModel);
    }
}
