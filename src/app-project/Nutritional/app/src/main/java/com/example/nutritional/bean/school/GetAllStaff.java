package com.example.nutritional.bean.school;

import java.util.List;

/**
 * @author 69182
 */
public class GetAllStaff {

    /**
     * staff : [{"id":3,"staffName":"李四","telephone":"13691382489","image":"File/Uploads/李四.jpg","position":"漳州职业技术学院-第一食堂-负责人"},{"id":4,"staffName":"于学忠","telephone":"13577608888","image":"File/Uploads/于学忠.jpg","position":"漳州职业技术学院-第一食堂-采购员"},{"id":5,"staffName":"马连良","telephone":"13213245432","image":"File/Uploads/马连良.jpg","position":"漳州职业技术学院-第一食堂-采购员"},{"id":6,"staffName":"胡宝善","telephone":"13213244432","image":"File/Uploads/胡宝善.jpg","position":"漳州职业技术学院-第一食堂-采购员"},{"id":7,"staffName":"李宗仁","telephone":"18735318888","image":"File/Uploads/李宗仁.jpg","position":"漳州职业技术学院-第一食堂-采购员"},{"id":8,"staffName":"洪学智","telephone":"15815179846","image":"File/Uploads/洪学智.jpg","position":"漳州职业技术学院-第二食堂-采购员"},{"id":9,"staffName":"余克勤","telephone":"15652152727","image":"File/Uploads/余克勤.jpg","position":"漳州职业技术学院-第二食堂-采购员"},{"id":10,"staffName":"吴克俭","telephone":" 15140454253 ","image":"File/Uploads/吴克俭.jpg","position":"漳州职业技术学院-第二食堂-负责人"},{"id":11,"staffName":"杨惟义","telephone":" 15234524706 ","image":"File/Uploads/杨惟义.jpg","position":"漳州职业技术学院-第二食堂-采购员"},{"id":12,"staffName":"李文信","telephone":"15834794444","image":"File/Uploads/李文信.jpg","position":"漳州职业技术学院-第二食堂-采购员"},{"id":13,"staffName":"王德茂","telephone":"15000777752","image":"File/Uploads/王德茂.jpg","position":"漳州职业技术学院-第二食堂-采购员"},{"id":14,"staffName":"李书诚","telephone":"13902778883","image":"File/Uploads/李书诚.jpg","position":"漳州职业技术学院-第二食堂-采购员"},{"id":15,"staffName":"杨勇","telephone":"13902790108","image":"File/Uploads/杨勇.jpg","position":"福州职业技术学院-第一食堂-采购员"},{"id":16,"staffName":"高尚德","telephone":"13902701832","image":"File/Uploads/高尚德.jpg","position":"福州职业技术学院-第一食堂-采购员"},{"id":17,"staffName":"刁富贵","telephone":"13113141314","image":"File/Uploads/刁富贵.jpg","position":"福州职业技术学院-第一食堂-采购员"},{"id":18,"staffName":"汤念祖","telephone":"13693357480","image":"File/Uploads/汤念祖.jpg","position":"福州职业技术学院-第一食堂-负责人"},{"id":19,"staffName":"吕奉先","telephone":"18870881867","image":"File/Uploads/吕奉先.jpg","position":"福州职业技术学院-第一食堂-洗碗工"},{"id":20,"staffName":"何光宗","telephone":"15590085523","image":"File/Uploads/何光宗.jpg","position":"福州职业技术学院-第二食堂-采购员"},{"id":21,"staffName":"冷德友","telephone":"13905678673","image":"File/Uploads/冷德友.jpg","position":"福州职业技术学院-第二食堂-采购员"},{"id":22,"staffName":"安怡孙","telephone":" 18874838565 ","image":"File/Uploads/安怡孙.jpg","position":"福州职业技术学院-第二食堂-采购员"},{"id":23,"staffName":"贾德善","telephone":" 15769000120 ","image":"File/Uploads/贾德善.jpg","position":"福州职业技术学院-第二食堂-采购员"},{"id":24,"staffName":"蔡德霖","telephone":"13784880245","image":"File/Uploads/蔡德霖.jpg","position":"福州职业技术学院-第二食堂-负责人"},{"id":25,"staffName":"关仁","telephone":"13903186655","image":"File/Uploads/关仁.jpg","position":"厦门海洋职业技术学院-第一食堂-采购员"},{"id":26,"staffName":"孙天民","telephone":"15367485395","image":"File/Uploads/孙天民.jpg","position":"厦门海洋职业技术学院-第一食堂-采购员"},{"id":27,"staffName":"赵大华","telephone":"13903186615","image":"File/Uploads/赵大华.jpg","position":"厦门海洋职业技术学院-第一食堂-采购员"},{"id":28,"staffName":"赵进喜","telephone":"15713939555","image":"File/Uploads/赵进喜.jpg","position":"厦门海洋职业技术学院-第一食堂-采购员"},{"id":29,"staffName":"赵德荣","telephone":" 18236066456 ","image":"File/Uploads/赵德荣.jpg","position":"厦门海洋职业技术学院-第一食堂-采购员"},{"id":30,"staffName":"赵德茂","telephone":"18239367654","image":"File/Uploads/赵德茂.jpg","position":"厦门海洋职业技术学院-第二食堂-采购员"},{"id":31,"staffName":"钱汉祥","telephone":"15868807180","image":"File/Uploads/钱汉祥.jpg","position":"厦门海洋职业技术学院-第二食堂-采购员"},{"id":32,"staffName":"钱运高","telephone":"15971345672","image":"File/Uploads/钱运高.jpg","position":"厦门海洋职业技术学院-第二食堂-采购员"},{"id":33,"staffName":"钱生禄","telephone":"13600322949","image":"File/Uploads/钱生禄.jpg","position":"厦门海洋职业技术学院-第二食堂-负责人"},{"id":34,"staffName":"孙寿康","telephone":"13424392181","image":"File/Uploads/孙寿康.jpg","position":"厦门海洋职业技术学院-第一食堂-负责人"},{"id":35,"staffName":"彭震川","telephone":"15856040835","image":"File/Uploads/彭震川.png","position":"收银员"}]
     * statusCode : 200
     * message : 获取成功
     * returnTime : 2020-07-16T12:58:32.9472091+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<StaffBean> staff;

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

    public List<StaffBean> getStaff() {
        return staff;
    }

    public void setStaff(List<StaffBean> staff) {
        this.staff = staff;
    }

    public static class StaffBean {
        /**
         * id : 3
         * staffName : 李四
         * telephone : 13691382489
         * image : File/Uploads/李四.jpg
         * position : 漳州职业技术学院-第一食堂-负责人
         */

        private int id;
        private String staffName;
        private String telephone;
        private String image;
        private String position;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStaffName() {
            return staffName;
        }

        public void setStaffName(String staffName) {
            this.staffName = staffName;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
}
