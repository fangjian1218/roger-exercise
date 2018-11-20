package com.roger.controller;

import com.roger.model.UserModel;
import com.roger.service.UserService;
import com.roger.utils.MD5Util;
import com.roger.utils.Result;
import com.roger.utils.ResultUtil;
import com.roger.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value = "user", method = RequestMethod.POST)
@Api(tags = "UserController", description = "针对用户表增删改查")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @RequestMapping("getUsers")
    @ApiOperation(value = "查询所有用户")
    public Result getUsers(@RequestBody UserModel userModel) {
        logger.info("进入getUsers方法，参数==》" + userModel);
        List<UserVo> users = userService.geUsers();
        return ResultUtil.successResult(users);
    }

    @RequestMapping("insertUser")
    @ApiOperation(value = "新增用户")
    public Result insertUser(@RequestBody UserModel userModel) {
        logger.info("进入insertUser方法，参数==》" + userModel);
        userService.insertUser(userModel);
        return ResultUtil.successResult("用户新增成功");
    }

    @RequestMapping("setPasswd")
    @ApiOperation(value = "用户密码初始化")
    public Result setPasswd(@RequestBody UserModel userModel) {
        logger.info("进入setPasswd方法，参数==》" + userModel);
        String password = userModel.getPassword();
        if (StringUtils.isWhitespace(password) || StringUtils.isWhitespace(userModel.getEmail()))
            return ResultUtil.successResult("参数输入有误");

        UserVo userVo = userService.queryUserByEmail(userModel);
        if (userVo == null)
            return ResultUtil.successResult("当前用户不存在");

        userModel.setPassword(MD5Util.MD5(password));
        userService.setPasswd(userModel);
        return ResultUtil.successResult("密码初始化成功");
    }

    @RequestMapping("updatePasswd")
    @ApiOperation(value = "用户修改密码")
    public Result updatePasswd(@RequestBody UserModel userModel) {
        logger.info("进入setPasswd方法，参数==》" + userModel);
        String password = userModel.getPassword();
        if (StringUtils.isWhitespace(password) || StringUtils.isWhitespace(userModel.getNew_password()) || StringUtils.isWhitespace(userModel.getEmail()))
            return ResultUtil.successResult("参数输入有误");

        userModel.setNew_password(MD5Util.MD5(userModel.getNew_password()));
        userModel.setPassword(MD5Util.MD5(userModel.getPassword()));

        UserVo userVo = userService.queryUserByEmailAndPasswd(userModel);
        if (userVo == null)
            return ResultUtil.successResult("当前用户不存在");

        userService.setPasswd(userModel);

        return ResultUtil.successResult("密码修改成功");
    }
}
