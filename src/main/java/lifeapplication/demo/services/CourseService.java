package lifeapplication.demo.services;

import lifeapplication.demo.cache.ListCache;
import lifeapplication.demo.controllers.exceptionhanlers.exceptions.NotFoundRuntimeException;
import lifeapplication.demo.dto.CourseDto;
import lifeapplication.demo.dto.SpecificationRequest;
import lifeapplication.demo.dto.mapper.ManualCourseMapper;
import lifeapplication.demo.entities.CourseEntity;
import lifeapplication.demo.repositories.CourseRepository;
import lifeapplication.demo.services.specification.CourseSpecificationFactory;
import lifeapplication.demo.services.specification.SpecificationCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static lifeapplication.demo.dto.SpecificationTransformer.buildCriteria;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService implements BaseService<CourseDto> {

    private static final ListCache<CourseEntity, SpecificationRequest> CACHE = new ListCache<>();

    private final CourseRepository courseRepository;

    private final CourseSpecificationFactory courseSpecificationFactory;

    @Autowired
    private ManualCourseMapper courseMapper;

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.findAll().stream()
                .map(entity -> courseMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @PostConstruct
    private void initCache() {
        CACHE.initFunctions(this::getAllByRequest, this::getAllByIds);
    }

    @Override
    public CourseDto getByName(String name) {
        return null;
    }

    @Override
    public CourseDto getById(Long id) {
        return courseMapper.toDto(courseRepository.findById(id).get());
    }


    public List<CourseEntity> getAllByIds(List<Long> listIds) {
        return courseRepository.findAllByIdIn(listIds);
    }

    public CourseEntity getEntityById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new NotFoundRuntimeException(id, "Course can't be found"));
    }

    @Override
    public void save(CourseDto courseDto) {
        courseRepository.save(courseMapper.toEntity(courseDto));
    }


    private List<CourseEntity> getAllByRequest(SpecificationRequest request) {
        SpecificationCriteria criteria = buildCriteria(request);
        Specification<CourseEntity> specification = courseSpecificationFactory.build(criteria);
        return courseRepository.findAll(specification);
    }

    private List<CourseEntity> getAllByRequestWithCach(SpecificationRequest request) {
        return CACHE.getEntities(request);
    }

    @Transactional
    public List<CourseDto> getAll(SpecificationRequest request) {
        return courseMapper.toListDto(getAllByRequestWithCach(request));
    }
}
