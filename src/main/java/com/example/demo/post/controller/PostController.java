package com.example.demo.post.controller;

import com.example.demo.post.dto.PostRequestDto;
import com.example.demo.post.entity.ImageEntity;
import com.example.demo.post.entity.PostEntity;
import com.example.demo.post.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 글쓰기 폼
    @GetMapping("/posts/new")
    public String writeForm() {
        return "posts/write";
    }

    // 글 작성 처리
    @PostMapping("/posts")
    public String createPost(PostRequestDto dto,
                             HttpServletRequest request,
                             @RequestParam("image0") MultipartFile image0,
                             @RequestParam("image1") MultipartFile image1,
                             @RequestParam("image2") MultipartFile image2,
                             @RequestParam("image3") MultipartFile image3,
                             @RequestParam("image4") MultipartFile image4) throws IOException {

        String uploadPath = request.getServletContext().getRealPath("/upload");
        File dir = new File(uploadPath);
        if (!dir.exists()) dir.mkdirs();

        MultipartFile[] files = {image0, image1, image2, image3, image4};
        String[] paths = new String[5];

        for (int i = 0; i < 5; i++) {
            if (!files[i].isEmpty()) {
                String fileName = UUID.randomUUID() + "_" + files[i].getOriginalFilename();
                files[i].transferTo(new File(uploadPath, fileName));
                paths[i] = "/upload/" + fileName;
            } else {
                paths[i] = null;
            }
        }

        dto.setImagepath0(paths[0]);
        dto.setImagepath1(paths[1]);
        dto.setImagepath2(paths[2]);
        dto.setImagepath3(paths[3]);
        dto.setImagepath4(paths[4]);

        postService.createPost(dto);
        return "redirect:/posts/list";
    }

    // 글 목록
    @GetMapping("/posts/list")
    public String list(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts/list";
    }

    // 글 상세 보기 - 숫자만 허용
    @GetMapping("/posts/{id:[0-9]+}")
    public String detail(@PathVariable Long id, Model model) {
        PostEntity post = postService.getPostById(id);
        ImageEntity image = post.getImageEntity();
        model.addAttribute("post", post);
        model.addAttribute("image", image);
        return "posts/detail";
    }

    // 글 수정 폼
    @GetMapping("/posts/{id:[0-9]+}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "posts/edit";
    }

    // 글 수정 처리
    @PostMapping("/posts/{id:[0-9]+}/edit")
    public String updatePost(@PathVariable Long id, PostRequestDto dto) {
        postService.updatePost(id, dto);
        return "redirect:/posts/list";
    }

    // 글 삭제
    @PostMapping("/posts/{id:[0-9]+}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts/list";
    }
}
