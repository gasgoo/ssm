package com.mvc.service;

import com.mvc.entity.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class UserServiceTest extends TestCase {

    @Autowired
    private UserService userService;
    @Test
    public void testGetUserById() {
        User user=userService.getUserById(1);
        System.out.println("查询结果： "+user.toString());
    }

    public void testAddUser() {
    }

    public void testGetUsers() {
    }
}