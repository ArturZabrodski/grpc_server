package org.example;


import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request, StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        System.out.println(request);

        // паттерн Builder - используется в grpc, для конструирования Responce
        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse
                .newBuilder()
                .setGreeting("Hello from server, " + request.getName())  // полей может быть вызвано много, по порядку
                .build();

        // отсылаем response клиенту
        responseObserver.onNext(response);

        // вызывая метод onCompleted, мы заканчиваем работу и не будем больше пересылать данные
        responseObserver.onCompleted();
    }
}
