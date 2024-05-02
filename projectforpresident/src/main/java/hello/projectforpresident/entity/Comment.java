package hello.projectforpresident.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    // JPA를 위한 기본 생성자
    public Comment() {}


    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    // 게터와 세터는 생략
}

