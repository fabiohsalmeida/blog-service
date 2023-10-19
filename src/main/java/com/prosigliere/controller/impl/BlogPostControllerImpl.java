package com.prosigliere.controller.impl;

import com.prosigliere.controller.BlogPostController;
import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class BlogPostControllerImpl implements BlogPostController {

    private final BlogPostService service;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBlogPostResponse createBlogPost(@RequestBody CreateBlogPostRequest request) {
        return service.createBlogPost(request);
    }
}
