package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.GrpcProducerService;
import com.example.demo.vo.MyRes;

@RestController
public class GrpcSampleController {
	
	@Autowired
	GrpcProducerService grpcService;
	
	@GetMapping("/grpc")
	public MyRes sendMsg(
			@RequestParam("id") String id,
			@RequestParam("msg") String msg
			) {
		
		var res = grpcService.sendMsg(id, msg);
		return res;
	}

}
