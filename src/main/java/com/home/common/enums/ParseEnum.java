package com.home.common.enums;


public enum ParseEnum {
    
    CSV("csv"), XML("xml"), JSON("json");

    private String format;

    private ParseEnum(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

   
    
}
