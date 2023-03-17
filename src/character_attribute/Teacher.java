package character_attribute;

import lombok.Data;

import java.util.List;


@Data
public class Teacher extends Staff{
    private List<String> course;
}
