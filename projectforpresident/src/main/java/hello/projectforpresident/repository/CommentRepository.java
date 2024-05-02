package hello.projectforpresident.repository;

import hello.projectforpresident.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

