package board02.sidePro.common.exception.Join.customException;

import board02.sidePro.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class AlreadyUserException extends RuntimeException {

    private ErrorCode errorCode;

    public AlreadyUserException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
