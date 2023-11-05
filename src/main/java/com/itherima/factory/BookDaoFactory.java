package com.itherima.factory;

import com.itherima.dao.BookDao;
import com.itherima.dao.impl.BookDaoImpl;

public class BookDaoFactory {

    public static BookDao getBookDao() {
        return new BookDaoImpl();
    }

    public BookDao getBookDao2() {
        return new BookDaoImpl();
    }
}
