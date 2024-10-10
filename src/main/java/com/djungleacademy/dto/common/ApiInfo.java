package com.djungleacademy.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiInfo<T> {
    private boolean success;
    private String message;
    private T data;
// http code handle by response entity

// this mean there will be only 2 type of response format,

//    if obj needed
    public ApiInfo(Boolean success, String message, T data) {
        this.success = success; //boolean will be return with in method, so only need to give msg/msg+obj
        this.message = message;
        this.data = data;
    }
//    if it's void or failed
    public ApiInfo(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }


//——————————————————————————————————————————————————————————


    // Static method for success responses without data
    public static  ApiInfo<Void> successVoid(String message) {
        return new ApiInfo<>(true, message);
    }

    // Static method for success responses with data
    public static <T> ApiInfo<T> successReturn(String message, T data) {
        return new ApiInfo<>(true, message, data);
    }

    // Static method for failure responses
    public static  ApiInfo<Void> failure(String message) {
        return new ApiInfo<>(false, message);
    }

}


