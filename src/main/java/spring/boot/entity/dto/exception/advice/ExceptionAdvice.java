package spring.boot.entity.dto.exception.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.enums.MessageCodeType;
import spring.boot.entity.dto.exception.AddressException;
import spring.boot.entity.dto.exception.UserException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(UserException.NotFoundException.class)
    public EntityDtoResponse handleUserNotFoundException(UserException.NotFoundException ex) {
        return new EntityDtoResponse(MessageCodeType.USER_NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(UserException.DuplicateUsernameException.class)
    public EntityDtoResponse handleDuplicateUsernameException(UserException.DuplicateUsernameException ex) {
        return new EntityDtoResponse(MessageCodeType.DUPLICATE_USERNAME, ex.getMessage());
    }

    @ExceptionHandler(AddressException.NotFoundException.class)
    public EntityDtoResponse handleAddressNotFoundException(AddressException.NotFoundException ex) {
        return new EntityDtoResponse(MessageCodeType.ADDRESS_NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(AddressException.PersistException.class)
    public EntityDtoResponse handleAddressPersistException(AddressException.PersistException ex) {
        return new EntityDtoResponse(MessageCodeType.ADDRESS_PERSIST_ERROR, ex.getMessage());
    }

}
