package com.example.nutritional.bean.food;

/**
 * @author 69182
 */
public
class AddCookBook {

    /**
     * statusCode : 200
     * message : 添加成功
     * returnTime : 2020-07-05T15:45:25.0067383+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;

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

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
}
