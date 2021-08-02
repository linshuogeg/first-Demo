package com.example.usercenterq.protocol.req;

import java.util.List;

public class BannerEntity {
    /**
     * status : 1
     * code : 200
     * data : [{"title":"图片1","image":"//vueshop.glbuys.com/uploadfiles/1484285302.jpg","webs":"#"},{"title":"图片2","image":"//vueshop.glbuys.com/uploadfiles/1484285334.jpg","webs":"#"},{"title":"图片3","image":"//vueshop.glbuys.com/uploadfiles/1524206455.jpg","webs":"#"}]
     */

    private int status;
    private int code;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }


    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 图片1
         * image : //vueshop.glbuys.com/uploadfiles/1484285302.jpg
         * webs : #
         */

        private String title;
        private String image;
        private String webs;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getWebs() {
            return webs;
        }

        public void setWebs(String webs) {
            this.webs = webs;
        }
    }
}
