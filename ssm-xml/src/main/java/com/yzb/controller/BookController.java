package com.yzb.controller;

import com.yzb.entity.Book;
import com.yzb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Book> books = bookService.queryAllBook();
        model.addAttribute("books", books);
        return "allBook";
    }

    @RequestMapping("/addBook")
    public String addBook(){
        return "addBook";
    }

    @RequestMapping(value = "/addBook",method = RequestMethod.POST)
    public String addBook(Book book){
        if(bookService.addBook(book) == 1){
            System.out.println("添加书籍成功！");
        }
        return "redirect:/book/allBook";
    }

    @RequestMapping(value = "/updateBook")
    public String upadteBook(Integer id,Model model){
        Book book = bookService.queryBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    @RequestMapping(value = "/updateBook",method = RequestMethod.POST)
    public String updateBook(Book book){
        if(bookService.updateBook(book) == 1){
            System.out.println("添加书籍成功！");
        }
        return "redirect:/book/allBook";
    }

    @RequestMapping(value = "/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Integer id){
        if (bookService.deleteBookById(id) == 1){
            System.out.println("删除书籍成功！");
        }
        return "redirect:/book/allBook";
    }

}