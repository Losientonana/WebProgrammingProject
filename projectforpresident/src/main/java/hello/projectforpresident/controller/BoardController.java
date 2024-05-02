package hello.projectforpresident.controller;
import hello.projectforpresident.entity.Comment;
import hello.projectforpresident.entity.Post;
import hello.projectforpresident.repository.CommentRepository;
import hello.projectforpresident.repository.PostRepository;
import hello.projectforpresident.service.CommentService;
import hello.projectforpresident.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostServiceImpl postServiceImpl;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository; // 이러한 직접적인 연결 대신 서비스 레이어 사용 권장

    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index"; // index.html을 반환
    }


    @PostMapping("/comments/add/{postId}")
    public String addComment(@PathVariable("postId") Long postId,
                             @RequestParam("content") String content) {
        Post post = postServiceImpl.findById(postId); // 게시글 조회
        if (post != null) {
            Comment newComment = new Comment(content, post); // 댓글 객체 생성
            post.addComment(newComment); // 게시글에 댓글 추가
            postServiceImpl.savePost(post); // 변경된 게시글 저장
        }

        return "redirect:/posts"; // 게시글 목록 페이지로 리다이렉트
    }


    @GetMapping("/posts")
    public String listPosts(Model model) {
        List<Post> posts = postServiceImpl.listAllPosts();
        model.addAttribute("posts", posts);
        return "posts"; // Thymeleaf로 게시글 목록을 보여주는 페이지
    }

    @GetMapping("/posts/create")
    public String showCreateForm() {
        return "createPost"; // Thymeleaf로 공지사항 작성 form을 보여주는 페이지
    }

    @PostMapping("/posts")
    public String createPost(@RequestParam String title, @RequestParam String content) {
        Post newPost = new Post(title, content);
        postServiceImpl.savePost(newPost.getTitle(),newPost.getContent());
        return "redirect:/posts"; // 게시글 작성 후 게시글 목록 페이지로 리다이렉트
    }

}

