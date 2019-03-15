package com.concordia.cejv669.recyclerviewclass6;

import java.io.Serializable;

public class Book implements Serializable {
    private int ISBN;
    private String name;
    private int pages;
    private boolean lent;

    //Database
    public static final String TABLE_NAME="books";
    public static final String COLUMN_ISBN="isbn";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PAGES="pages";
    public static final String COLUMN_LENT="lent";

    public static final String CREATE_TABLE=
            "CREATE TABLE " + TABLE_NAME
            + "(" + COLUMN_ISBN + " INTEGER PRIMARY KEY , "
                  + COLUMN_NAME + " TEXT,"
                  + COLUMN_PAGES + " INTEGER,"
                  + COLUMN_LENT + " INTEGER)";


    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(int ISBN, String name, int pages, boolean lent) {
        this.ISBN = ISBN;
        this.name = name;
        this.pages = pages;
        this.lent = lent;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isLent() {
        return lent;
    }

    public void setLent(boolean lent) {
        this.lent = lent;
    }
}
