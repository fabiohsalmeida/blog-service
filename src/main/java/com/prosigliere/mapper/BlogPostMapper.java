package com.prosigliere.mapper;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;

public class BlogPostMapper {

    public static BlogPostEntity mapCreateBlogPostRequestToEntity(CreateBlogPostRequest request) {
        return BlogPostEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public static CreateBlogPostResponse mapEntityToCreateBlogPostResponse(BlogPostEntity entity) {
        return CreateBlogPostResponse.builder()
                .id(entity.getId())
                .build();
    }
}
