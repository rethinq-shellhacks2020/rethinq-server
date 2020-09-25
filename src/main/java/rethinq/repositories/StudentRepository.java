package rethinq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rethinq.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
