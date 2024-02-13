package com.wzcy.cr_test.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class UserInfo {


    private int loginId;
    private  String passWord;
    private Date validPeriodStart;
    private Date validPeriodEnd;
    private Date registrationDate;
    private  Date updateDate;

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getValidPeriodStart() {
        return validPeriodStart;
    }

    public void setValidPeriodStart(Date validPeriodStart) {
        this.validPeriodStart = validPeriodStart;
    }

    public Date getValidPeriodEnd() {
        return validPeriodEnd;
    }

    public void setValidPeriodEnd(Date validPeriodEnd) {
        this.validPeriodEnd = validPeriodEnd;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "loginId=" + loginId +
                ", passWord='" + passWord + '\'' +
                ", validPeriodStart=" + validPeriodStart +
                ", validPeriodEnd=" + validPeriodEnd +
                ", registrationDate=" + registrationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
