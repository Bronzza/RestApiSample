package lifeapplication.demo.services.specification;

import org.springframework.data.jpa.domain.Specification;

import static lifeapplication.demo.utils.SpecificationCriteriaUtil.buildRange;

public class CourseSpecificationBuilder<T> extends CommonSpecificationBuilder<T> {

    private final static String COST_KEY = "cost";

    @Override
    public Specification<T> build(SpecificationCriteria criteria) {
        return Specification.where(super.build(criteria))
                .and(buildCostRange(criteria));
    }

    private Specification<T> buildCostRange(SpecificationCriteria criteria) {
        return buildRange(criteria.getCostStart(), criteria.getCostEnd(), (root -> root.get(COST_KEY)));
    }
}
