package com.training.demo.service;

import com.example.grpc.proto.FieldCRequest;
import com.example.grpc.proto.FieldCResponse;
import com.example.grpc.proto.FieldCServiceGrpc;
import com.training.demo.entity.FieldCEntity;
import com.training.demo.repository.FieldCRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class FieldCServiceImpl extends FieldCServiceGrpc.FieldCServiceImplBase {
    private final FieldCRepository repository;

    public FieldCServiceImpl(FieldCRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveField(FieldCRequest request, StreamObserver<FieldCResponse> responseObserver) {
        FieldCEntity entity = new FieldCEntity();
        entity.setActive(request.getActive());
        repository.save(entity);

        FieldCResponse response = FieldCResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}