package com.jteam2;

import com.jteam2.utils.HBaseUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestHB {

    @Autowired
    private HBaseUtil hBaseUtil;

    @Test
    public void testHBUtil() throws Exception {
        System.out.println("hello");
//        Map<String, Map<String, String>> res = hBaseUtil.getResultScanner();
//        System.out.println("-----遍历查询全表内容-----");
//        res.forEach((k, value) -> {
//            System.out.println(k + "--->" + value);
//        });

//        final Map<String, String>[] ret = new Map<String, String>[1];


//        Iterator<Map.Entry<String, Map<String, String>>> entryIterator = res.entrySet().iterator();

//       System.out.println(hBaseUtil.getUserByEmail("uc8gl3@yahoo.com.cn"));

        Map map = new HashMap();
        map.put("politicalFace", "党员");
        map.put("paymentCode", "支付宝");

        List<Map<String, String>> res = hBaseUtil.getUserByRandom();

        for (Map<String, String> t : res) {
            System.out.println(t);
        }

    }

}
