package com.prosigliere.util;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;

public class BlogPostMother {

    public static BlogPostEntity defaultBlogPostEntity() {
        return BlogPostEntity.builder()
                .id(1L)
                .title("Sample title for blog post 1")
                .content("Sample content for blog post 1")
                .build();
    }

    public static CreateBlogPostRequest defaultCreateBlogPostRequest() {
        return CreateBlogPostRequest.builder()
                .title("Sample title for create blog post 1")
                .content("Sample content for create blog post 1")
                .build();
    }

    public static CreateBlogPostResponse defaultCreateBlogPostResponse() {
        return CreateBlogPostResponse.builder()
                .id(1L)
                .build();
    }
}
