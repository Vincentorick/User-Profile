package com.jteam2.service;

import com.jteam2.entity.User;
import com.jteam2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    HttpSession httpSession;

    public Integer userLogin(HttpServletResponse response, String email, String password, Map data) {

        try {
            Map queryUser = new HashMap();
            queryUser.put("email", email);

            List<User> list = userMapper.selectByMap(queryUser);

            if (list.isEmpty()) {
                return 3;
            }
            else if (!list.get(0).getPassword().equals(password)) {
                return 4;
            }
            else if (list.get(0).getRole() == 1 || list.get(0).getRole() == 2) {

                // 写入session
                httpSession.setAttribute("email", email);
                // 写入cookie
                Cookie cookie = new Cookie("email", null);
                cookie.setValue(email);
                cookie.setPath("/");
                cookie.setMaxAge(6 * 60 * 60);  // 6小时过期
                response.addCookie(cookie);

                data.put("uid", list.get(0).getId());
                data.put("displayName", list.get(0).getUsername());
                data.put("email", list.get(0).getEmail());
                data.put("role", list.get(0).getRole());
                data.put("password", list.get(0).getPassword());

                if (list.get(0).getRole() == 1) {
                    return 1;
                }
                else {
                    return 2;
                }
            }
        } catch (Exception e) {
            return 5;
        }

        return 0;
    }

}
