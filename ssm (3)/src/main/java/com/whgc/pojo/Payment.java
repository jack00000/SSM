package com.whgc.pojo;

public class Payment {
    private Integer id;

    private Integer pid;

    private String payMan;

    private String getMan;

    private String payNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPayMan() {
        return payMan;
    }

    public void setPayMan(String payMan) {
        this.payMan = payMan == null ? null : payMan.trim();
    }

    public String getGetMan() {
        return getMan;
    }

    public void setGetMan(String getMan) {
        this.getMan = getMan == null ? null : getMan.trim();
    }

    public String getPayNum() {
        return payNum;
    }

    public void setPayNum(String payNum) {
        this.payNum = payNum == null ? null : payNum.trim();
    }
}