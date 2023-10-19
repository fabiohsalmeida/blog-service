package com.prosigliere.domain.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateBlogPostRequest {

    private String title;
    private String content;
}
