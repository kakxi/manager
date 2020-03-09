package xft.abscloud.manager.enums;

public enum ApplyEnum {

	UN_APPLY("0","未审核"),
	
	APPLY("1","审核通过"),
	
	REFUSED("2","审核拒绝");
	
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

	ApplyEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	
}
