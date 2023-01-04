package board02.sidePro.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorResponse {
    private String message; // 예외 메시지 저장
    private String code; // 사용자 지정 코드

    private int status;
   public ErrorResponse(ErrorCode errorCode){
       this.status = errorCode.getStatus();
       this.code = errorCode.getErrorCode();
       this.message = errorCode.getMessage();
   }
}
