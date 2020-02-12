package spring.boot.entity.dto.api.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * the reason for not using lombok for getter and setters is because of mappers which have problem with it
 */
public class SaveAddressRequest {

    @NotNull
    @Size(min = 2)
    private String city;

    private String street;

    private String alley;

    private Integer floor;

    private Integer number;

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
