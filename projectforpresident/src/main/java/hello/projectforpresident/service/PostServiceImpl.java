package hello.projectforpresident.service;

import hello.projectforpresident.entity.Post;
import hello.projectforpresident.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository; // PostRepository 주입

    // 생성자를 통한 의존성 주입(Dependency Injection)
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Transactional// 모든 게시글 리스트를 반환하는 메소드
    public List<Post> listAllPosts() {
        return postRepository.findAll(); // 게시글 목록 조회
    }

    // 새로운 게시글을 저장하는 메소드
    public void savePost(String title, String content) {
        Post newPost = new Post(title, content); // 게시글 객체 생성
        postRepository.save(newPost); // 게시글 저장
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null); // 게시글 조회
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post); // 게시글 저장
    }

}
