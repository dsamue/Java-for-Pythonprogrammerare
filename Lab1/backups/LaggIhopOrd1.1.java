import java.util.Scanner;
import java.io.*;

public class LaggIhopOrd {

    public static void main(String[] args) {

    	Scanner data = null;
    	Integer antal;
    	String ord;
    	String sammansatt = "";

    	try{
	        data = new Scanner(new BufferedReader(new FileReader("ord.1.in")));
	    }

        catch ( IOException e) {
            System.out.println("Kan inte läsa fil");
            e.printStackTrace();
            System.exit(0);
        }

        antal = Integer.parseInt(data.next());


        while(data.hasNext()) {
            ord = data.next();
            sammansatt = sammansatt + ord;
            
        }

        System.out.println(sammansatt);     //Ok, funkar alltså fint att skriva ut från while-loopen men inte utanför den. Annars snyggt jobbat!

        //System.exit(0);
    }

}