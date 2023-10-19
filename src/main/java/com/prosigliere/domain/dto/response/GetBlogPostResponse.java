package com.prosigliere.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetBlogPostResponse {

    private Long id;
    private String title;
    private String content;
}
