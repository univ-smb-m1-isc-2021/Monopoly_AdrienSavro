package socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadCalcul implements Runnable{
	
	Socket S;
	String expression = "";
	String resultat = "";
	
	public ThreadCalcul(Socket S){
		this.S = S;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
