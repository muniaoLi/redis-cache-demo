package com.muniao.rediscachedemo.service;

import com.muniao.rediscachedemo.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "ch1")
public class UserService
{

    @Cacheable(key = "#id")
    public User getUserById(Long id) {
        System.out.println("getUserById");
        return getUserFromDBById(id);
    }

    private User getUserFromDBById(Long id)
    {
        System.out.println("getUserFromDBById...");
        User user = new User();
        user.setId(id);
        user.setName("name"+id);
        user.setAge(10+id.intValue());
        user.setAdress("adress"+id);
        return user;
    }

    @CachePut(key = "#user.id")
    public User updateUserById(User user) {
        user.setName("newName");
        return user;
    }

    @CacheEvict()
    public void deleteUserById(Long id) {
        //在这里执行删除操作， 删除是去数据库中删除
    }
}
