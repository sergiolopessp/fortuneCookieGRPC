package com.deviniciative.grpcFortune;

import com.deviniciative.services.FortuneService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class fortuneCookie {
    public static void main(String[] args) {
        int port = 8080;
        System.out.println("Iniciando o servidor gRPC na porta " + port);
        Server server = ServerBuilder.forPort(port).addService(new FortuneService()).build();

        try {
            server.start();
            System.out.println("Servidor inicializado com sucesso na porta: " + port);
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            System.out.println("Servidor não conseguiu subir por " + e.getMessage());
        }
    }
}
