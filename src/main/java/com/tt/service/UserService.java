package com.tt.service;

import com.tt.pojo.User;

/**
 * @ClassName: com.tt.service.UserService
 * @Description:  用户业务接口
 * @Author:      Administrator
 * @CreateDate: 2019/1/8 13:54
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
public interface UserService {
    User findUserById(Integer id) throws Exception;

    void register(User user) throws Exception;

    User validateLogin(String telphone, String password) throws Exception;
}
