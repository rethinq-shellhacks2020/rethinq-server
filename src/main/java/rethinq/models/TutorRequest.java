package rethinq.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import rethinq.models.enums.TutorRequestStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TutorRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Student tutor;

    @JsonIgnore
    @ManyToOne
    private Student tutee;

    @JsonIgnore
    @ManyToOne
    private TutorCourse tutorCourse;

    @Enumerated(EnumType.STRING)
    private TutorRequestStatus status;

    private Date bookedStart;
    private Date bookedEnd;

    private Integer rating;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public TutorRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getTutor() {
        return tutor;
    }

    public void setTutor(Student tutor) {
        this.tutor = tutor;
    }

    public Student getTutee() {
        return tutee;
    }

    public void setTutee(Student tutee) {
        this.tutee = tutee;
    }

    public TutorCourse getTutorCourse() {
        return tutorCourse;
    }

    public void setTutorCourse(TutorCourse tutorCourse) {
        this.tutorCourse = tutorCourse;
    }

    public TutorRequestStatus getStatus() {
        return status;
    }

    public void setStatus(TutorRequestStatus status) {
        this.status = status;
    }

    public Date getBookedStart() {
        return bookedStart;
    }

    public void setBookedStart(Date bookedStart) {
        this.bookedStart = bookedStart;
    }

    public Date getBookedEnd() {
        return bookedEnd;
    }

    public void setBookedEnd(Date bookedEnd) {
        this.bookedEnd = bookedEnd;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
