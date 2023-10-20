package com.prosigliere.controller.impl;

import com.prosigliere.controller.CommentController;
import com.prosigliere.domain.dto.request.CreateCommentRequest;
import com.prosigliere.domain.dto.response.CreateCommentResponse;
import com.prosigliere.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{blogPostId}/comments")
public class CommentControllerImpl implements CommentController {

    private final CommentService service;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCommentResponse createComment(
            @PathVariable Long blogPostId,
            @RequestBody @Valid CreateCommentRequest request
    ) {
        return service.createCommentResponse(blogPostId, request);
    }
}
