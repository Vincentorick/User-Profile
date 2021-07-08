package com.jteam2.utils;

import com.alibaba.fastjson.JSONObject;
import com.jteam2.service.HBaseService;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.apache.hadoop.conf.Configuration;


import java.io.IOException;
import org.apache.hadoop.hbase.HBaseConfiguration;

import java.util.*;
import javax.annotation.Resource;

@Component
public class HBaseUtil {
    @Resource
    private HBaseService hBaseService;

    private static HBaseConfiguration hbaseConfig=null;

    public static String [] fields = {"gender", "star", "customAsk", "age-step",
            "avgPrice", "maxPerOrder", "origin", "politicalFace",
            "costForce_n", "frequency", "discount_n", "nationality",
            "paymentCode", "buyFrequency", "logFrequency",
            "marriage", "browserTime", "browsingPeriod",
            "job", "recent", "email", "machineType","username","back","change"};

    public Map<String, Map<String, String>> getResultScanner() {
        Map<String, Map<String, String>> res = hBaseService.getResultScanner("totalTable");
//        System.out.println("-----遍历查询全表内容-----");
//        res.forEach((k, value) -> {
//            System.out.println(k + "--->" + value);
//        });
        return res;
    }


    public List<Map<String, String>> getUserByRandom() {
        Map<String, Map<String, String>> info = getResultScanner();
        Iterator<Map.Entry<String, Map<String, String>>> entryIterator = info.entrySet().iterator();
        List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
        List<String> params = Arrays.asList(fields);

        int i = 0;
        while (entryIterator.hasNext() && i < 200) {
            ++i;
            Map.Entry<String, Map<String, String>> entry = entryIterator.next();
            Map<String, String> t = entry.getValue();
            for (String para : params) {
                if (!t.containsKey(para)) {
                    t.put(para, "");
                }
            }
            ret.add(t);

        }
        return ret;
    }



    public List<Map<String, String>> getUserByCondition(Map<String, String> condition) {
//        System.out.println(condition);
        if (condition.containsKey("paymentCode")) {
            if (condition.get("paymentCode").equals("支付宝")) {
                condition.put("paymentCode", "alipay");
            }
            else if (condition.get("paymentCode").equals("微信")) {
                condition.put("paymentCode", "wxpay");
            }
            else if (condition.get("paymentCode").equals("信用卡")) {
                condition.put("paymentCode", "cod");
            }
        }

        List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
        List<String> params = Arrays.asList(fields);


        Map<String, Map<String, String>> info = getResultScanner();
        Iterator<Map.Entry<String, Map<String, String>>> entryIterator = info.entrySet().iterator();

        while (entryIterator.hasNext()) {
            Map.Entry<String, Map<String, String>> entry = entryIterator.next();

            boolean flag = true;
            Map<String, String> t = entry.getValue();
//            System.out.println(t);
            for (String key : condition.keySet()) {
                String value = condition.get(key);
                if (!t.get(key).equals(value)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (String para : params) {
                    if (!t.containsKey(para)) {
                        t.put(para, "");
                    }
                }
                ret.add(t);
            }

        }

        return ret;
    }

    public Map<String, String> getUserByEmail(String email) {
        Map<String, Map<String, String>> info = getResultScanner();
        Iterator<Map.Entry<String, Map<String, String>>> entryIterator = info.entrySet().iterator();

        Map<String, String> ret = new HashMap<String, String>();

        while (entryIterator.hasNext()) {
            Map.Entry<String, Map<String, String>> entry = entryIterator.next();
            if (entry.getValue().get("email").equals(email)) {
//                System.out.println("get!!");
//                System.out.println(entry.getValue());
                ret = entry.getValue();
                break;
            }
        }

        List<String> params = Arrays.asList(fields);

        for (String para : params) {
            if (!ret.containsKey(para)) {
                ret.put(para, "");
            }
        }

        return ret;
    }


}
