package rethinq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rethinq.models.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Optional<Student> findByUsername(String username);
}
