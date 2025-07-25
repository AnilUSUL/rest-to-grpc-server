package com.training.demo;

import com.training.demo.service.FieldAServiceImpl;
import com.training.demo.service.FieldBServiceImpl;
import com.training.demo.service.FieldCServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        Server serverA = null;
        try {
             serverA = ServerBuilder.forPort(50051)
                    .addService(context.getBean(FieldAServiceImpl.class))
                    .build()
                    .start();

            Server serverB = ServerBuilder.forPort(50052)
                    .addService(context.getBean(FieldBServiceImpl.class))
                    .build()
                    .start();

            Server serverC = ServerBuilder.forPort(50053)
                    .addService(context.getBean(FieldCServiceImpl.class))
                    .build()
                    .start();

            System.out.println("gRPC Sunucuları Başladı: 50051, 50052, 50053");

            serverA.awaitTermination();
            serverB.awaitTermination();
            serverC.awaitTermination();

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
