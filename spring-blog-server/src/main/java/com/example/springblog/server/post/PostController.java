package com.example.springblog.server.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(value = {"", "/"})
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public Post getPost(@PathVariable Integer id) {
        var post = postService.getPost(id);
        if (post.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
        }
        return post.get();
    }

    @PostMapping(value = {"", "/"})
    public Post createPost(@RequestBody Post post) {
        var createdPost = postService.createPost(post);
        if (createdPost.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");
        }
        return createdPost.get();
    }
}
