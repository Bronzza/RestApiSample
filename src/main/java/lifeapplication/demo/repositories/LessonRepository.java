package lifeapplication.demo.repositories;

import lifeapplication.demo.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
}
