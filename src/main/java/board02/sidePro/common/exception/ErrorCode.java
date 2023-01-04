package board02.sidePro.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    NOT_SUCH_ELEMENT_ERROR(422,"10001","NOT_SUCH_ELEMENT_ERROR"),
    INVALID_JOIN_ID(422,"20002","INVALID_JOIN_ID"),
    INVALID_JOIN_NICKNAME(422,"20003","INVALID_JOIN_NICKNAME"),;

    private int status;

    private String errorCode;

    private String message;


}
