package socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建socket对象
        Socket socket = new Socket("192.168.1.172",10004);
        //获取键盘输入
        BufferedReader buffOut = new BufferedReader(new InputStreamReader(System.in));
        //socket输出流
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        //socket输入流，读取服务端返回的数据
        BufferedReader buffIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = null;
        while ((line = buffOut.readLine()) != null){
            if ("over".equals(line)){
                break;
            }
            out.println(line);
            String lineIn = buffIn.readLine();
            System.out.println(lineIn);
        }
        socket.close();
    }
}
