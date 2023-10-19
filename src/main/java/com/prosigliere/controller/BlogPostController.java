package com.prosigliere.controller;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface BlogPostController {

    @Operation(summary = "Create a new blog post")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Created blog post",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                        implementation = CreateBlogPostResponse.class
                    )
                )
            }
        )
    })
    CreateBlogPostResponse createBlogPost(
            @Parameter(description = "Necessary blog post informations to create a new post")
            CreateBlogPostRequest request
    );
}
