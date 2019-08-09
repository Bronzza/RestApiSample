package lifeapplication.demo.listeners;

import lifeapplication.demo.entities.parrentEntities.CreatebleEntity;

import javax.persistence.PrePersist;
import java.util.Date;

public class CreatedDateListener {

    @PrePersist
    public void createDate(CreatebleEntity createbleEntity) {
        createbleEntity.setCreatedDate(new Date().getTime());
    }
}
