package com.tt.service.impl;

import com.tt.dao.UserMapper;
import com.tt.pojo.User;
import com.tt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: com.tt.service.impl.UserServiceImpl
 * @Description: 用户业务实现类
 * @Author: Administrator
 * @CreateDate: 2019/1/8 13:55
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public User findUserById(Integer id) throws Exception {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void register(User user) throws Exception {
        if (user == null) {
            throw new Exception("参数不合法");
        }
        //调用用户数据访问层接口中的添加用户方法
        userMapper.insertSelective(user);
    }

    @Override
    public User validateLogin(String telphone, String password) throws Exception {

        //通过用户手机信息和密码获取用户信息
        User user = userMapper.selectByTelphoneAndPwd(telphone,password);
        if (user==null){
            throw new Exception("参数不合法");
        }
        return user;
    }
}
