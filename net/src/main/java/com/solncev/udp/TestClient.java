package com.solncev.udp;

import java.io.IOException;

public class TestClient {
    public static void main(String[] args) throws IOException {
        new GreetServer().start();
        GreetClient client = new GreetClient();

        String response = client.sendMessage("hello");
        System.out.println(response);


        response = client.sendMessage("bye");
        System.out.println(response);

        response = client.sendMessage("hello");
        System.out.println(response);
    }
}
