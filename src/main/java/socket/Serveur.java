package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import calc.ExpressionInvalide;
import calc.MoteurCalculSimple;

public class Serveur {
	public static void main(String[] args) throws IOException, ExpressionInvalide{
		ServerSocket SS = new ServerSocket(2000);
        SS.setReuseAddress(true);
		
		while(true) {
			Socket S = SS.accept();
			ThreadCalcul thread = new ThreadCalcul(S);
		}
	}
}
