package com.abhi.contentcalender.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String description,
        Status status,
        Type type,
        LocalDateTime createdOn,
        LocalDateTime updatedOn,

        String url
){}
