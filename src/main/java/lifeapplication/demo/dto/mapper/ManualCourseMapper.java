package lifeapplication.demo.dto.mapper;

import lifeapplication.demo.dto.CourseDto;
import lifeapplication.demo.entities.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
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
                .setBeginDate(dto.getBeginDate())
                .setEndDate(dto.getEndDate())
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
        if (Objects.nonNull(entity.getCreatedDate())) {
            courseDto.setCreatedDate(new Date(entity.getCreatedDate()));
        }

        return courseDto.setName(entity.getName())

                .setPrice(entity.getPrice())
                .setBeginDate(entity.getBeginDate())
                .setEndDate(entity.getEndDate())
                .setSections(entity.getSections().stream()
                        .map(sectionMapper::toDto)
                        .collect(Collectors.toList()));
    }

    public List<CourseDto> toListDto (List <CourseEntity> listOfEntities){
        return listOfEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
