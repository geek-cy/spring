package com.itherima.service.impl;

import com.itherima.dao.BookDao;
import com.itherima.dao.impl.BookDaoImpl;
import com.itherima.service.BookService;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    @Override
    public void addBook() {
        bookDao.addBook();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
