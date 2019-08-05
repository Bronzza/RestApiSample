package lifeapplication.demo.utils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public interface RootCriteriaFunction<T> {
    Expression<Long> apply(Root<T> root);
}
