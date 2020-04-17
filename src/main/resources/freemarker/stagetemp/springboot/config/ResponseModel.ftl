package ${packgeName}.framework.config;
/**   
 * @ClassName:  ResponseModel   
 * @Description:TODO 接口返回封装
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public class ResponseModel {

    private String code;
    
    private String desc;
    
    private Object data;
    
    public ResponseModel(String code, String desc, Object data) {
    	this.code = code;
    	this.desc = desc;
    	this.data = data;
    }
    
    public ResponseModel() {
    	// TODO
    }
    
    public static ResponseModel success() {
    	return new ResponseModel("200", null, null);
    }
    public static ResponseModel success(String desc) {
    	return new ResponseModel("200", desc, null);
    }
    public static ResponseModel success(Object data) {
    	return new ResponseModel("200", null, data);
    }
    public static ResponseModel success(String desc, Object data) {
    	return new ResponseModel("200", desc, data);
    }
    public static ResponseModel fail() {
    	return new ResponseModel("900", null, null);
    }
    public static ResponseModel fail(String desc) {
    	return new ResponseModel("900", desc, null);
    }
    public static ResponseModel fail(Object data) {
    	return new ResponseModel("900", null, data);
    }
    public static ResponseModel fail(String desc, Object data) {
    	return new ResponseModel("900", desc, data);
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
	@Override
	public String toString() {
		return "ResponseModel [code=" + code + ", desc=" + desc + ", data=" + data + "]";
	}
	
}
