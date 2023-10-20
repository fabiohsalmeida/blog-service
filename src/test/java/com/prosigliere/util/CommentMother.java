package com.prosigliere.util;

import com.prosigliere.domain.dto.request.CreateCommentRequest;
import com.prosigliere.domain.entity.BlogPostEntity;
import com.prosigliere.domain.entity.CommentEntity;

import java.util.ArrayList;
import java.util.List;

public class CommentMother {

    public static CommentEntity parameterizableCommentEntity(BlogPostEntity blogPost, Long commentId) {
        String content = String.format("Comment number %d", commentId);

        return CommentEntity.builder()
                .id(commentId)
                .blogPost(blogPost)
                .content(content)
                .build();
    }

    public static CommentEntity defaultCommentEntity() {
        BlogPostEntity blogPost = BlogPostMother.defaultBlogPostEntity();

        return parameterizableCommentEntity(blogPost, 1L);
    }

    public static List<CommentEntity> listOfCommentEntity(int numberOfComments, BlogPostEntity blogPost) {
        List<CommentEntity> commentEntityList = new ArrayList<>();

        for (int i = 0; i < numberOfComments; i++) {
            CommentEntity entity = parameterizableCommentEntity(blogPost, Long.valueOf(i));

            commentEntityList.add(entity);
        }

        return commentEntityList;
    }

    public static CreateCommentRequest defaultCreateCommentRequest() {
        return CreateCommentRequest.builder()
                .content("Comment content")
                .build();
    }
}
