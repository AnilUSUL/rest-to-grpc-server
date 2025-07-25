package com.training.demo.service;

import com.example.grpc.proto.FieldARequest;
import com.example.grpc.proto.FieldAResponse;
import com.example.grpc.proto.FieldAServiceGrpc;
import com.training.demo.entity.FieldAEntity;
import com.training.demo.repository.FieldARepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class FieldAServiceImpl extends FieldAServiceGrpc.FieldAServiceImplBase {
    private final FieldARepository repository;

    public FieldAServiceImpl(FieldARepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveField(FieldARequest request, StreamObserver<FieldAResponse> responseObserver) {
        FieldAEntity entity = new FieldAEntity();
        entity.setName(request.getName());
        repository.save(entity);

        responseObserver.onNext(FieldAResponse.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();
    }
}
