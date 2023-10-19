package com.prosigliere.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
public class Error {

    private LocalDateTime timestamp;
    private Map<String, String> errors;
}
