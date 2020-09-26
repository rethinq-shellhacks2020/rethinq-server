package rethinq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rethinq.models.Student;
import rethinq.models.types.StudentLogin;
import rethinq.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("api/users")
@RestController
public class StudentController {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public StudentRepository studentRepository;

    @PostMapping(path = "/create")
    public Student createUser(@RequestBody Student student){
        String encryptedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encryptedPassword);
        return studentRepository.save(student);
    }

    @PostMapping("/login")
    public Student login(@RequestBody StudentLogin login){
        Optional<Student> student = studentRepository.findByUsername(login.getUsername());
        if(!student.isPresent()){
            throw new Error("Username does not exist");
        }
        if(passwordEncoder.matches(login.getPassword(), student.get().getPassword())){
            return student.get();
        } else {
            throw new Error("Password is incorrect!");
        }
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<Student> findStudentById(@PathVariable("id") Long id){
        return studentRepository.findById(id);
    }



}
