package rethinq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rethinq.models.Course;
import rethinq.models.Student;
import rethinq.models.TutorCourse;
import rethinq.repositories.CourseRepository;
import rethinq.repositories.StudentRepository;
import rethinq.repositories.TutorCourseRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("api/tutor-course")
@RestController
public class TutorCourseController {

    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    public TutorCourseRepository tutorCourseRepository;
    @Autowired
    public CourseRepository courseRepository;

    @PostMapping(path = "/student={studentId}/course={courseId}/add")
    public TutorCourse addTutorCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId, @RequestBody TutorCourse tutorCourse){
        Optional<Student> tutor = studentRepository.findById(studentId);
        if(!tutor.isPresent()){
            throw new Error("Student not found.");
        }
        Optional<Course> course = courseRepository.findById(courseId);
        if(!course.isPresent()){
            throw new Error("Course not found.");
        }
        if(tutorCourse.getRating() != null){
            throw new Error("Tutor cannot rate his own course!");
        }
        tutorCourse.setTutor(tutor.get());
        System.out.println(tutorCourse.getGrade());
        tutorCourse.setCourse(course.get());
        System.out.println(tutorCourse.getHourlyRate());
        return tutorCourseRepository.save(tutorCourse);
    }

    @PutMapping(path = "{id}/hourly={hourlyRate}")
    public TutorCourse updateTutorCourseHourlyRate(@PathVariable("id") Long id, @PathVariable("hourlyRate") Float hourlyRate){
        Optional<TutorCourse> tutorCourse = tutorCourseRepository.findById(id);
        tutorCourse.get().setHourlyRate(hourlyRate);
        return tutorCourseRepository.save(tutorCourse.get());
    }

    @GetMapping
    public List<TutorCourse> getAllTutorCourses(){
        return tutorCourseRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<TutorCourse> getTutorCourseById(@PathVariable("id") Long id){
        return tutorCourseRepository.findById(id);
    }
}
