package spring.boot.entity.dto.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
/**
 * the reason for not using lombok for getter and setters is because of mappers which have problem with it
 */
public class UserDto implements Serializable {

    @ApiModelProperty(notes = "first name concatenated by last name of user")
    private String fullName;

    @ApiModelProperty(notes = "username of user")
    private String username;

    @ApiModelProperty(notes = "password of user")
    private String password;

    @ApiModelProperty(notes = "address of user")
    private AddressDto addressDto;

    @ApiModelProperty(notes = "skills of user separated by comma")
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

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
