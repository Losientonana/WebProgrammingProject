package hello.projectforpresident.repository;

import hello.projectforpresident.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

