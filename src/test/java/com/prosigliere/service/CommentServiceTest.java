package com.prosigliere.service;

import com.prosigliere.domain.dto.request.CreateCommentRequest;
import com.prosigliere.domain.dto.response.CreateCommentResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.domain.entity.CommentEntity;
import com.prosigliere.repository.CommentRepository;
import com.prosigliere.util.BlogPostMother;
import com.prosigliere.util.CommentMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {

    @InjectMocks
    private CommentService service;

    @Mock
    private CommentRepository repository;

    @Mock
    private BlogPostService blogPostService;

    @Test
    void shouldCreateComment() {
        Long requestId = 1L;
        CreateCommentRequest mockedRequest = CommentMother.defaultCreateCommentRequest();
        CommentEntity mockedEntity = CommentMother.defaultCommentEntity();
        BlogPostEntity mockedBlogPostEntity = BlogPostMother.defaultBlogPostEntity();

        when(blogPostService.getValidBlogPost(requestId)).thenReturn(mockedBlogPostEntity);
        when(repository.save(any())).thenReturn(mockedEntity);

        CreateCommentResponse response = service.createCommentResponse(requestId, mockedRequest);

        assertEquals(mockedEntity.getId(), response.getId());
    }
}
