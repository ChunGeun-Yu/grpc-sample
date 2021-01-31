package com.example.demo.service;

import org.springframework.stereotype.Service;

import grpc.sample.MySampleRequest;
import grpc.sample.MySampleResponse;
import grpc.sample.MySampleServiceGrpc.MySampleServiceImplBase;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GrpcConsumerService extends MySampleServiceImplBase {
	
	@Override
    public void sampleCall1(MySampleRequest request, StreamObserver<MySampleResponse> responseObserver) {
        log.info("request. id: " + request.getId() + " , msg: " + request.getMessage());
        
        MySampleResponse sampleResponse = MySampleResponse.newBuilder()
                .setMessage("server res - " + request.getId() + "/" + request.getMessage())
                .setTimestamp(System.currentTimeMillis())
                .build();
 
        responseObserver.onNext(sampleResponse);
        responseObserver.onCompleted();
        
    }
	
	

}
