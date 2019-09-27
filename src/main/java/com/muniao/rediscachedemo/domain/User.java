package com.muniao.rediscachedemo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable
{
    private Long id;
    private String name;
    private int age;
    private String adress;
}
