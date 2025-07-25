package com.training.demo.service;

import com.example.grpc.proto.*;
import com.training.demo.entity.FieldBEntity;
import com.training.demo.repository.FieldBRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class FieldBServiceImpl extends FieldBServiceGrpc.FieldBServiceImplBase {
    private final FieldBRepository repository;

    public FieldBServiceImpl(FieldBRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveField(FieldBRequest request, StreamObserver<FieldBResponse> responseObserver) {
        FieldBEntity entity = new FieldBEntity();
        entity.setAge(request.getAge());
        repository.save(entity);

        FieldBResponse response = FieldBResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
