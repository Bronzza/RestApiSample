package lifeapplication.demo.controllers.exceptionhanlers;

import lifeapplication.demo.controllers.exceptionhanlers.exceptions.NotFoundRuntimeException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class BaseHandler {

    @ExceptionHandler(NotFoundRuntimeException.class)
    public BaseResponse handleNotFoundRuntimeException(NotFoundRuntimeException exception) {
        return BaseResponse.buildErrorResponse(404, exception.getMessage());
    }

    @Getter
    @Setter
    private static class BaseResponse {
        private int errorCode = 200;
        private boolean success = true;
        private String errorMessage;

        public static BaseResponse buildErrorResponse(int errorCode, String errorMessage) {
            BaseResponse response = new BaseResponse();
            response.setSuccess(false);
            response.setErrorMessage(errorMessage);
            response.setErrorCode(errorCode);
            return response;
        }
    }
}
