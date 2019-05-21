package demo.myTomcat;

import java.io.IOException;

public class HelloWorldServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("GET: hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("POST: hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
