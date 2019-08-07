package lifeapplication.demo.controllers.exceptionhanlers.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class NotFoundRuntimeException extends RuntimeException {

    private Long id;
    private String message;

    public NotFoundRuntimeException(Long id, String message) {
        super(message);
        this.id = id;
        this.message = message;
        log.error("Can't find resource with id {}", id);
    }
}
