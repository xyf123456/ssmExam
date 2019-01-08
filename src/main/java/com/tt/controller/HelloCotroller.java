package com.tt.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: com.tt.controller.HelloCotroller
 * @Description: 测试控制器
 * @Author: Administrator
 * @CreateDate: 2019/1/8 11:59
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
@RestController
public class HelloCotroller {

    @RequestMapping("index")
    private String index() {
        return "hello";
    }
}
