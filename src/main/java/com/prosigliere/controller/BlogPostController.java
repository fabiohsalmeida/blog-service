package com.prosigliere.controller;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.dto.response.GetBlogPostResponse;
import com.prosigliere.domain.model.Error;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface BlogPostController {

    @Operation(summary = "Create a new blog post")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created blog post", content = {
            @Content(mediaType = "application/json", schema = @Schema(
                implementation = CreateBlogPostResponse.class
            ))
        }),
        @ApiResponse(responseCode = "400", description = "Invalid request, content or title shouldn't be null", content = {
            @Content(mediaType = "application/json", schema = @Schema(
                implementation = Error.class
            ))
        })
    })
    CreateBlogPostResponse createBlogPost(
            @Parameter(description = "Necessary blog post informations to create a new post")
            CreateBlogPostRequest request
    );

    @Operation(summary = "Get a existing blog post")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get blog post by ID", content = {
            @Content(mediaType = "application/json", schema = @Schema(
                implementation = GetBlogPostResponse.class
            ))
        }),
        @ApiResponse(responseCode = "404", description = "Blog post not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(
                implementation = Error.class
            ))
        })
    })
    GetBlogPostResponse getBlogPostById(
            @Parameter(description = "ID of blog post that should be returned")
            Long id
    );
}
