package com.deepaksp.springboot.model;

import java.math.BigInteger;

public class Greeting {

    private BigInteger id;

    private String text;

    public Greeting() {
    }

    public BigInteger getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

}
