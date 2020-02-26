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

    public BusinessException(){}

    public BusinessException(String message){
        super(message);
    }
}

