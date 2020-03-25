package com.gxx.java.serializabletest;

import java.io.IOException;
import java.util.Arrays;

/***************************************************************************
 * @className: SerializableTest
 * @date     : 2020/3/16 13:52
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Book book = new Book();
        book.setName("Hello Java");
        book.setIsbn("ABC123456789");
        book.setAuthors(Arrays.asList("John", "Eric"));
        Author author = new Author();
        author.setName("zs");
        author.setAge("24");
        book.setMainAuthor(author);

        System.out.println("book==>" + book);

        String fileName = "book.temp";
        SerializationUtil.serialize(book, fileName);

        Book deserializedBook = (Book) SerializationUtil.deserialize(fileName);
        System.out.println("deserializedBook==>" + deserializedBook);
    }
}
