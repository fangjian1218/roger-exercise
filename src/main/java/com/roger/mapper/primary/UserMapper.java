package com.roger.mapper.primary;

import com.roger.model.UserModel;
import com.roger.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVo> getUsers();

    void insertUser(UserModel userModel);

    void setPasswd(UserModel userModel);

    UserVo queryUserByEmail(UserModel userModel);

    UserVo queryUserByEmailAndPasswd(UserModel userModel);
}
