package com.jteam2.controller;

import com.jteam2.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/getByEmail")
    @ResponseBody
    public Map getUserProfileList(String email) {
        return userProfileService.getUserProfileList(email);
    }

}
