package com.example.nutritional.bean.safety;

import java.util.List;

/**
 * @author 69182
 */
public
class GetAllWaterQualityInfo {

    /**
     * waterQualityInfos : [{"id":1,"dateOfSampling":"2020-07-09T00:00:00","ph":7.6,"comprehensiveEvaluation":"良","remark":null,"image":null},{"id":2,"dateOfSampling":"2020-07-09T13:29:53.387","ph":3.5,"comprehensiveEvaluation":"good","remark":"kkk","image":"File/Uploads/2020-07-09.jpg"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-09T13:30:49.2574132+08:00
     */

    private int statusCode;
    private String message;
    private String currentTime;
    private List<WaterQualityInfosBean> waterQualityInfos;

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

    public List<WaterQualityInfosBean> getWaterQualityInfos() {
        return waterQualityInfos;
    }

    public void setWaterQualityInfos(List<WaterQualityInfosBean> waterQualityInfos) {
        this.waterQualityInfos = waterQualityInfos;
    }

    public static class WaterQualityInfosBean {
        /**
         * id : 1
         * dateOfSampling : 2020-07-09T00:00:00
         * ph : 7.6
         * comprehensiveEvaluation : 良
         * remark : null
         * image : null
         */

        private int id;
        private String dateOfSampling;
        private double ph;
        private String comprehensiveEvaluation;
        private Object remark;
        private Object image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDateOfSampling() {
            return dateOfSampling;
        }

        public void setDateOfSampling(String dateOfSampling) {
            this.dateOfSampling = dateOfSampling;
        }

        public double getPh() {
            return ph;
        }

        public void setPh(double ph) {
            this.ph = ph;
        }

        public String getComprehensiveEvaluation() {
            return comprehensiveEvaluation;
        }

        public void setComprehensiveEvaluation(String comprehensiveEvaluation) {
            this.comprehensiveEvaluation = comprehensiveEvaluation;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }
    }
}
