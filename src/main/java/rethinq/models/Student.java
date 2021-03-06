package rethinq.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import rethinq.models.enums.CollegeYear;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private CollegeYear collegeYear;

    private Float gpa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tutee")
    private List<TutorRequest> tutorRequestsSent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tutor")
    private List<TutorRequest> tutorRequestsReceived;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tutor")
    private List<TutorCourse> myCourses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
    private List<PaymentMethod> paymentMethods;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
    @Size(min=1, max=7)
    private List<Availability> availability;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CollegeYear getCollegeYear() {
        return collegeYear;
    }

    public void setCollegeYear(CollegeYear collegeYear) {
        this.collegeYear = collegeYear;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public List<TutorRequest> getTutorRequestsSent() {
        return tutorRequestsSent;
    }

    public void setTutorRequestsSent(List<TutorRequest> tutorRequestsSent) {
        this.tutorRequestsSent = tutorRequestsSent;
    }

    public List<TutorRequest> getTutorRequestsReceived() {
        return tutorRequestsReceived;
    }

    public void setTutorRequestsReceived(List<TutorRequest> tutorRequestsReceived) {
        this.tutorRequestsReceived = tutorRequestsReceived;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TutorCourse> getMyCourses() {
        return myCourses;
    }

    public void setMyCourses(List<TutorCourse> myCourses) {
        this.myCourses = myCourses;
    }

    public List<Availability> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }
}
