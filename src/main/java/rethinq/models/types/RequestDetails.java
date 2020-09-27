package rethinq.models.types;

import rethinq.models.Course;
import rethinq.models.TutorCourse;

public class RequestDetails {
    private Course course;
    private TutorCourse tutorCourse;

    public RequestDetails(Course course, TutorCourse tutorCourse) {
        this.course = course;
        this.tutorCourse = tutorCourse;
    }

    public Course getCourse() {
        return course;
    }

    public TutorCourse getTutorCourse() {
        return tutorCourse;
    }
}
