package com.example.firstspring.demo.model;

public class Response<T> {
    public int code;
    public String status;
    public T data;


    public Response(int code, String status, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }
}
