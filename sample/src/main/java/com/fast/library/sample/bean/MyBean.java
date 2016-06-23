package com.fast.library.sample.bean;

import com.fast.library.bean.Pojo;

import java.util.List;

/**
 * 说明：MyBean
 * <p>
 * 作者：fanly
 * <p>
 * 时间：2016/5/11 10:50
 * <p>
 * 版本：verson 1.0
 */
public class MyBean extends Pojo {
    private int status;
    private String message;
    private List<Result> result ;

    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setResult(List<Result> result){
        this.result = result;
    }
    public List<Result> getResult(){
        return this.result;
    }
    public class Result{
        private int id;

        private String title;

        private String address;

        private String lng;

        private String lat;

        private int minimums;

        private int votes;

        private String attach;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
        public void setAddress(String address){
            this.address = address;
        }
        public String getAddress(){
            return this.address;
        }
        public void setLng(String lng){
            this.lng = lng;
        }
        public String getLng(){
            return this.lng;
        }
        public void setLat(String lat){
            this.lat = lat;
        }
        public String getLat(){
            return this.lat;
        }
        public void setMinimums(int minimums){
            this.minimums = minimums;
        }
        public int getMinimums(){
            return this.minimums;
        }
        public void setVotes(int votes){
            this.votes = votes;
        }
        public int getVotes(){
            return this.votes;
        }
        public void setAttach(String attach){
            this.attach = attach;
        }
        public String getAttach(){
            return this.attach;
        }
    }
}
