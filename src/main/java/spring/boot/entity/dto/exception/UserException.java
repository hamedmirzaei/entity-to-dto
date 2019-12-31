package spring.boot.entity.dto.exception;

import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.enums.ErrorCode;

public class UserException {

    @ErrorMessage(code = ErrorCode.USER_NOT_FOUND, messageKey = "exception.user.not.found")
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

    @ErrorMessage(code = ErrorCode.DUPLICATE_USERNAME, messageKey = "exception.user.duplicate.username")
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
