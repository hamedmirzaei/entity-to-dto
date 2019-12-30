package spring.boot.entity.dto.exception;

import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.enums.ErrorCode;

public class UserException {

    @ErrorMessage(code = ErrorCode.USER_NOT_FOUND)
    public static class NotFoundException extends BaseException {
        private final Long id;

        public NotFoundException(Long id) {
            super("User not found with id = " + id);
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    @ErrorMessage(code = ErrorCode.DUPLICATE_USERNAME)
    public static class DuplicateUsernameException extends BaseException {
        private final String username;

        public DuplicateUsernameException(String username) {
            super("User with username=" + username + " already exist");
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

}
