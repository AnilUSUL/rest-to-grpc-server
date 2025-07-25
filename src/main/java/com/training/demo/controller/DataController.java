package com.training.demo.controller;

import com.example.grpc.proto.*;
import com.training.demo.dto.RequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {
    private final FieldAServiceGrpc.FieldAServiceBlockingStub fieldAStub;
    private final FieldBServiceGrpc.FieldBServiceBlockingStub fieldBStub;
    private final FieldCServiceGrpc.FieldCServiceBlockingStub fieldCStub;

    public DataController(FieldAServiceGrpc.FieldAServiceBlockingStub fieldAStub, FieldBServiceGrpc.FieldBServiceBlockingStub fieldBStub, FieldCServiceGrpc.FieldCServiceBlockingStub fieldCStub){
        this.fieldAStub = fieldAStub;
        this.fieldBStub = fieldBStub;
        this.fieldCStub = fieldCStub;
    }

    @PostMapping
    public ResponseEntity<String> receive(@RequestBody RequestDto dto) {
        // fieldA: string
        fieldAStub.saveField(FieldARequest.newBuilder().setName(dto.getFieldA()).build());

        // fieldB: int
        fieldBStub.saveField(FieldBRequest.newBuilder().setAge(dto.getFieldB()).build());

        // fieldC: boolean
        fieldCStub.saveField(FieldCRequest.newBuilder().setActive(dto.isFieldC()).build());
        return ResponseEntity.ok("Veriler gRPC üzerinden DB'ye kaydedildi.");
    }
}
