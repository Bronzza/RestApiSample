package lifeapplication.demo.services;

import lifeapplication.demo.entities.CourseEntity;
import lifeapplication.demo.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService implements BaseService<CourseEntity> {

    private final CourseRepository courseRepository;


    @Override
    public List<CourseEntity> getAll() {
        return null;
    }

    @Override
    public CourseEntity getByName(String name) {
        return null;
    }

    @Override
    public CourseEntity getById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void save(CourseEntity user) {

    }
}
