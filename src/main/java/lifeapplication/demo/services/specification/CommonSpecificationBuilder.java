package lifeapplication.demo.services.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

import static lifeapplication.demo.utils.SpecificationCriteriaUtil.buildRange;

public class CommonSpecificationBuilder<T> {
    private static final String KEY_NAME = "name";
    private static final String CREATED_DATE_KEY = "created_date";

    public Specification<T> build(SpecificationCriteria criteria) {
        return Specification.where(buildName(criteria.getName()));
    }

    private Specification<T> buildName(String name) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                Objects.isNull(name) ? null : criteriaBuilder.like(root.get(KEY_NAME), name + "%"));
    }

    private Specification<T> buildCreatedDateRange(SpecificationCriteria criteria) {
        return buildRange(criteria.getCreatedDateStart(), criteria.getCreatedDateEnd(), (root) -> root.get(CREATED_DATE_KEY));
    }
}
