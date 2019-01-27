package com.whgc.pojo;

public class News {
    private Integer id;

    private Integer uid;

    private Integer newsSum;

    private String msg;

    private String sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNewsSum() {
        return newsSum;
    }

    public void setNewsSum(Integer newsSum) {
        this.newsSum = newsSum;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }
}