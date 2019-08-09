package lifeapplication.demo.controllers;

import lifeapplication.demo.controllers.exceptionhanlers.BaseHandler;
import lifeapplication.demo.dto.CourseDto;
import lifeapplication.demo.dto.SpecificationRequest;
import lifeapplication.demo.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/course")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController extends BaseHandler {

    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAll();
    }

    @PostMapping
    public String saveCourse(@RequestBody CourseDto courseDto) {
        courseService.save(courseDto);
        return "redirect:/course";
    }

    @GetMapping(path = "/{id}")
    public CourseDto findCourseDtoById(@PathVariable("id") Long id) {
        return courseService.getById(id);
    }

    @PostMapping("/search")
    public List<CourseDto> findAllBySpecification(@RequestBody SpecificationRequest request) {
        return courseService.getAll(request);
    }
}
