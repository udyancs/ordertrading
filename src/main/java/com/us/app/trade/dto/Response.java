package com.us.app.trade.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Udyan Shardhar
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    public ApiError error;

    public ApiError getError() {
        return error;
    }
}
