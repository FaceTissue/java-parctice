package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/***************************************************************************
 * @className: IOAndNIOTest
 * @date     : 2020/4/24 15:51
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class IOAndNIOTest {
    public static void main(String[] args) {
        nio();
    }

    public static void io() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("./kitty/src/main/java/io/UserFiles/normal_io.txt"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char)buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void nio() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("./kitty/src/main/java/io/UserFiles/normal_io.txt");
            FileChannel channel = in.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead = channel.read(buf);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char)buf.get());
                }
                buf.compact();
                bytesRead = channel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
