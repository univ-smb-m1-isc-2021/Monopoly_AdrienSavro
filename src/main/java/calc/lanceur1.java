package calc;

import java.io.IOException;

public class lanceur1 {
	public static void main(String[] arg) throws IOException{
		Calculatrice calc = new Calculatrice(new MoteurCalculSimple());
	}
}
