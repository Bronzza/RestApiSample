package lifeapplication.demo.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class SectionDto extends BaseDto {

    private String name;

    private Long courseId;
}
