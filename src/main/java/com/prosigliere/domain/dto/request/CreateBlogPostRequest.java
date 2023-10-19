package com.prosigliere.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateBlogPostRequest {

    @NotBlank(message = "Blog post title cannot be empty")
    private String title;
    @NotBlank(message = "Blog post content cannot be empty.")
    private String content;
}
