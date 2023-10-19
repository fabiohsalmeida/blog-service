package com.prosigliere.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prosigliere.controller.impl.BlogPostControllerImpl;
import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.repository.BlogPostRepository;
import com.prosigliere.service.BlogPostService;
import com.prosigliere.util.BlogPostMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BlogPostControllerImpl.class)
public class BlogPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogPostService service;

    @MockBean
    private BlogPostRepository repository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldCreateBlogPost() throws Exception {
        CreateBlogPostRequest request = BlogPostMother.defaultCreateBlogPostRequest();
        String requestPayload = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/posts")
                .content(requestPayload)
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldNotCreateBlogPostInvalidWhenContentIsEmpty() throws Exception {
        CreateBlogPostRequest request = BlogPostMother.invalidCreateBlogPostRequestWithEmptyContent();
        String requestPayload = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/posts")
                        .content(requestPayload)
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldNotCreateBlogPostInvalidWhenTitleIsEmpty() throws Exception {
        CreateBlogPostRequest request = BlogPostMother.invalidCreateBlogPostRequestWithEmptyTitle();
        String requestPayload = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/posts")
                        .content(requestPayload)
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldNotCreateBlogPostInvalidWhenTitleAndContentAreEmpty() throws Exception {
        CreateBlogPostRequest request = BlogPostMother.invalidCreateBlogPostRequestWithEmptyTitleAndContent();
        String requestPayload = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/posts")
                        .content(requestPayload)
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }
}
