package lifeapplication.demo.services.specification;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SpecificationCriteria {

    private String login;
    private String name;
    private String content;

    private Long costStart;
    private Long costEnd;

    private Long createdDateStart;
    private Long createdDateEnd;
}

