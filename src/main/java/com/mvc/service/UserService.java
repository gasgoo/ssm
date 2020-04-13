package com.mvc.service;

import com.mvc.dao.UserDao;
import com.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {


        @Autowired(required = false)
        private UserDao userDao;

        public User getUserById(int userId) {
            return userDao.selectByPrimaryKey(userId);
        }

        public boolean addUser(User record) {
            boolean result = false;
            try {
                record.setPassword(record.getPassword());
                userDao.add(record);
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }

        public List<User> getUsers(){
            return userDao.getAllUsers();
        }

}
