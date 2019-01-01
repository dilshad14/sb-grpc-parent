package in.appmaster;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import in.appmaster.grpc.stub.HelloRequest;
import in.appmaster.grpc.stub.HelloResponse;
import in.appmaster.grpc.stub.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class HelloServiceTest {
	private ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
	private HelloServiceGrpc.HelloServiceBlockingStub blockingStub;
	private HelloServiceGrpc.HelloServiceStub asyncStub;

	@Before
	public void initialize() {

		// public static void main (String [] args) {

		blockingStub = HelloServiceGrpc.newBlockingStub(channel);
		asyncStub = HelloServiceGrpc.newStub(channel);
		System.out.println("Channel Built...working on Stubs");
	}

	@Test
	public void blockingGreet() {

		HelloRequest req = HelloRequest.newBuilder().setFirstName("Dilshad").setLastName("Ahmad").build();

		HelloResponse resp = blockingStub.hello(req);
		System.out.println(resp.toString());
	}
	@Test
	public void asyncgGreet() {

		HelloRequest req = HelloRequest.newBuilder().setFirstName("Dilshad").setLastName("Ahmad").build();
		 StreamObserver<HelloResponse> respObserver = null ;
		 HelloResponse resp = HelloResponse.newBuilder().build();
		 
		 asyncStub.hello(req,respObserver);
		 //respObserver.onNext(resp);
		 respObserver.onCompleted();
		System.out.println(resp.toString());
	}

	@After
	public void destroy() throws InterruptedException {

		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		System.out.println("Shutting down Channel");
	}

}
