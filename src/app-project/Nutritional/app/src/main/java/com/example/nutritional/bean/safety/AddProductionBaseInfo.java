package com.example.nutritional.bean.safety;

/**
 * @author 69182
 */
public
class AddProductionBaseInfo {

    /**
     * statusCode : 0
     * message : string
     * currentTime : 2020-07-08T04:39:44.541Z
     */

    private int statusCode;
    private String message;
    private String currentTime;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
