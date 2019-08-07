package lifeapplication.demo.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CourseDto extends BaseDto {

    private String name;

    private Long price;

    private Long beginDate;

    private Long endDate;

    private List<SectionDto> sections = new ArrayList<>();
}
