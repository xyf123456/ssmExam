package com.tt.controller;

import com.alibaba.druid.util.StringUtils;
import com.tt.pojo.User;
import com.tt.service.UserService;
import com.tt.utils.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: com.tt.controller.UserController
 * @Description:  用户控制器
 * @Author:      Administrator
 * @CreateDate: 2019/1/8 13:52
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;


    @RequestMapping("getUser")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam("userId") Integer id) throws Exception {
//        return userService.findUserById(id);
          return CommonReturnType.create(userService.findUserById(id),"success");
    }
    /**
     * @ Description: 跳转到注册页面
     * @params:  * @Param:
     * @return:java.lang.String
     **/
    @RequestMapping("register")
    public String register() throws Exception {

        return "register";
    }

    /**
     * @ Description:跳转到登录页面
     * @params:  * @Param:
     * @return:java.lang.String
     **/
    @RequestMapping("login")
    public String login() throws Exception {

        return "login";
    }

    @RequestMapping("/index")
    public String index(Model model) throws Exception {
        User user= (User) httpServletRequest.getSession().getAttribute("LOGIN_USER");
//        System.out.println(user.getName());
        model.addAttribute("userName",user.getName());
        return "index";
    }


    /**
     * @ Description:  处理用户注册
     * @params:  * @Param: telphone
     * @Param: name
     * @Param: gender
     * @Param: age
     * @Param: password
     * @return:com.tt.utils.CommonReturnType
     **/
    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType register(@RequestParam("telphone") String telphone,
                           @RequestParam("name") String name,
                           @RequestParam("gender") Integer gender,
                           @RequestParam("age") Integer age,
                           @RequestParam("password") String password) throws Exception {
//        用户的注册流程
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setGender(new Byte(String.valueOf(gender.intValue())));
        user.setTelphone(telphone);
        user.setPassword(password);
        //调用用户注册的业务方法
        userService.register(user);
        return CommonReturnType.create(user,"success");
    }

    @RequestMapping(value = "validateLogin", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType validateLogin(@RequestParam("telphone") String telphone,
                                     @RequestParam("password") String password) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isEmpty(telphone)||
                StringUtils.isEmpty(password)){
            throw new Exception("参数不合法");
        }
//        用户的登录
        User user=userService.validateLogin(telphone,password);
        //将用户信息存入到session中
        httpServletRequest.getSession().setAttribute("LOGIN_USER",user);
        return CommonReturnType.create(user,"success");
    }
}

