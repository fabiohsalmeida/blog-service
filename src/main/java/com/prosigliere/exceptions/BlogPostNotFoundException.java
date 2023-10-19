package com.prosigliere.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlogPostNotFoundException extends RuntimeException {

    public BlogPostNotFoundException(Long id) {
        super(String.format("Blog post %d not found.", id));
    }
}
