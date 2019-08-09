package lifeapplication.demo.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecificationCriteriaUtil {

    public static <T> Specification<T> buildRange(Long start, Long end, RootCriteriaFunction<T> rootCriteriaFunction) {
        Specification<T> result = Specification.where(null);

        if (Objects.nonNull(start)) {
            result = result.and((root, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.ge(rootCriteriaFunction.apply(root), start));
        }
        if (Objects.nonNull(end)) {
            result = result.and(((root, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.le(rootCriteriaFunction.apply(root), end)));
        }
        return result;
    }
}

