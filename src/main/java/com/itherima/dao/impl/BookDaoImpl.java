package com.itherima.dao.impl;

import com.itherima.dao.BookDao;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


@Setter
@ToString
public class BookDaoImpl implements BookDao {

    private int connectionNum;
    private String databaseName;

    private int[] array;

    private List<String> list;

    private Set<String> set;

    private Map<String, String> map;

    private Properties properties;

    @Override
    public void addBook() {
        System.out.println("add book");
    }

    public BookDaoImpl() {
        System.out.println("constructor none");
    }

    public BookDaoImpl(int connectionNum, String databaseName) {
        this.connectionNum = connectionNum;
        this.databaseName = databaseName;
        System.out.println("connectionNum:" + connectionNum + "databaseName:" + databaseName);
    }
}
