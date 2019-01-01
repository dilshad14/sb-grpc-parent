package in.appmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.appmaster.remote.MyRemote;

@Service
public class HelloWorldImpl implements HelloWorld {
	
	@Autowired
	MyRemote myRemoteimpl;

	public String returnHello() {
		
		myRemoteimpl.printDataFromInternet();
		return " Hello :: " + myRemoteimpl.getDataFromInternet() ;
	}

	public void printHello() {
		System.out.println("hello World");

	}

}
