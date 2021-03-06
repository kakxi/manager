package xft.abscloud.manager.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String msg;
    
    public BusinessException(){}

    public BusinessException(String msg){
        super(msg);
        this.msg = msg;
    }
    
}

