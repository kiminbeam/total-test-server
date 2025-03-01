package com.metacoding.restserver.post;

import com.metacoding.restserver._core.auth.LoginUser;
import com.metacoding.restserver._core.auth.SessionUser;
import com.metacoding.restserver._core.util.Resp;
import com.metacoding.restserver.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/api/post")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(Resp.success(postService.게시글목록보기()));
    }

    @PostMapping("/api/post")
    public ResponseEntity<?> save(@RequestBody PostRequest.SaveDTO reqDTO, @SessionUser LoginUser loginUser) {

        return ResponseEntity.ok(Resp.success(postService.게시글쓰기(reqDTO, loginUser)));
    }

    @GetMapping("/api/post/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(Resp.success(postService.게시글상세보기(id)));
    }
}
