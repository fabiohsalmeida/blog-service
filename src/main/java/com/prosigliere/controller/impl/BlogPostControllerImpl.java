package com.prosigliere.controller.impl;

import com.prosigliere.controller.BlogPostController;
import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.dto.response.GetBlogPostResponse;
import com.prosigliere.domain.model.Error;
import com.prosigliere.service.BlogPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class BlogPostControllerImpl implements BlogPostController {

    private final BlogPostService service;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBlogPostResponse createBlogPost(@RequestBody @Valid CreateBlogPostRequest request) {
        return service.createBlogPost(request);
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBlogPostResponse getBlogPostById(@PathVariable Long id) {
        return service.getBlogPostById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Error handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().stream().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return Error.builder()
                .timestamp(LocalDateTime.now())
                .errors(errors)
                .build();
    }
}
