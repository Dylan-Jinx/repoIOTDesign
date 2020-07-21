package com.example.nutritional.data;

import org.litepal.crud.LitePalSupport;

/**
 * @author 69182
 */
public
class StudentIdea extends LitePalSupport {
    public StudentIdea(String name, String stuNo, String address, String parentName, String schoolName) {
        this.name = name;
        this.stuNo = stuNo;
        this.address = address;
        this.parentName = parentName;
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    String name;
    String stuNo;
    String address;
    String parentName;
    String schoolName;
}
