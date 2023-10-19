package com.prosigliere.service;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.mapper.BlogPostMapper;
import com.prosigliere.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.prosigliere.mapper.BlogPostMapper.mapCreateBlogPostRequestToEntity;
import static com.prosigliere.mapper.BlogPostMapper.mapEntityToCreateBlogPostResponse;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    private final BlogPostRepository repository;

    public CreateBlogPostResponse createBlogPost(CreateBlogPostRequest request) {
        BlogPostEntity storedBlogPost = saveBlogPost(request);

        return mapEntityToCreateBlogPostResponse(storedBlogPost);
    }

    private BlogPostEntity saveBlogPost(CreateBlogPostRequest request) {
        BlogPostEntity entityToBeSaved = mapCreateBlogPostRequestToEntity(request);

        return repository.save(entityToBeSaved);
    }
}
