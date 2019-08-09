package lifeapplication.demo.entities;

import lifeapplication.demo.entities.parrentEntities.CreatebleEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "section")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
public class SectionEntity extends CreatebleEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;
}
