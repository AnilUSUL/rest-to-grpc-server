package com.training.demo.config;

import com.example.grpc.proto.FieldAServiceGrpc;
import com.example.grpc.proto.FieldBServiceGrpc;
import com.example.grpc.proto.FieldCServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {
    @Bean
    public FieldAServiceGrpc.FieldAServiceBlockingStub fieldAStub() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        return FieldAServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public FieldBServiceGrpc.FieldBServiceBlockingStub fieldBStub() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        return FieldBServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public FieldCServiceGrpc.FieldCServiceBlockingStub fieldCStub() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        return FieldCServiceGrpc.newBlockingStub(channel);
    }
}
