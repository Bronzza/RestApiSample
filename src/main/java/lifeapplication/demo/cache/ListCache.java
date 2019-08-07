package lifeapplication.demo.cache;

import lifeapplication.demo.dto.SpecificationRequest;
import lifeapplication.demo.entities.parrentEntities.BaseEntity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ListCache<T extends BaseEntity, SR extends SpecificationRequest> {

    @Getter
    private Map<SR, List<Long>> cache = new HashMap<>();

    private Function<SR, List<T>> searchBySpecification;
    private Function<List<Long>, List<T>> searchByIds;

    public void initFunctions(Function<SR, List<T>> bySpecification, Function<List<Long>, List<T>> byIds) {
        searchBySpecification = bySpecification;
        searchByIds = byIds;
    }

    public List<T> getEntities(SR specificationRequest) {
        List<Long> ids = cache.get(specificationRequest);

        if (ids == null) {
            log.info("First use of cache, using specification request for search");
            List<T> entities = searchBySpecification.apply(specificationRequest);
            cache.put(specificationRequest, entities.stream()
                    .map(BaseEntity::getId)
                    .collect(Collectors.toList()));
            return entities;
        } else {
            log.info("Not first request, using list of id's for search");
            return loadFromCach(ids);
        }
    }

    private List<T> loadFromCach(List<Long> ids) {
        return searchByIds.apply(ids);
    }
}
