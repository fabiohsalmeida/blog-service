package com.prosigliere.mapper;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import org.junit.jupiter.api.Test;

import static com.prosigliere.util.BlogPostMother.defaultBlogPostEntity;
import static com.prosigliere.util.BlogPostMother.defaultCreateBlogPostRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class BlogPostMapperTest {

    @Test
    void mapFromEntityToCreateBlogPostResponse() {
        BlogPostEntity mockedEntity = defaultBlogPostEntity();

        CreateBlogPostResponse mappedDto = BlogPostMapper.mapEntityToCreateBlogPostResponse(mockedEntity);

        assertEquals(mockedEntity.getId(), mappedDto.getId());
    }

    @Test
    void mapFromCreateBlogPostRequestToEntity() {
        CreateBlogPostRequest mockedRequest = defaultCreateBlogPostRequest();

        BlogPostEntity mappedEntity = BlogPostMapper.mapCreateBlogPostRequestToEntity(mockedRequest);

        assertNull(mappedEntity.getId());
        assertEquals(mockedRequest.getTitle(), mappedEntity.getTitle());
        assertEquals(mockedRequest.getContent(), mockedRequest.getContent());
    }
}
