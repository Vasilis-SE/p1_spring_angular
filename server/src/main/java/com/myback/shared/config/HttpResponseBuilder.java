package com.myback.shared.config;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.myback.shared.dto.HttpResponseDto;
import com.myback.shared.dto.PaginationMetadata;

import java.util.List;

@Component
public class HttpResponseBuilder {

    public <T> HttpResponseDto<T> build(T data) {
        HttpResponseDto<T> httpResponse = new HttpResponseDto<>();
        httpResponse.setData(data);
        httpResponse.setPagination(null);
        return httpResponse;
    }

    public <T> HttpResponseDto<List<T>> build(Page<T> pageData) {
        PaginationMetadata paginationMeta = new PaginationMetadata();
        paginationMeta.setPageNo(pageData.getNumber());
        paginationMeta.setPageSize(pageData.getSize());
        paginationMeta.setTotalElements(pageData.getTotalElements());
        paginationMeta.setTotalPages(pageData.getTotalPages());
        paginationMeta.setLastPage(pageData.isLast());

        HttpResponseDto<List<T>> httpResponse = new HttpResponseDto<>();
        httpResponse.setData(pageData.getContent());
        httpResponse.setPagination(paginationMeta);

        return httpResponse;
    }

}
