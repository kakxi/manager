package xft.abscloud.manager.enums;

public enum PayTypeEnum {

	WX_PAY("0101", "微信支付"),

	ALIPAY("0102", "支付宝支付"),

	UN_ONLINE("02", "线下支付");

	private String key;

	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	PayTypeEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
