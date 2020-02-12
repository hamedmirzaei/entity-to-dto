package spring.boot.entity.dto.exception;

import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.enums.ResponseCode;
import spring.boot.entity.dto.enums.ResponseMessageKey;

public class UserException {

    @ErrorMessage(code = ResponseCode.USER_NOT_FOUND_ERROR, messageKey = ResponseMessageKey.USER_NOT_FOUND_ERROR)
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

    @ErrorMessage(code = ResponseCode.DUPLICATE_USERNAME_ERROR,
            messageKey = ResponseMessageKey.DUPLICATE_USERNAME_ERROR)
    public static class DuplicateUsernameException extends BaseException {
        private final String username;

        public DuplicateUsernameException(String username) {
            super(new Object[]{username});
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

}
