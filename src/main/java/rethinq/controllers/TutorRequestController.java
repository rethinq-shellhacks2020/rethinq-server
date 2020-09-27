package rethinq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rethinq.models.Student;
import rethinq.models.TutorCourse;
import rethinq.models.TutorRequest;
import rethinq.models.enums.TutorRequestStatus;
import rethinq.models.types.RequestDetails;
import rethinq.models.types.SessionBooking;
import rethinq.repositories.StudentRepository;
import rethinq.repositories.TutorCourseRepository;
import rethinq.repositories.TutorRequestRepository;

import javax.swing.text.html.Option;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

@CrossOrigin
@RequestMapping("api/tutor-request")
@RestController
public class TutorRequestController {

    @Autowired
    public TutorRequestRepository tutorRequestRepository;
    @Autowired
    public TutorCourseRepository tutorCourseRepository;
    @Autowired
    public StudentRepository studentRepository;

    @GetMapping(path = "{id}")
    public RequestDetails getTutorRequestDetails(@PathVariable("id") Long id){
        Optional<TutorRequest> tutorRequest = tutorRequestRepository.findById(id);
        if(!tutorRequest.isPresent()){
            throw new Error("Cannot find tutor request with id: " + id);
        }
        RequestDetails requestDetails = new RequestDetails(tutorRequest.get().getTutorCourse().getCourse(), tutorRequest.get().getTutorCourse());
        return requestDetails;
    }

    @PostMapping(path = "{tutorCourseId}/for={studentId}")
    public TutorRequest requestTutoring(@PathVariable("tutorCourseId") Long tutorCourseId, @PathVariable("studentId") Long studentId, @RequestBody SessionBooking booking) throws ParseException {
        Optional<TutorCourse> tutorCourse = tutorCourseRepository.findById(tutorCourseId);
        if(!tutorCourse.isPresent()){
            throw new Error("Cannot find tutor course with id: " + tutorCourseId);
        }

        Optional<Student> tutee = studentRepository.findById(studentId);
        if(!tutee.isPresent()){
            throw new Error("Cannot find student with id: " + studentId);
        }

        Student tutor = tutorCourse.get().getTutor();

        if(tutor.getId() == studentId){
            throw new Error("Student cannot request tutoring from themselves.");
        }

        TutorRequest tutorRequest = new TutorRequest();

        // set start time
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date parsedDate = formatter.parse(booking.getDate());
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTimeZone(TimeZone.getTimeZone("EST"));
        startCalendar.setTime(parsedDate);
        startCalendar.add(Calendar.HOUR_OF_DAY, booking.getTime());
        Date start = startCalendar.getTime();
        tutorRequest.setBookedStart(start);

        // set end time
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTimeZone(TimeZone.getTimeZone("EST"));
        endCalendar.setTime(start);
        endCalendar.add(Calendar.HOUR_OF_DAY, booking.getHours());
        Date end = endCalendar.getTime();
        tutorRequest.setBookedEnd(end);

        tutorRequest.setStatus(TutorRequestStatus.BOOKED);
        tutorRequest.setTutorCourse(tutorCourse.get());
        tutorRequest.setTutor(tutor);
        tutorRequest.setTutee(tutee.get());
        return tutorRequestRepository.save(tutorRequest);
    }
}
