package com.metacoding.restserver.post;

import com.metacoding.restserver._core.auth.LoginUser;
import com.metacoding.restserver.user.User;
import lombok.Data;

public class PostRequest {

    @Data
    public static class SaveDTO {
        private String title;
        private String content;

        Post toEntity(User user){
            return Post.builder()
                    .title(title)
                    .content(content)
                    .user(user)
                    .build();
        }
    }
}
