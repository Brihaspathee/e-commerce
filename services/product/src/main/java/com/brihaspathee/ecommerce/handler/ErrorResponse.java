package com.brihaspathee.ecommerce.handler;

import lombok.Builder;

import java.util.Map;

@Builder
public record ErrorResponse(
        Map<String, String> errors
) {
}
