package hello.projectforpresident.service;

import hello.projectforpresident.entity.Comment;
import hello.projectforpresident.entity.Post;
import hello.projectforpresident.repository.CommentRepository;
import hello.projectforpresident.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void addComment(Long postId, String content) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + postId));

        Comment newComment = new Comment(content, post);
        commentRepository.save(newComment);
    }
}
