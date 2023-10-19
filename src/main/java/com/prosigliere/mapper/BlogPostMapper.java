package com.prosigliere.mapper;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.dto.response.GetAllBlogPostResponse;
import com.prosigliere.domain.dto.response.GetBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;

import java.util.List;
import java.util.stream.Collectors;

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

    public static GetBlogPostResponse mapEntityToGetBlogPostResponse(BlogPostEntity entity) {
        return GetBlogPostResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .build();
    }

    public static GetAllBlogPostResponse mapEntityListToGetAllBlogPostResponse(List<BlogPostEntity> blogPostList) {
        List<GetBlogPostResponse> getBlogPostResponseList = blogPostList.stream()
                .map(entity -> GetBlogPostResponse.builder()
                        .id(entity.getId())
                        .title(entity.getTitle())
                        .content(entity.getContent())
                        .build()
                ).collect(Collectors.toList());

        return GetAllBlogPostResponse.builder()
                .blogPostList(getBlogPostResponseList)
                .build();
    }
}
