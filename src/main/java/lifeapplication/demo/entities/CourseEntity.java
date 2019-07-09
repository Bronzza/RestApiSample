package lifeapplication.demo.entities;

import lifeapplication.demo.entities.parrentEntities.CreatebleEntity;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
public class CourseEntity extends CreatebleEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<SectionEntity> sections = new ArrayList<>();
}
