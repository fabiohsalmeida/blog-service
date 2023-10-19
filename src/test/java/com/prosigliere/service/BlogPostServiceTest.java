package com.prosigliere.service;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.dto.response.GetAllBlogPostResponse;
import com.prosigliere.domain.dto.response.GetBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.exceptions.BlogPostNotFoundException;
import com.prosigliere.repository.BlogPostRepository;
import com.prosigliere.util.BlogPostMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void validGetBlogPost() {
        Long requestId = 1L;
        BlogPostEntity mockedEntity = BlogPostMother.defaultBlogPostEntity();

        when(repository.findById(requestId)).thenReturn(Optional.of(mockedEntity));

        GetBlogPostResponse response = service.getBlogPostById(requestId);

        assertEquals(mockedEntity.getId(), response.getId());
        assertEquals(mockedEntity.getTitle(), response.getTitle());
        assertEquals(mockedEntity.getContent(), response.getContent());
    }

    @Test
    void invalidGetBlogPostNotFound() {
        Long requestId = 1L;

        when(repository.findById(requestId)).thenReturn(Optional.empty());

        BlogPostNotFoundException exception = assertThrows(
                BlogPostNotFoundException.class, () -> { service.getBlogPostById(requestId); }
        );

        assertEquals("Blog post 1 not found.", exception.getMessage());
    }

    @Test
    void listBlogPost() {
        List<BlogPostEntity> blogPostEntityList = BlogPostMother.listOfBlogPostEntity(3);

        when(repository.findAll()).thenReturn(blogPostEntityList);

        GetAllBlogPostResponse response = service.listBlogPosts();

        assertEquals(blogPostEntityList.size(), response.getBlogPostList().size());
    }
}
