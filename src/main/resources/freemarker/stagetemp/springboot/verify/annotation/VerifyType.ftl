package ${packgeName}.framework.verify.annotation;
/**   
 * @formatClassName:  VerifyType
 * @Description:TODO 区分操作业务场景
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public enum VerifyType {
	SELECT_ONE_1("S_ONE_1"),
	SELECT_ONE_2("S_ONE_2"),
	SELECT_ONE_3("S_ONE_3"),
	SELECT_LIST_1("S_LIST_1"),
	SELECT_LIST_2("S_LIST_2"),
	SELECT_LIST_3("S_LIST_3"),
	DELETE_1("DELETE_1"),
	DELETE_2("DELETE_2"),
	DELETE_3("DELETE_3"),
	ADD_1("ADD_1"),
	ADD_2("ADD_2"),
	ADD_3("ADD_3"),
	UPDATE_1("UPDATE_1"),
	UPDATE_2("UPDATE_2"),
	UPDATE_3("UPDATE_3");
	
	private String type;
	
	private VerifyType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
