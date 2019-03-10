package com.jiuyue.blog.service.impl;

import com.jiuyue.blog.mapper.UsersMapper;
import com.jiuyue.blog.pojo.model.Users;
import com.jiuyue.blog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create bySeptember
 * 2019/3/7
 * 17:06
 */
@Service
public class UserServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users getUsers(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }
}
