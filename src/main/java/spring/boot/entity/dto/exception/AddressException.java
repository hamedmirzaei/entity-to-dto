package spring.boot.entity.dto.exception;

import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.enums.ErrorCode;

public class AddressException {

    private AddressException() {
    }

    @ErrorMessage(code = ErrorCode.ADDRESS_NOT_FOUND)
    public static class NotFoundException extends BaseException {
        private final Long id;

        public NotFoundException(Long id) {
            super("Address not found with id = " + id);
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    @ErrorMessage(code = ErrorCode.ADDRESS_PERSIST_ERROR)
    public static class PersistException extends BaseException {
        public PersistException() {
            super("Persist exception during saving address");
        }
    }

}
