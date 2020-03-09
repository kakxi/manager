package xft.abscloud.manager.enums;

public enum EventStatus {

    UN_ISSUE("0"),// 未发布
    ISSUED("1"),// 已发布
    CANCELED("2"),// 已取消
    FINISHED("3");// 已完成


    private String code;

    EventStatus(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
