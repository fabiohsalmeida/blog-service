package com.prosigliere.service;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.dto.response.GetBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.exceptions.BlogPostNotFoundException;
import com.prosigliere.mapper.BlogPostMapper;
import com.prosigliere.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.prosigliere.mapper.BlogPostMapper.*;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    private final BlogPostRepository repository;

    public CreateBlogPostResponse createBlogPost(CreateBlogPostRequest request) {
        BlogPostEntity storedBlogPost = saveBlogPost(request);

        return mapEntityToCreateBlogPostResponse(storedBlogPost);
    }

    public GetBlogPostResponse getBlogPostById(Long id) {
        BlogPostEntity blogPost = getValidBlogPost(id);

        return mapEntityToGetBlogPostResponse(blogPost);
    }

    private BlogPostEntity getValidBlogPost(Long id) {
        Optional<BlogPostEntity> blogPost = repository.findById(id);

        if (blogPost.isEmpty()) {
            throw new BlogPostNotFoundException(id);
        }

        return blogPost.get();
    }

    private BlogPostEntity saveBlogPost(CreateBlogPostRequest request) {
        BlogPostEntity entityToBeSaved = mapCreateBlogPostRequestToEntity(request);

        return repository.save(entityToBeSaved);
    }
}
