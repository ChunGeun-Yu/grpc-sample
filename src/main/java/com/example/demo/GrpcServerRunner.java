package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.GrpcConsumerService;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GrpcServerRunner implements ApplicationRunner {

    Server grpcServer = ServerBuilder.forPort(8888)
            .addService(new GrpcConsumerService())
            .build();
 
    @Override
    public void run(ApplicationArguments args) throws Exception {
    	log.info("grpcServer is starting");
    	grpcServer.start();
    }
}
