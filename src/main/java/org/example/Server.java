package org.example;

import io.grpc.ServerBuilder;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        final int PORT = 8080;

        final io.grpc.Server server = ServerBuilder.forPort(PORT)
                .addService(new GreetingServiceImpl())
//                .addService(new GreetingServiceImpl()) // в других случаях вызываем несколько методов addService
                .build();

        server.start();

        System.out.println("Server started, listening on " + PORT);

        // чтобы программа не завершалась
        server.awaitTermination();
    }
}
