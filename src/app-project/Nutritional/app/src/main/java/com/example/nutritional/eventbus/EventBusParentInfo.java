package com.example.nutritional.eventbus;

/**
 * @author 69182
 */
public
class EventBusParentInfo {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    String userName;

    public EventBusParentInfo(String userName) {
        this.userName = userName;
    }
}
