package socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器socket对象
        ServerSocket serverSocket = new ServerSocket(10004);
        //获取socket对象
        Socket socket = serverSocket.accept();
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + "connected");
        //获取socket读取流
        BufferedReader buffIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //获取socket输出流
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        String line = null;
        while ((line = buffIn.readLine()) != null){
            System.out.println(line);
            out.println(line.toUpperCase());
        }
        socket.close();
        serverSocket.close();

    }
}
