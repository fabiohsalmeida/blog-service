package com.prosigliere.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetAllBlogPostResponse {

    private List<GetBlogPostResponse> blogPostList;
}
