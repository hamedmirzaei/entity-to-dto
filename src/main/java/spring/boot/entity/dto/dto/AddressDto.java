package spring.boot.entity.dto.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @NotNull
    @ApiModelProperty(notes = "city name")
    private String city;
    @ApiModelProperty(notes = "street name")
    private String street;
    @ApiModelProperty(notes = "alley name")
    private String alley;
    @ApiModelProperty(notes = "floor number")
    private Integer floor;
    @ApiModelProperty(notes = "house number")
    private Integer number;
    @ApiModelProperty(notes = "postal code")
    private String postalCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
