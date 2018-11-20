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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "login", method = RequestMethod.POST)
@Api(tags = "LoginController", description = "用户登录")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("login")
    @ApiOperation(value = "查询所有用户")
    public Result login(@RequestBody UserModel userModel) {
        logger.info("进入login方法，参数==》" + userModel);
        String password = userModel.getPassword();
        if (StringUtils.isWhitespace(password) || StringUtils.isWhitespace(userModel.getEmail()))
            return ResultUtil.successResult("参数输入有误");

        userModel.setPassword(MD5Util.MD5(password));
        UserVo userVo = userService.queryUserByEmailAndPasswd(userModel);
        if (userVo == null)
            return ResultUtil.successResult("当前用户不存在");

        UserVo user = (UserVo) redisTemplate.opsForHash().get("user", userVo.getEmail());
        logger.info("redis 返回 user ==>" + user);
        redisTemplate.opsForHash().put("user", userVo.getEmail(), userVo);

        return ResultUtil.successResult("");
    }
}
