package in.appmaster.grpc;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.appmaster.grpc.stub.HelloRequest;
import in.appmaster.grpc.stub.HelloResponse;
import in.appmaster.grpc.stub.HelloServiceGrpc.HelloServiceImplBase;
import in.appmaster.service.HelloWorld;
import io.grpc.stub.StreamObserver;


@GRpcService
public class HelloGrpc extends HelloServiceImplBase  {
	
	@Autowired
	HelloWorld hwImpl;
	
	@java.lang.Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver)
    {
    	String greeting = hwImpl.returnHello();
      //ServerCalls.asyncUnimplementedUnaryCall(HelloServiceGrpc.METHOD_HELLO, responseObserver);
    	HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting +request.getFirstName()+ " "+request.getLastName()).build();
    	responseObserver.onNext(response);
    	responseObserver.onCompleted();
    	
    }

}
