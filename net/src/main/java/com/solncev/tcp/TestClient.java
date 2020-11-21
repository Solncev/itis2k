package com.solncev;

import java.io.IOException;

public class TestClient {

    public static void main(String[] args) throws IOException {
        GreetClient client = new GreetClient();
        client.startClient("127.0.0.1", 5555);
        System.out.println(client.sendMessage("Hello"));
        System.out.println(client.sendMessage("HeLlO"));
        System.out.println(client.sendMessage("123"));
        System.out.println(client.sendMessage("dsgf"));
        System.out.println(client.sendMessage("bye"));
        client.stopClient();
    }
}
