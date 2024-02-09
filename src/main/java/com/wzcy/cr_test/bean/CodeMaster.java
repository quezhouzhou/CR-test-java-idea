package com.wzcy.cr_test.bean;



public class CodeMaster {
private int codeId;
private  int userRoleCode;
private String roleName;


    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public int getUserRoleCode() {
        return userRoleCode;
    }

    public void setUserRoleCode(int userRoleCode) {
        this.userRoleCode = userRoleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "CodeMaster{" +
                "codeId=" + codeId +
                ", userRoleCode=" + userRoleCode +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
