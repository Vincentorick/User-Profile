package com.jteam2.controller;

import com.jteam2.mapper.BasicTagMapper;
import com.jteam2.mapper.MergeTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private BasicTagMapper basicTagMapper;

    @Autowired
    private MergeTagMapper mergeTagMapper;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List getList() {

        List list = basicTagMapper.selectList(null);
        return list;

    }

    @RequestMapping("/hello/testMergeTag")
    @ResponseBody
    public List testMergeTag() {
        return mergeTagMapper.selectList(null);
    }

}
