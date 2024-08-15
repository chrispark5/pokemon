package com.example.quickstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.quickstart.service.PokeService;
import com.example.quickstart.dto.PostRequestDTO;

@RestController
public class PostController {
    private final PokeService postService;

    @Autowired
    public PostController(PokeService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@RequestBody PostRequestDTO requestDTO) {
        String response = postService.createPost(requestDTO.getTitle(), requestDTO.getBody());
        return ResponseEntity.ok(response);
    }
}
