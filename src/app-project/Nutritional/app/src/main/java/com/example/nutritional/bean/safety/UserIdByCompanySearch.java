package com.example.nutritional.bean.safety;

import java.util.List;

/**
 * @author 69182
 */
public
class UserIdByCompanySearch {

    /**
     * companyInfos : [{"id":1,"name":"云霄张二三长途货运有限公司","address":"福建省漳州市云霄县","responsibleName":"张三三","telephone":"14568678423"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-09T10:06:17.8238233+08:00
     */

    private int statusCode;
    private String message;
    private String currentTime;
    private List<CompanyInfosBean> companyInfos;

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

    public List<CompanyInfosBean> getCompanyInfos() {
        return companyInfos;
    }

    public void setCompanyInfos(List<CompanyInfosBean> companyInfos) {
        this.companyInfos = companyInfos;
    }

    public static class CompanyInfosBean {
        /**
         * id : 1
         * name : 云霄张二三长途货运有限公司
         * address : 福建省漳州市云霄县
         * responsibleName : 张三三
         * telephone : 14568678423
         */

        private int id;
        private String name;
        private String address;
        private String responsibleName;
        private String telephone;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getResponsibleName() {
            return responsibleName;
        }

        public void setResponsibleName(String responsibleName) {
            this.responsibleName = responsibleName;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }
    }
}
