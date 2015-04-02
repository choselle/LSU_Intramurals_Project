package App;

import java.net.SocketException;

import View.LoginView;
import View.Stage1;

public class Application {

	public Application() throws SocketException {

		OSCServer osc = new OSCServer();
		osc.launchOSServer();
		Stage1 stage = new Stage1();
		stage.open();
	}

	public static void main(String args[]) throws SocketException {

		Application app = new Application();
	}
}
