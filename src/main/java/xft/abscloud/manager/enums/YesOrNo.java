package xft.abscloud.manager.enums;

public enum YesOrNo {

    YES("1"),NO("0");

    private String code;

    YesOrNo(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
