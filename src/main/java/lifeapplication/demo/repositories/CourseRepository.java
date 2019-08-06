package lifeapplication.demo.repositories;

import lifeapplication.demo.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository <CourseEntity, Long>, JpaSpecificationExecutor<CourseEntity> {
    List<CourseEntity> findAllByIdIn(List<Long> listId);
}
