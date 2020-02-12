package spring.boot.entity.dto.api.requests;

import org.hibernate.validator.constraints.Length;
import spring.boot.entity.dto.annotations.UsernameNotInPassword;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@UsernameNotInPassword
/**
 * the reason for not using lombok for getter and setters is because of mappers which have problem with it
 */
public class SaveUserRequest {

    @NotNull
    private String fullName;

    @NotNull
    @Size(min = 5)
    private String username;

    @NotNull
    @Length(min = 5, max = 15)
    private String password;

    @Valid
    private SaveAddressRequest saveAddressRequest;

    private String skills;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SaveAddressRequest getSaveAddressRequest() {
        return saveAddressRequest;
    }

    public void setSaveAddressRequest(SaveAddressRequest saveAddressRequest) {
        this.saveAddressRequest = saveAddressRequest;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
