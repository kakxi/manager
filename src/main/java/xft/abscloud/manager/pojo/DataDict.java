package xft.abscloud.manager.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "abs_data_dict")
public class DataDict {
    /**
     * 数据字典ID
     */
    private String id;

    /**
     * key
     */
    @Column(name = "dict_key")
    private String dictKey;

    @Column(name = "dict_value")
    private String dictValue;
    
    @Column(name = "desc")
    private String desc;

    /**
     * 获取数据字典ID
     *
     * @return id - 数据字典ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置数据字典ID
     *
     * @param id 数据字典ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取key
     *
     * @return dict_key - key
     */
    public String getDictKey() {
        return dictKey;
    }

    /**
     * 设置key
     *
     * @param dictKey key
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    /**
     * @return dict_value
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * @param dictValue
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}