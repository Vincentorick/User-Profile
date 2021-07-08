package com.jteam2.controller;

import com.jteam2.entity.User;
import com.jteam2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/identity")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public Map login(HttpServletResponse response, @RequestBody User user) {

        String email = user.getEmail();
        String password = user.getPassword();

        Map ret = new HashMap();
        Map data = new HashMap();

        if (email.isEmpty() || password.isEmpty()) {
            ret.put("code", 0);
            ret.put("msg", "用户名或密码为空");
            ret.put("data", data);
        }
        else {
            int code = loginService.userLogin(response, email, password, data);
            ret.put("code", code);
            switch (code) {
                case 1:
                    ret.put("msg", "管理员登录");
                    ret.put("data", data);
                    break;
                case 2:
                    ret.put("msg", "普通用户登录");
                    ret.put("data", data);
                    break;
                case 3:
                    ret.put("msg", "用户名不存在");
                    ret.put("data", data);
                    break;
                case 4:
                    ret.put("msg", "密码错误");
                    ret.put("data", data);
                    break;
                case 5:
                    ret.put("msg", "出现异常");
                    ret.put("data", data);
                    break;
            }
        }

        return ret;
    }

}
