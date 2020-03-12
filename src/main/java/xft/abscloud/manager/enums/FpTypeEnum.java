package xft.abscloud.manager.enums;

public enum FpTypeEnum {
	
	ELECTRONIC_GENERAL_INVOICE("00","增值税电子普通发票"),
	
	PAPER_GENERAL_INVOICE("01","增值税纸质普通发票"),
	
	PAPER_SPECIAL_INVOICE("02","增值税纸质专用发票");
	
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

	FpTypeEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
