package xft.abscloud.manager.enums;

public enum OrderStatusEnum {

	UN_PAY("0","未支付"),
	
	PAY("1","已支付"),
	
	CANCEL("2","已取消");
	
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

	OrderStatusEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	
}
