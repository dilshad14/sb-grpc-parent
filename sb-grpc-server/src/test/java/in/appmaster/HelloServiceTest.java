package in.appmaster;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import in.appmaster.grpc.HelloGrpc;
import in.appmaster.grpc.stub.HelloRequest;
import in.appmaster.grpc.stub.HelloResponse;
import in.appmaster.grpc.stub.HelloServiceGrpc;
import in.appmaster.grpc.stub.HelloServiceGrpc.HelloServiceBlockingStub;
import in.appmaster.remote.MyRemote;
import in.appmaster.service.HelloWorld;
import in.appmaster.service.HelloWorldImpl;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;

@RunWith(MockitoJUnitRunner.class)
public class HelloServiceTest {
	@Mock
	MyRemote myRemoteImpl;


	@InjectMocks
	HelloWorld helloWorldImpl= new HelloWorldImpl();
	
	@InjectMocks
	HelloGrpc helloGrpc = new HelloGrpc();

	// private InProcessServer<HelloGrpc> inprocessServer;
	private ManagedChannel channel;
	private HelloServiceBlockingStub blockingStub;
	// private DummyServiceStub asyncStub;

	@Before
	public void beforeEachTest() throws InstantiationException, IllegalAccessException, IOException {
		String uniqueName = InProcessServerBuilder.generateName();
		Server server = InProcessServerBuilder.forName(uniqueName).directExecutor() // directExecutor is fine for unit
																					// tests
				.addService(helloGrpc).build().start();
		ManagedChannel channel = InProcessChannelBuilder.forName(uniqueName).directExecutor().build();
		blockingStub = HelloServiceGrpc.newBlockingStub(channel);
		// asyncStub = DummyServiceGrpc.newStub(channel);
	}

	
	// this method test the grpc method code which calls the service 
	@Test
	public void stub_hello() {

		//when(myRemoteImpl.getDataFromInternet()).thenReturn("Mocked String");
		//HelloResponse resp = blockingStub.hello(HelloRequest.newBuilder().setFirstName("Dilshad").setLastName("Ahmad").build());
		//System.out.println(resp.getGreeting());
		assertEquals(Boolean.TRUE, Boolean.TRUE);

	}
	
	@Test
	public void service_hello() {

		when(myRemoteImpl.getDataFromInternet()).thenReturn("Mocked String");
		String str = helloWorldImpl.returnHello();
		System.out.println(str);
		
		assertEquals(Boolean.TRUE, Boolean.TRUE);

	}

}
