package ${packgeName}.framework.exception;

/**   
 * @formatClassName:  CommonDefineException
 * @Description:TODO 自定义异常返回信息
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public class CommonDefineException extends RuntimeException{
    private static final long serialVersionUID = -5519743897907627214L;

    private String exceptionCode;

    public CommonDefineException(String code, String msg){
        super(msg);
        this.exceptionCode = code;
    }
    
    public CommonDefineException(String msg) {
    	super(msg);
    	this.exceptionCode = "500";
    }
    
    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
