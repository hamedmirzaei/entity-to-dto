package spring.boot.entity.dto.exception;

import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.enums.ErrorCode;

public class AddressException {

    private AddressException() {
    }

    @ErrorMessage(code = ErrorCode.ADDRESS_NOT_FOUND, messageKey = "exception.address.not.found")
    public static class NotFoundException extends BaseException {
        private final Long id;

        public NotFoundException(Long id) {
            super(new Object[]{id});
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

}
