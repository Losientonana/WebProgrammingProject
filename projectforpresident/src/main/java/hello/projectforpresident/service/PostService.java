package hello.projectforpresident.service;

import hello.projectforpresident.entity.Post;

public interface PostService {
    Post findById(Long id); // 게시글 조회

    void savePost(Post post); // 게시글 저장
}
