package com.myback.shared.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PaginationMetadata {
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean isLastPage;
}
