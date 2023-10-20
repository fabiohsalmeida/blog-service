package com.prosigliere.controller;

import com.prosigliere.domain.dto.request.CreateCommentRequest;
import com.prosigliere.domain.dto.response.CreateCommentResponse;
import com.prosigliere.domain.model.Error;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface CommentController {

    @Operation(summary = "Create a new comment to a blog post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created new comment to blog post", content = {
                    @Content(mediaType = "application/json", schema = @Schema(
                            implementation = CreateCommentResponse.class
                    ))
            }),
            @ApiResponse(responseCode = "404", description = "Blog post not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(
                            implementation = Error.class
                    ))
            })
    })
    CreateCommentResponse createComment(
            @Parameter(description = "Blog post ID which the comment will be created")
            Long blogPostId,
            @Parameter(description = "Request body for creating a new comment")
            CreateCommentRequest request
    );
}
