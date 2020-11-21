package com.solncev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        String message;
        while ((message = in.readLine()) != null){
        if (message.toLowerCase().equals("hello")) {
            out.println(message + " from server");
        } else if (message.toLowerCase().equals("bye")) {
            out.println("bye");
            stopServer();
            break;
        } else
            out.println("??");
        }
    }

    public void stopServer() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        GreetServer server = new GreetServer();
        server.startServer(5555);
    }
}
