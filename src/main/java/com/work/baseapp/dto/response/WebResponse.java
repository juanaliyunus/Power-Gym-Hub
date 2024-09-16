package com.work.baseapp.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebResponse<T> {
    private String status;
    private String message;
    private T data;
    private PagingResponse paging;
}
