package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.vo.MyRes;

import grpc.sample.MySampleRequest;
import grpc.sample.MySampleResponse;
import grpc.sample.MySampleServiceGrpc;
import grpc.sample.MySampleServiceGrpc.MySampleServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GrpcProducerService {
	
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888)
			.usePlaintext()
			.build();
	
    MySampleServiceBlockingStub stub = MySampleServiceGrpc.newBlockingStub(channel);
        
    public MyRes sendMsg(String id, String msg) {
    	
    	var req = MySampleRequest.newBuilder()
		          .setId(id)
		          .setMessage(msg)
		          .build();
		          
		MySampleResponse res = stub.sampleCall1(req);
		        
        MyRes myRes = new MyRes(res.getMessage(), res.getTimestamp());
        
        log.info("myRes: " + myRes);

        return myRes;
//        channel.shutdown();
    }

}
