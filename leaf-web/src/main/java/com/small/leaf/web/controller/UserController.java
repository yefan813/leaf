package com.small.leaf.web.controller;


import com.small.leaf.domain.User;
import com.small.leaf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yefan
 * @since 2019-04-24
 */
@RestController
@RequestMapping("/tb/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("findOne")
    public User findOne(){
        User user = iUserService.getById(1);
        return user;
    }
}
