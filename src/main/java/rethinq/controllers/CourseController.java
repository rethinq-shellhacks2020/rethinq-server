package rethinq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rethinq.models.Course;
import rethinq.repositories.CourseRepository;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("api/courses")
@RestController
public class CourseController {

    @Autowired
    public CourseRepository courseRepository;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<Course> getAllCourses(@PathVariable("id") Long id){
        return courseRepository.findById(id);
    }

    @PostMapping(path = "/add")
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }
}
