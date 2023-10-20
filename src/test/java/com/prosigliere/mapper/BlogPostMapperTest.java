package com.prosigliere.mapper;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.dto.response.GetAllBlogPostResponse;
import com.prosigliere.domain.dto.response.GetBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.domain.model.BlogPostItem;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static com.prosigliere.util.BlogPostMother.*;
import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void mapFromEntityToGetBlogPostResponse() {
        BlogPostEntity mockedEntity = defaultBlogPostEntity();

        GetBlogPostResponse mappedResponse = BlogPostMapper.mapEntityToGetBlogPostResponse(mockedEntity);

        assertEquals(mockedEntity.getId(), mappedResponse.getId());
        assertEquals(mockedEntity.getTitle(), mappedResponse.getTitle());
        assertEquals(mockedEntity.getContent(), mappedResponse.getContent());
    }

    @Test
    void mapEntityListToGetAllBlogPostResponse() {
        List<BlogPostEntity> mockedEntityList = listOfBlogPostEntity(10);

        GetAllBlogPostResponse response = BlogPostMapper.mapEntityListToGetAllBlogPostResponse(mockedEntityList);

        List<BlogPostItem> blogPostResponseList = response.getBlogPostList();
        assertEquals(mockedEntityList.size(), blogPostResponseList.size());

        for (BlogPostItem item : blogPostResponseList) {
            Optional<BlogPostEntity> foundEntity = mockedEntityList.stream().filter(
                    entity -> entity.getId() == item.getId() &&
                            entity.getTitle().equals(item.getTitle()) &&
                            entity.getComments().size() == item.getNumberOfComments()
            ).findFirst();

            assertTrue(foundEntity.isPresent());
        }
    }
}
