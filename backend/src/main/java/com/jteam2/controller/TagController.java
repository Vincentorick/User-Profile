package com.jteam2.controller;

import com.jteam2.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 获取所有1234级基础标签
     */
    @GetMapping("/getMapping")
    @ResponseBody
    public Map getTagMapping() {
        return tagService.getTagMapping();
    }

    /**
     * 根据4级标签id获取对应5级标签
     */
    @GetMapping("/getLowLevel/{id}")
    @ResponseBody
    public List getLevel5Tag(@PathVariable Integer id) {
        return tagService.getLevel5Tag(id);
    }

    /**
     * 获取所有组合标签及其内容
     */
    @GetMapping("/getMergeTag")
    @ResponseBody
    public List getMergeTags() {
        return tagService.getMergeTag();
    }

    /**
     * 标签搜索功能
     */
    @GetMapping("/searchTags")
    @ResponseBody
    public List searchTags(List conditionList) {
        return tagService.searchTags(conditionList);
    }

    /**
     * 向前段返回用户信息
     */
    @GetMapping("/getUser")
    @ResponseBody
    public List getUser() {
        return tagService.getUser();
    }

}
