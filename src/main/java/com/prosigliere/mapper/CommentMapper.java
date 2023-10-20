package com.prosigliere.mapper;

import com.prosigliere.domain.dto.request.CreateCommentRequest;
import com.prosigliere.domain.dto.response.CreateCommentResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.domain.entity.CommentEntity;

public class CommentMapper {

    public static CommentEntity mapCreateCommentRequestToEntity(CreateCommentRequest request, BlogPostEntity blogPost) {
        return CommentEntity.builder()
                .blogPost(blogPost)
                .content(request.getContent())
                .build();
    }

    public static CreateCommentResponse mapEntityToCreateCommentResponse(CommentEntity entity) {
        return CreateCommentResponse.builder()
                .id(entity.getId())
                .build();
    }
}
