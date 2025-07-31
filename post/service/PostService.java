package com.example.demo.post.service;

import com.example.demo.post.entity.Post;
import com.example.demo.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 1. 게시글 전체 조회
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 2. 게시글 상세 조회 + 조회수 증가
    public Post getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다."));
        post.setViewCount(post.getViewCount() + 1); // 조회수 증가
        postRepository.save(post); // 변경 저장
        return post;
    }

    // 3. 게시글 작성
    public Post createPost(Post post) {
        post.setUploadDate(LocalDateTime.now());
        post.setModifyDate(LocalDateTime.now());
        post.setViewCount(0); // 기본 조회수
        return postRepository.save(post);
    }

    // 4. 게시글 수정
    public Post updatePost(Long id, Post updatedPost) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다."));

        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setModifyDate(LocalDateTime.now());

        return postRepository.save(post);
    }

    // 5. 게시글 삭제
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    // 6. 최근 본 게시글 5개 조회 (postId1~5 활용)
    public List<Post> getRecentPosts(Post post) {
        List<Long> ids = List.of(
                (long) post.getPostId1(),
                (long) post.getPostId2(),
                (long) post.getPostId3(),
                (long) post.getPostId4(),
                (long) post.getPostId5()
        );
        return postRepository.findByIdIn(ids);
    }
}
