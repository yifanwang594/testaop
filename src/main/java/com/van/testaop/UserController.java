package com.van.testaop;

import com.van.testaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Van
 * @create: 2019-08-27 09:50
 * @description:
 * @program: testaop
 * @version: 1.0
 **/
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/test1",produces = "application/json")

    public String getUsernameById(Integer id){
        return userService.getUsernameById(id);
    }
    @RequestMapping("/test2")
    public void deletedUsernameById(Integer id){
        userService.deletedUsernameById(id);
    }

}
