package xft.abscloud.manager.enums;

public enum InvoiceStatusEnum {

	UN_INVOICED("000","未开发票"),
	
	INVOICED("001","已开发票");
	
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

	InvoiceStatusEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
