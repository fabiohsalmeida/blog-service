package com.prosigliere.util;

import com.prosigliere.domain.dto.request.CreateBlogPostRequest;
import com.prosigliere.domain.dto.response.CreateBlogPostResponse;
import com.prosigliere.domain.dto.response.GetAllBlogPostResponse;
import com.prosigliere.domain.entity.BlogPostEntity;

import java.util.ArrayList;
import java.util.List;

public class BlogPostMother {

    public static BlogPostEntity defaultBlogPostEntity() {
        return parameterizableBlogPostEntity(1L);
    }

    public static List<BlogPostEntity> listOfBlogPostEntity(int numberOfEntities) {
        List<BlogPostEntity> entityList = new ArrayList<>();

        for (int i = 0; i < numberOfEntities; i++) {
            BlogPostEntity entity = parameterizableBlogPostEntity(Long.valueOf(i));

            entityList.add(entity);
        }

        return entityList;
    }

    private static BlogPostEntity parameterizableBlogPostEntity(Long id) {
        String title = String.format("Sample title for blog post %d", id);
        String content = String.format("Sample content for blog post %d", id);

        return BlogPostEntity.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }

    public static CreateBlogPostRequest defaultCreateBlogPostRequest() {
        return CreateBlogPostRequest.builder()
                .title("Sample title for create blog post 1")
                .content("Sample content for create blog post 1")
                .build();
    }

    public static CreateBlogPostRequest invalidCreateBlogPostRequestWithEmptyContent() {
        return CreateBlogPostRequest.builder()
                .title("Sample title for create blog post 1")
                .build();
    }

    public static CreateBlogPostRequest invalidCreateBlogPostRequestWithEmptyTitle() {
        return CreateBlogPostRequest.builder()
                .content("Sample content for create blog post 1")
                .build();
    }

    public static CreateBlogPostRequest invalidCreateBlogPostRequestWithEmptyTitleAndContent() {
        return CreateBlogPostRequest.builder().build();
    }
}
