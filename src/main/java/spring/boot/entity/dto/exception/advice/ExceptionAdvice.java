package spring.boot.entity.dto.exception.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.boot.entity.dto.dto.Response;
import spring.boot.entity.dto.enums.MessageCodeType;
import spring.boot.entity.dto.exception.AddressException;
import spring.boot.entity.dto.exception.UserException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(UserException.NotFoundException.class)
    public Response handleUserNotFoundException(UserException.NotFoundException ex) {
        return new Response(MessageCodeType.USER_NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(UserException.DuplicateUsernameException.class)
    public Response handleDuplicateUsernameException(UserException.DuplicateUsernameException ex) {
        return new Response(MessageCodeType.DUPLICATE_USERNAME, ex.getMessage());
    }

    @ExceptionHandler(AddressException.NotFoundException.class)
    public Response handleAddressNotFoundException(AddressException.NotFoundException ex) {
        return new Response(MessageCodeType.ADDRESS_NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(AddressException.PersistException.class)
    public Response handleAddressPersistException(AddressException.PersistException ex) {
        return new Response(MessageCodeType.ADDRESS_PERSIST_ERROR, ex.getMessage());
    }

}
