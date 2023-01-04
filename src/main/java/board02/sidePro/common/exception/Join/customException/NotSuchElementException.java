package board02.sidePro.common.exception.Join.customException;

import board02.sidePro.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotSuchElementException extends RuntimeException{

    private ErrorCode errorCode;

    public NotSuchElementException(String message, ErrorCode errorCode){
        super(message);
    }
}
