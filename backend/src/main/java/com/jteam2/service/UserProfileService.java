package com.jteam2.service;

import com.jteam2.entity.BasicTag;
import com.jteam2.mapper.BasicTagMapper;
import com.jteam2.utils.HBaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserProfileService {

    @Autowired
    private BasicTagMapper basicTagMapper;

    @Autowired
    private HBaseUtil hBaseUtil;

    // 给前端生成一个完全的列表
    public Map getUserProfileList(String email) {

        // 先去HBase获取有关数据
        Map userInfo = hBaseUtil.getUserByEmail(email);

        Map result = new HashMap();

        // 先判断是否查询到
        if (userInfo.isEmpty()) {
            result.put("code", 0);
            result.put("email", email);
            result.put("data", new HashMap<>());

            return result;
        }

        Map tag1result = new HashMap();
        tag1result.put("name", "电商");


        // 查询对应所有2级标签
        Map tag2selectColumn = new HashMap();
        tag2selectColumn.put("pid", 1);
        List tag2query =  basicTagMapper.selectByMap(tag2selectColumn);
        List tag1children = new ArrayList();

        // 循环遍历将所有2级标签加入children中
        for (int i=0; i<tag2query.size(); ++i) {

            BasicTag currTag2 = (BasicTag) tag2query.get(i);
            int currId2 = (int) currTag2.getId();

            Map tag2result = new HashMap();
            tag2result.put("name", currTag2.getName());

            // 查询对应所有3级标签
            Map tag3selectColumn = new HashMap();
            tag3selectColumn.put("pid", currId2);
            List tag3query = basicTagMapper.selectByMap(tag3selectColumn);
            List tag2children = new ArrayList();

            // 循环遍历将所有3级标签加入children中
            for (int j=0; j<tag3query.size(); ++j) {
                BasicTag currTag3 = (BasicTag) tag3query.get(j);
                int currId3 = currTag3.getId();

                Map tag3result = new HashMap();
                tag3result.put("name", currTag3.getName());

                // 查询对应所有4级标签
                Map tag4selectColumn = new HashMap();
                tag4selectColumn.put("pid", currId3);
                List tag4query = basicTagMapper.selectByMap(tag4selectColumn);
                List tag3children = new ArrayList();

                // 循环遍历将所有4级标签加入children中
                for (int k=0; k<tag4query.size(); ++k) {
                    BasicTag currTag4 = (BasicTag) tag4query.get(k);
                    int currId4 = currTag4.getId();

                    Map tag4result = new HashMap();
                    tag4result.put("name", currTag4.getName());

                    List tag5children = new ArrayList();
                    Map teg5childrenmap = new HashMap();

                    // 不用查询5级标签 直接写入结果
                    // 只能通过循环遍历增加子标签
                    switch (currTag4.getName()) {
                        case "性别":
                            // tag4result.put("value", userInfo.get("gender"));
                            teg5childrenmap.put("name", userInfo.get("gender"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "星座":
                            // tag4result.put("value", userInfo.get("star"));
                            teg5childrenmap.put("name", userInfo.get("star"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "客服咨询频率":
                            // tag4result.put("value", userInfo.get("customAsk"));
                            teg5childrenmap.put("name", userInfo.get("customAsk"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "客单价":
                            // tag4result.put("value", userInfo.get("avgPrice"));
                            teg5childrenmap.put("name", userInfo.get("avgPrice"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "年龄段":
                            // tag4result.put("value", userInfo.get("age-step"));
                            teg5childrenmap.put("name", userInfo.get("age-step"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "单笔最高":
                            // tag4result.put("value", userInfo.get("maxPerOrder"));
                            teg5childrenmap.put("name", userInfo.get("maxPerOrder"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "籍贯":
                            // tag4result.put("value", userInfo.get("origin"));
                            teg5childrenmap.put("name", userInfo.get("origin"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "政治面貌":
                            // tag4result.put("value", userInfo.get("politicalFace"));
                            teg5childrenmap.put("name", userInfo.get("politicalFace"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "消费能力":
                            // tag4result.put("value", userInfo.get("costForce_n"));
                            teg5childrenmap.put("name", userInfo.get("costForce_n"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "消费周期":
                            // tag4result.put("value", userInfo.get("frequency"));
                            teg5childrenmap.put("name", userInfo.get("frequency"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "省钱能手":
                            // tag4result.put("value", userInfo.get("discount_n"));
                            teg5childrenmap.put("name", userInfo.get("discount_n"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "国籍":
                            // tag4result.put("value", userInfo.get("nationality"));
                            teg5childrenmap.put("name", userInfo.get("nationality"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "支付方式":
                            // tag4result.put("value", userInfo.get("paymentCode"));
                            teg5childrenmap.put("name", userInfo.get("paymentCode"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "购买频率":
                            // tag4result.put("value", userInfo.get("buyFrequency"));
                            teg5childrenmap.put("name", userInfo.get("buyFrequency"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "婚姻状况":
                            // tag4result.put("value", userInfo.get("marriage"));
                            teg5childrenmap.put("name", userInfo.get("marriage"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "浏览时长":
                            // tag4result.put("value", userInfo.get("browserTime"));
                            teg5childrenmap.put("name", userInfo.get("browserTime"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "浏览时段":
                            // tag4result.put("value", userInfo.get("browsingPeriod"));
                            teg5childrenmap.put("name", userInfo.get("browsingPeriod"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "职业":
                            // tag4result.put("value", userInfo.get("job"));
                            teg5childrenmap.put("name", userInfo.get("job"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "最近登录":
                            // tag4result.put("value", userInfo.get("recent"));
                            teg5childrenmap.put("name", userInfo.get("recent"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        case "设备类型":
                            // tag4result.put("value", userInfo.get("machineType"));
                            teg5childrenmap.put("name", userInfo.get("machineType"));
                            teg5childrenmap.put("value", 0);
                            tag5children.add(teg5childrenmap);
                            tag4result.put("children", tag5children);
                            break;
                        default:
                            tag4result.put("value", 0);
                            break;
                    }

                    // 直接接入
                    tag3children.add(tag4result);
                }

                tag3result.put("children", tag3children);

                // 将其加入tag2children中
                tag2children.add(tag3result);
            }

            tag2result.put("children", tag2children);

            // 将其加入tag1children中
            tag1children.add(tag2result);
        }

        tag1result.put("children", tag1children);

        result.put("code", 1);
        result.put("email", email);
        result.put("username", userInfo.get("username"));
        result.put("data", tag1result);

        return result;
    }

}
