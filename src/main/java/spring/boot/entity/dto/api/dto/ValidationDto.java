package spring.boot.entity.dto.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationDto {

    Map<String, String> fieldErrors;
    List<String> globalErrors;

}
