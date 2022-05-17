package com.example.drones.utils;

public class Event {
    private String msg;

    private Event(String msg){
        this.msg = msg;
    }

    public static Event getInstance(String msg){
        return new Event(msg);
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}
