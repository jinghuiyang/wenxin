package com.youzhong.service.impl;

import com.youzhong.dao.UserMapper;
import com.youzhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List list() {
        return userMapper.selectByExample(null);
    }
}
