package com.prosigliere.service;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.repository.BlogPostRepository;
import com.prosigliere.util.BlogPostMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BlogPostServiceTest {

    @InjectMocks
    private BlogPostService service;
    
    @Mock
    private BlogPostRepository repository;
    
    @Test
    void createBlogPost() {
        CreateBlogPostRequest request = BlogPostMother.defaultCreateBlogPostRequest();
        BlogPostEntity mockedEntity = BlogPostMother.defaultBlogPostEntity();
        
        when(repository.save(any())).thenReturn(mockedEntity);

        CreateBlogPostResponse response = service.createBlogPost(request);
        
        assertEquals(mockedEntity.getId(), response.getId());
    }
}
