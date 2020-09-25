package rethinq.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class TutorCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float hourlyRate;
    private String grade;
    private Float rating;
    private Integer ratingCount;

    @JsonIgnore
    @ManyToOne
    private Student tutor;

    @JsonIgnore
    @ManyToOne
    private Course course;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tutorCourse")
    @Size(min=1, max=7)
    private List<Availability> availability;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tutorCourse")
    private List<TutorRequest> tutorRequests;

    public TutorCourse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Student getTutor() {
        return tutor;
    }

    public void setTutor(Student tutor) {
        this.tutor = tutor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Availability> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

    public List<TutorRequest> getTutorRequests() {
        return tutorRequests;
    }

    public void setTutorRequests(List<TutorRequest> tutorRequests) {
        this.tutorRequests = tutorRequests;
    }
}
