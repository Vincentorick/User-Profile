package com.jteam2.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jteam2.entity.BasicTag;
import com.jteam2.mapper.BasicTagMapper;
import com.jteam2.mapper.MergeTagMapper;
import com.jteam2.utils.HBaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagService {

    @Autowired
    private BasicTagMapper basicTagMapper;

    @Autowired
    private MergeTagMapper mergeTagMapper;

    @Autowired
    private HBaseUtil hBaseUtil;

    public Map getTagMapping() {

        Map result = new HashMap();

        QueryWrapper<BasicTag> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("level", 1)
                .or()
                .eq("level", 2)
                .or()
                .eq("level", 3)
                .or()
                .eq("level", 4);

        List<BasicTag> getList =  basicTagMapper.selectList(queryWrapper);

        for (int i=0; i<getList.size(); ++i) {
            result.put(getList.get(i).getName(), getList.get(i).getId());
        }

        return result;

    }

    public List getLevel5Tag(Integer id) {

        Map query = new HashMap();
        query.put("pid", id);
        List list = basicTagMapper.selectByMap(query);

        return list;
    }

    public List getMergeTag() {
        List list = mergeTagMapper.selectList(null);
        return list;
    }

    /**
     * 标签搜索功能
     */
    public List searchTags(List params) {
        Map conditions = new HashMap();

        for (int i=0; i<params.size(); ++i) {
            Map selectCol = new HashMap();
            selectCol.put("name", params.get(i));
            BasicTag currTag = (BasicTag) basicTagMapper.selectByMap(selectCol).get(0);
            int currPid = currTag.getPid();
            // 拿着pid去找他的父亲
            selectCol.clear();
            selectCol.put("id", currPid);
            currTag = (BasicTag) basicTagMapper.selectByMap(selectCol).get(0);

            conditions.put(currTag.getEngname(), params.get(i));
        }

        List result = hBaseUtil.getUserByCondition(conditions);

        return result;
    }

    /**
     * random
     */
    public List getUser() {
        return hBaseUtil.getUserByRandom();
    }

}
