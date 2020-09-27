package rethinq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rethinq.models.Availability;
import rethinq.models.Student;
import rethinq.repositories.AvailabilityRepository;
import rethinq.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("api/availability")
@RestController
public class AvailabilityController {

    @Autowired
    public AvailabilityRepository availabilityRepository;
    @Autowired
    public StudentRepository studentRepository;

    @GetMapping(path = "student={id}")
    public List<Availability> findStudentById(@PathVariable("id") Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()){
            throw new Error("Could not find student with idL " + id);
        }
        return student.get().getAvailability();
    }

    @PostMapping(path = "student={studentId}/add")
    public Availability addAvailability(@PathVariable("studentId") Long studentId, @RequestBody Availability availability){
        Optional<Student> student = studentRepository.findById(studentId);
        if(!student.isPresent()){
            throw new Error("Could not find student with idL " + studentId);
        }
        availability.setStudent(student.get());
        if(student.get().getAvailability().size() == 7){
            throw new Error("You cannot have more than 7 days available!");
        }
        if(student.get().getAvailability().size() == 7){
            throw new Error("You cannot have more than 7 days available!");
        }
//        if(student.get().getAvailability().stream().forEach(availability1 -> availability1.getWeekday().equals(availability.getWeekday()))){
//
//        }
        return availabilityRepository.save(availability);
    }
}
