package spring.boot.entity.dto.exception;

public class AddressException {

    public static class NotFoundException extends Exception {
        private Long id;

        public NotFoundException(Long id) {
            super("Address not found with id = " + id);
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    public static class PersistException extends Exception {
        public PersistException() {
            super("Persist exception during saving address");
        }
    }

}
