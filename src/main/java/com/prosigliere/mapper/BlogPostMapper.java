package com.prosigliere.mapper;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.dto.response.GetAllBlogPostResponse;
import com.prosigliere.domain.dto.response.GetBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.domain.model.BlogPostItem;

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
        List<String> comments = entity.getComments().stream()
                .map(commentEntity -> commentEntity.getContent())
                .collect(Collectors.toList());

        return GetBlogPostResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .comments(comments)
                .build();
    }

    public static GetAllBlogPostResponse mapEntityListToGetAllBlogPostResponse(List<BlogPostEntity> blogPostList) {
        List<BlogPostItem> blogPostItemList = blogPostList.stream()
                .map(entity -> BlogPostItem.builder()
                        .id(entity.getId())
                        .title(entity.getTitle())
                        .numberOfComments(entity.getComments().size())
                        .build()
                ).collect(Collectors.toList());

        return GetAllBlogPostResponse.builder()
                .blogPostList(blogPostItemList)
                .build();
    }
}
