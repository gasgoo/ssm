package com.mvc.dao;

import com.mvc.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> selectUser(User userBean);

    User selectByPrimaryKey(Integer id);

    void add(User userBean);

    List<User> getAllUsers();
}
