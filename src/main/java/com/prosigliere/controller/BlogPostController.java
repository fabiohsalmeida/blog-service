package com.prosigliere.controller;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;

public interface BlogPostController {

    CreateBlogPostResponse createBlogPost(CreateBlogPostRequest request);
}
