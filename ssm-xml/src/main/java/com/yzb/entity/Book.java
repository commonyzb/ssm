package com.yzb.entity;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String bookName;
    private Integer bookCounts;
    private String detail;
}
