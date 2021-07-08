package com.jteam2.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "tbl_merge_tag")
public class MergeTag {

    private Integer id;
    private String name;
    private String conditions;
    private String intro;
    private String purpose;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
