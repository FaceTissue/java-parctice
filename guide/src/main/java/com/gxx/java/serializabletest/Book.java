package com.gxx.java.serializabletest;

import java.io.Serializable;
import java.util.List;

/***************************************************************************
 * @className: Book
 * @date     : 2020/3/16 11:53
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private transient String isbn;
    private transient List<String> authors;
    private Author mainAuthor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Author getMainAuthor() {
        return mainAuthor;
    }

    public void setMainAuthor(Author mainAuthor) {
        this.mainAuthor = mainAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                ", mainAuthor=" + mainAuthor +
                '}';
    }

    //    private void readObject() {
//
//    }
}
