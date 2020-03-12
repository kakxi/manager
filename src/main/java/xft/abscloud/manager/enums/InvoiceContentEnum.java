package xft.abscloud.manager.enums;

public enum InvoiceContentEnum {

	
	INVOICE_CONTENT_01("01","服务费"),
	
	INVOICE_CONTENT_02("02","技术服务费");
	
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

	InvoiceContentEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
