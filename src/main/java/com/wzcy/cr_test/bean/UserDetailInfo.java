package com.wzcy.cr_test.bean;

import java.util.Date;

public class UserDetailInfo {


    private int loginId;
    private String userName;
    private   int userRoleCode;
    private   String address;
    private  int tel;
    private Date updateDate;


    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserRoleCode() {
        return userRoleCode;
    }

    public void setUserRoleCode(int userRoleCode) {
        this.userRoleCode = userRoleCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }



    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserDetailInfo{" +
                "loginId=" + loginId +
                ", userName='" + userName + '\'' +
                ", userRoleCode=" + userRoleCode +
                ", address='" + address + '\'' +
                ", tel=" + tel +
                ", updateDate=" + updateDate +
                '}';
    }
}
