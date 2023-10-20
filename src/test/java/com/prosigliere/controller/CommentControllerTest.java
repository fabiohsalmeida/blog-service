package com.prosigliere.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prosigliere.domain.dto.request.CreateCommentRequest;
import com.prosigliere.repository.BlogPostRepository;
import com.prosigliere.repository.CommentRepository;
import com.prosigliere.service.BlogPostService;
import com.prosigliere.service.CommentService;
import com.prosigliere.util.CommentMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogPostService blogPostService;

    @MockBean
    private CommentService commentService;

    @MockBean
    private BlogPostRepository blogPostRepository;

    @MockBean
    private CommentRepository commentRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldCreateComment() throws Exception {
        CreateCommentRequest request = CommentMother.defaultCreateCommentRequest();
        String requestPayload = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/posts/1/comments")
                .content(requestPayload)
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }
}
