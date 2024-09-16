package com.work.baseapp.dto.response;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class PagingResponse {
    private Integer page;
    private Integer size;
    private Integer totalPages;
    private Long totalElements;
    private Boolean hasNext;
    private Boolean hasPrevious;
}
