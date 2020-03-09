package xft.abscloud.manager.enums;

public enum PayResultEnum {

	FINISHED("00", "已完成"),

	UN_FINISHED("01", "未完成");

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

	PayResultEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
