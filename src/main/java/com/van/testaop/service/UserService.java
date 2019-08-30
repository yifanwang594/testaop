package com.van.testaop.service;

import org.springframework.stereotype.Service;

/**
 * @author: Van
 * @create: 2019-08-27 09:48
 * @description:
 * @program: testaop
 * @version: 1.0
 **/
@Service
public class UserService {

    public String getUsernameById(Integer id){
        System.out.println("getUsernameById");
        return "ididididi";
    }

    public void deletedUsernameById(Integer id){
        System.out.println("deletedUsernameById");
    }

}
