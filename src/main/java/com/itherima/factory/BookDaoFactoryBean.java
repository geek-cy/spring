package com.itherima.factory;

import com.itherima.dao.BookDao;
import com.itherima.dao.impl.BookDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class BookDaoFactoryBean implements FactoryBean<BookDao> {
    public BookDao getObject() throws Exception {
        return new BookDaoImpl();
    }

    public Class<?> getObjectType() {
        return BookDao.class;
    }
}
