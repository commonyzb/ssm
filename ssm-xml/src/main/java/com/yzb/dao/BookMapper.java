package com.yzb.dao;

import com.yzb.entity.Book;

import java.util.List;

public interface BookMapper {

    int addBook(Book book);

    int deleteBookById(int id);

    int updateBook(Book book);

    Book queryBookById(int id);

    List<Book> queryAllBook();

}
