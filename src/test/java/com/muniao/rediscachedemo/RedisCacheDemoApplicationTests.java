package com.muniao.rediscachedemo;

import com.muniao.rediscachedemo.domain.User;
import com.muniao.rediscachedemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheDemoApplicationTests
{
    @Autowired
    UserService userService;

    @Test
    public void test1()
    {
        User user = userService.getUserById(1L);
        System.out.println(user);

    }

    @Test
    public void test2()
    {
        User user = userService.getUserById(1L);
        System.out.println(user);

        user = userService.updateUserById(user);
        System.out.println(user);

        User user1 = userService.getUserById(1L);
        System.out.println(user1);

    }

    @Test
    public void test3()
    {
        User user = userService.getUserById(1L);
        System.out.println(user);

        userService.deleteUserById(1L);

        User user1 = userService.getUserById(1L);
        System.out.println(user1);

    }


}
