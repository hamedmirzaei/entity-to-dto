package spring.boot.entity.dto.validators;

import spring.boot.entity.dto.annotations.UsernameNotInPassword;
import spring.boot.entity.dto.api.requests.SaveUserRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernamePasswordValidator implements ConstraintValidator<UsernameNotInPassword, SaveUserRequest> {
    @Override
    public boolean isValid(SaveUserRequest saveUserRequest, ConstraintValidatorContext constraintValidatorContext) {
        return !saveUserRequest.getPassword().toLowerCase().contains(saveUserRequest.getUsername().toLowerCase());
    }
}
