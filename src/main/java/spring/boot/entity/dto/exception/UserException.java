package spring.boot.entity.dto.exception;

public class UserException {

    public static class NotFoundException extends Exception {
        private Long id;

        public NotFoundException(Long id) {
            super("User not found with id = " + id);
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    public static class DuplicateUsernameException extends Exception {
        private String username;

        public DuplicateUsernameException(String username) {
            super("User with username=" + username + " already exist");
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

}
