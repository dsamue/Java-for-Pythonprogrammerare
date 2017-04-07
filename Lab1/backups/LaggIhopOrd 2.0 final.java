import java.util.Scanner;
import java.io.*;

public class LaggIhopOrd {

    public static void main(String[] args) {

    	Scanner data = null;
    	Integer antal;
    	String ord;
    	String sammansatt = "";

    
	    data = new Scanner(System.in);
        antal = Integer.parseInt(data.next());   //fyller egentligen ingen mer funktion än att ta bort första int:en. 

        while(data.hasNext()) {
            ord = data.next();
            sammansatt = sammansatt + ord;
            
        }

        System.out.println(sammansatt); 
        System.exit(0);
    }

}


//Det tråkiga här är att jag inte vet hur man ska köra för att testa med egen in-data?