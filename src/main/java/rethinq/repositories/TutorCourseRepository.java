package rethinq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rethinq.models.TutorCourse;

public interface TutorCourseRepository extends JpaRepository<TutorCourse, Long> {
}
