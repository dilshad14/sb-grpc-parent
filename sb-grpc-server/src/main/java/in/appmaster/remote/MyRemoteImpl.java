package in.appmaster.remote;

import org.springframework.stereotype.Service;

@Service
public class MyRemoteImpl implements MyRemote {

	public String getDataFromInternet() {
		// TODO Auto-generated method stub
		return " Taken From Internet ";
	}

	public void printDataFromInternet() {
		System.out.println("printed this from Internet");

	}

}
