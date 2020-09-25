package rethinq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rethinq.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
