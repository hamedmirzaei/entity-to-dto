package spring.boot.entity.dto.exception;

public class BaseException extends Exception {

    Object[] args;

    public BaseException(Object[] args) {
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }
}
