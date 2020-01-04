package spring.boot.entity.dto.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    @NotNull
    @ApiModelProperty(notes = "first name concatenated by last name of user")
    private String fullName;
    @NotNull
    @ApiModelProperty(notes = "username of user")
    private String username;
    @NotNull
    @Length(min = 5, max = 15)
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
