package lifeapplication.demo.dto;

import lifeapplication.demo.services.specification.SpecificationCriteria;

public class SpecificationTransformer {

    public static SpecificationCriteria buildCriteria(SpecificationRequest request) {
        return SpecificationCriteria.builder()
                .name(request.getName())
                .login(request.getLogin())
                .content(request.getContent())
                .costStart(request.getCostStart())
                .costEnd(request.getCostEnd())
                .createdDateEnd(request.getCreatedDateEnd())
                .createdDateStart(request.getCreatedDateStart())
                .build();
    }
}
