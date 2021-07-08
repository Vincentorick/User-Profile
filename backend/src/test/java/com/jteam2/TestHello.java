package com.jteam2;

import com.jteam2.service.TagService;
import com.jteam2.service.UserProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestHello {

    @Autowired
    private TagService tagService;

    @Autowired
    private UserProfileService userProfileService;

    @Test
    public void testGetTag5Service() {
        List list = tagService.getLevel5Tag(45);
        list.forEach(System.out::println);
    }

    @Test
    public void testUserProfile() {
        // "uc8gl3@yahoo.com.cn"
        System.out.println(userProfileService.getUserProfileList("uc8gl3@yahoo.com.cn"));
    }

    @Test
    public void testSearchTags() {
       List p = new ArrayList();
       p.add("北京");
       p.add("党员");
       p.add("支付宝");
       System.out.println(tagService.searchTags(p));

        // Map map = new HashMap();
        // map.put("政治面貌", "党员");
        // map.put("支付方式", "支付宝");
        // System.out.println(map);
    }

    @Test
    public void testGetUser() {
        System.out.println(tagService.getUser());
    }

}
