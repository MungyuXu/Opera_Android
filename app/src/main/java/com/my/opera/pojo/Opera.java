package com.my.opera.pojo;

public class Opera {
    private  int id;
    private  int userId;
    private  int operaId;
    private  String operaName;
    private  String operaInfo;
    private String operaImg;

    public Opera() {
    }

    public Opera(int id, int userId, int operaId, String operaName, String operaInfo, String operaImg) {
        this.id = id;
        this.userId = userId;
        this.operaId = operaId;
        this.operaName = operaName;
        this.operaInfo = operaInfo;
        this.operaImg = operaImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOperaId() {
        return operaId;
    }

    public void setOperaId(int operaId) {
        this.operaId = operaId;
    }

    public String getOperaName() {
        return operaName;
    }

    public void setOperaName(String operaName) {
        this.operaName = operaName;
    }

    public String getOperaInfo() {
        return operaInfo;
    }

    public void setOperaInfo(String operaInfo) {
        this.operaInfo = operaInfo;
    }

    public String getOperaImg() {
        return operaImg;
    }

    public void setOperaImg(String operaImg) {
        this.operaImg = operaImg;
    }
}
