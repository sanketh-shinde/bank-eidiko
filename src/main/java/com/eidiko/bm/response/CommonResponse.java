package com.eidiko.bm.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResponse<T> {
    private String message;
    private String status;
    private int code;
    private T result;
}
