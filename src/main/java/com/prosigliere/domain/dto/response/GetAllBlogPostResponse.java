package com.prosigliere.domain.dto.response;

import com.prosigliere.domain.model.BlogPostItem;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetAllBlogPostResponse {

    private List<BlogPostItem> blogPostList;
}
