package lifeapplication.demo.dto.mapper;

import lifeapplication.demo.dto.SectionDto;
import lifeapplication.demo.entities.SectionEntity;
import lifeapplication.demo.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ManualSectionMapper implements AbstractMapper<SectionEntity, SectionDto> {

    private final CourseService courseService;

    @Override
    public SectionEntity toEntity(SectionDto dto) {
        SectionEntity sectionEntity = new SectionEntity();
        return sectionEntity.setName(dto.getName())
                .setCourse(courseService.getById(dto.getCourseId()));
    }

    @Override
    public SectionDto toDto(SectionEntity entity) {
        SectionDto sectionDto = new SectionDto();
        if (Objects.nonNull(entity.getId())) {
            sectionDto.setId(entity.getId());
        }
        return sectionDto.setName(entity.getName())
                .setCourseId(entity.getCourse().getId());

    }
}
