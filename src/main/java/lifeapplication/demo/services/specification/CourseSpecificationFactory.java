package lifeapplication.demo.services.specification;

import lifeapplication.demo.entities.CourseEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CourseSpecificationFactory {

    private static final CourseSpecificationBuilder<CourseEntity> SPECIFICATION_BUILDER = new CourseSpecificationBuilder<>();

    public Specification<CourseEntity> build(SpecificationCriteria searchCriteria) {
        return SPECIFICATION_BUILDER.build(searchCriteria);
    }

}
