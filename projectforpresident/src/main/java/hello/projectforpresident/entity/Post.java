package hello.projectforpresident.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String title;
    private String content;

    //댓글 목록을 위한 설정
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    private User user;

    public Post() {

    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(null);
    }
        public Post(String title, String content) {
            this.title = title;
            this.content = content;
        }
}

