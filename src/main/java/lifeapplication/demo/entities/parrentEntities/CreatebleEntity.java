package lifeapplication.demo.entities.parrentEntities;

import lifeapplication.demo.listeners.CreatedDateListener;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
@Accessors(chain = true)
@EntityListeners(value = CreatedDateListener.class)
public class CreatebleEntity extends BaseEntity {

    @Column(name = "created_date")
    protected Long createdDate;
}
