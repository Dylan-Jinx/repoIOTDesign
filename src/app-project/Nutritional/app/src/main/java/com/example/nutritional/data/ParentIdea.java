package com.example.nutritional.data;

/**
 * @author 69182
 */
public
class ParentIdea {
    public ParentIdea(String parentName, String userName, String password, String childrenNum, String schoolName) {
        this.parentName = parentName;
        this.userName = userName;
        this.password = password;
        this.childrenNum = childrenNum;
        this.schoolName = schoolName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChildrenNum() {
        return childrenNum;
    }

    public void setChildrenNum(String childrenNum) {
        this.childrenNum = childrenNum;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    String parentName;
    String userName;
    String password;
    String childrenNum;
    String schoolName;
}
