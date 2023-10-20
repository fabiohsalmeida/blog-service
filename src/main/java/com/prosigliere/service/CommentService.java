package com.prosigliere.service;

import com.prosigliere.domain.dto.request.CreateCommentRequest;
import com.prosigliere.domain.dto.response.CreateCommentResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.domain.entity.CommentEntity;
import com.prosigliere.mapper.CommentMapper;
import com.prosigliere.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.prosigliere.mapper.CommentMapper.mapCreateCommentRequestToEntity;
import static com.prosigliere.mapper.CommentMapper.mapEntityToCreateCommentResponse;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;
    private final BlogPostService blogPostService;

    public CreateCommentResponse createCommentResponse(Long blogPostId, CreateCommentRequest request) {
        CommentEntity storedEntity = validateAndSaveComment(blogPostId, request);

        return mapEntityToCreateCommentResponse(storedEntity);
    }

    private CommentEntity validateAndSaveComment(Long blogPostId, CreateCommentRequest request) {
        BlogPostEntity blogPost = blogPostService.getValidBlogPost(blogPostId);

        CommentEntity entityToBeStored = mapCreateCommentRequestToEntity(request, blogPost);

        return repository.save(entityToBeStored);
    }
}
