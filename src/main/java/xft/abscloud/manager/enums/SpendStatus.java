package xft.abscloud.manager.enums;

public enum SpendStatus {

    CANCELED("1"),// 已取消
    FINISHED("0");// 已完成


    private String code;

    SpendStatus(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
