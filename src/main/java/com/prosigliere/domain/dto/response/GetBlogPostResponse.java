package com.prosigliere.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetBlogPostResponse {

    private Long id;
    private String title;
    private String content;
    private List<String> comments;
}
