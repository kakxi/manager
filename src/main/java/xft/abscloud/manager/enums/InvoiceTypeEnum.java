package xft.abscloud.manager.enums;

public enum InvoiceTypeEnum {

	PERSONAL("001","个人或事业单位"),
	
	ENTERPRISE("002","企业");
	
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

	InvoiceTypeEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
