package com.example.demo.post.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "postEntity")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String loginId;

    private String nickname;
    private String content;
    private LocalDateTime modifyDate;
    private int viewCount;
    private LocalDateTime uploadDate;
    private String title;
    private String imagePath0;
    private String imagePath1;
    private String imagePath2;
    private String imagePath3;
    private String imagePath4;
    private int postId1;
    private int postId2;
    private int postId3;
    private int postId4;
    private int postId5;

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath0() {
        return imagePath0;
    }

    public void setImagePath0(String imagePath0) {
        this.imagePath0 = imagePath0;
    }

    public String getImagePath1() {
        return imagePath1;
    }

    public void setImagePath1(String imagePath1) {
        this.imagePath1 = imagePath1;
    }

    public String getImagePath2() {
        return imagePath2;
    }

    public void setImagePath2(String imagePath2) {
        this.imagePath2 = imagePath2;
    }

    public String getImagePath3() {
        return imagePath3;
    }

    public void setImagePath3(String imagePath3) {
        this.imagePath3 = imagePath3;
    }

    public String getImagePath4() {
        return imagePath4;
    }

    public void setImagePath4(String imagePath4) {
        this.imagePath4 = imagePath4;
    }

    public int getPostId1() {
        return postId1;
    }

    public void setPostId1(int postId1) {
        this.postId1 = postId1;
    }

    public int getPostId2() {
        return postId2;
    }

    public void setPostId2(int postId2) {
        this.postId2 = postId2;
    }

    public int getPostId3() {
        return postId3;
    }

    public void setPostId3(int postId3) {
        this.postId3 = postId3;
    }

    public int getPostId4() {
        return postId4;
    }

    public void setPostId4(int postId4) {
        this.postId4 = postId4;
    }

    public int getPostId5() {
        return postId5;
    }

    public void setPostId5(int postId5) {
        this.postId5 = postId5;
    }
}
