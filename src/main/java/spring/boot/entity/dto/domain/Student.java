package spring.boot.entity.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
}
