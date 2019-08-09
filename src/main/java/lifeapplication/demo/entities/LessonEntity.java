package lifeapplication.demo.entities;

import lifeapplication.demo.entities.parrentEntities.CreatebleEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "lesson")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
public class LessonEntity extends CreatebleEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<CommentEntity> comments = new ArrayList<>();
}
