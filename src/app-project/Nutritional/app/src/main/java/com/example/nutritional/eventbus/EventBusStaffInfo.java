package com.example.nutritional.eventbus;

/**
 * @author 69182
 */
public
class EventBusStaffInfo {
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    String staffName;

    public EventBusStaffInfo(String staffName) {
        this.staffName = staffName;
    }
}
