package com.myback.config;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

import com.myback.dto.HttpResponseDto;
import com.myback.dto.PaginationMetadata;

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
