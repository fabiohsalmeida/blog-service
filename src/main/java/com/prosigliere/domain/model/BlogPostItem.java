package com.prosigliere.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogPostItem {

    private Long id;
    private String title;
    private Integer numberOfComments;
}
