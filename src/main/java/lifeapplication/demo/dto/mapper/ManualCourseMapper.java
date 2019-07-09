package lifeapplication.demo.dto.mapper;

import lifeapplication.demo.dto.CourseDto;
import lifeapplication.demo.entities.CourseEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class ManualCourseMapper implements AbstractMapper<CourseEntity, CourseDto> {

    @Autowired
    private final ManualSectionMapper sectionMapper;

    @Override
    public CourseEntity toEntity(CourseDto dto) {
        CourseEntity courseEntity = new CourseEntity();
        return courseEntity.setName(dto.getName())
                .setPrice(dto.getPrice())
                .setSections(dto.getSections().stream()
                        .map(sectionMapper::toEntity)
                        .collect(Collectors.toList()));
    }

    @Override
    public CourseDto toDto(CourseEntity entity) {
        CourseDto courseDto = new CourseDto();
        if (Objects.nonNull(entity.getId())) {
            courseDto.setId(entity.getId());
        }
        return courseDto.setName(entity.getName())
                .setPrice(entity.getPrice())
                .setSections(entity.getSections().stream()
                .map(sectionMapper::toDto)
                .collect(Collectors.toList()));
    }
}
