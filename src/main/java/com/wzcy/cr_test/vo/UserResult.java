package com.wzcy.cr_test.vo;

public class UserResult {
    private int code;
    private String message;
    private Object data;


    public static UserResult ok(Object... data) {
        UserResult result = new UserResult();
        result.setCode(200);
        result.setMessage("成功");
        if (data.length == 0) {
            result.setData(null);
        } else {
            result.setData(data[0]);
        }
        return result;
    }


    public static UserResult error(String... message) {
        UserResult result = new UserResult();
        result.setCode(500);
        if (message.length == 0) {
            result.setMessage("失败");
        } else {
            result.setMessage(message[0]);
        }
        result.setData(null);
        return result;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
