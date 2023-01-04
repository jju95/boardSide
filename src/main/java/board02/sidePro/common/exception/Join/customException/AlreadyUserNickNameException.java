package board02.sidePro.common.exception.Join.customException;

import board02.sidePro.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class AlreadyUserNickNameException extends RuntimeException{

    private ErrorCode errorCode;

    public AlreadyUserNickNameException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
