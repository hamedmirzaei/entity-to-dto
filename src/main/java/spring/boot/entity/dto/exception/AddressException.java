package spring.boot.entity.dto.exception;

import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.enums.ResponseCode;
import spring.boot.entity.dto.enums.ResponseMessageKey;

public class AddressException {

    private AddressException() {
    }

    @ErrorMessage(code = ResponseCode.ADDRESS_NOT_FOUND_ERROR,
            messageKey = ResponseMessageKey.ADDRESS_NOT_FOUND_ERROR)
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
