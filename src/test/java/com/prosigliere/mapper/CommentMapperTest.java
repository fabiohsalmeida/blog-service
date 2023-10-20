package com.prosigliere.mapper;

import com.prosigliere.domain.dto.request.CreateCommentRequest;
import com.prosigliere.domain.dto.response.CreateCommentResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.domain.entity.CommentEntity;
import com.prosigliere.util.BlogPostMother;
import com.prosigliere.util.CommentMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CommentMapperTest {

    @Test
    void mapEntityToCreateCommentResponse() {
        CommentEntity mockedEntity = CommentMother.defaultCommentEntity();

        CreateCommentResponse response = CommentMapper.mapEntityToCreateCommentResponse(mockedEntity);

        assertEquals(mockedEntity.getId(), response.getId());
    }

    @Test
    void mapCreateCommentRequestToEntity() {
        CreateCommentRequest mockedRequest = CommentMother.defaultCreateCommentRequest();
        BlogPostEntity mockedBlogPostEntity = BlogPostMother.defaultBlogPostEntity();

        CommentEntity entity = CommentMapper.mapCreateCommentRequestToEntity(mockedRequest, mockedBlogPostEntity);

        assertNull(entity.getId());
        assertEquals(mockedRequest.getContent(), entity.getContent());
        assertEquals(mockedBlogPostEntity.getTitle(), entity.getBlogPost().getTitle());
        assertEquals(mockedBlogPostEntity.getContent(), entity.getBlogPost().getContent());
        assertEquals(mockedBlogPostEntity.getId(), entity.getBlogPost().getId());
    }
}
