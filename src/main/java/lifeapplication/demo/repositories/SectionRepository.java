package lifeapplication.demo.repositories;

import lifeapplication.demo.entities.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SectionRepository extends JpaRepository<SectionEntity, Long> {
}
