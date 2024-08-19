package com.myback.config;

import org.springframework.data.domain.Page;

import com.myback.dto.HttpResponseDto;
import com.myback.dto.PaginationMetadata;

public class HttpResponseBuilder {

    @SuppressWarnings("unchecked")
    public static <T> HttpResponseDto<T> build(Object data) {
        HttpResponseDto<T> httpResponse = new HttpResponseDto<T>();

        if (data instanceof Page) {
            Page<T> pageData = (Page<T>) data;

            PaginationMetadata paginationMeta = new PaginationMetadata();
            paginationMeta.setPageNo(pageData.getNumber());
            paginationMeta.setPageSize(pageData.getSize());
            paginationMeta.setTotalElements(pageData.getTotalElements());
            paginationMeta.setTotalPages(pageData.getTotalPages());
            paginationMeta.setLastPage(pageData.isLast());

            httpResponse.setData(pageData.getContent());
            httpResponse.setPagination(paginationMeta);

            return httpResponse;
        } 
        
        httpResponse.setData(data);
        httpResponse.setPagination(null);    
        return httpResponse;
    }

}
