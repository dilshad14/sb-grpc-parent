package in.appmaster;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.protobuf.Descriptors.FieldDescriptor;

import in.appmaster.grpc.stub.HelloRequest;
import in.appmaster.grpc.stub.HelloResponse;
import in.appmaster.grpc.stub.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.BindableService;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;;

/**
 * Hello world!
 *
 */


@SpringBootApplication
public class Application  
{
	public static void main (String [] args) {
		SpringApplication.run(Application.class,args);
	}
	
	




}
