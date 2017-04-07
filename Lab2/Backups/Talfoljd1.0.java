import java.util.Scanner;
import java.io.*;

public class Talfoljd {

    public static void main(String[] args) {

        Scanner data = null;
        Integer start;
        Integer slut;
        Integer antalSteg;
    
        data = new Scanner(System.in);
        start = Integer.parseInt(data.next());  
        slut = Integer.parseInt(data.next());


        for(Integer i = start; i <= slut; i++ ) {
            System.out.println(i);      
        }

        System.exit(0);
    }

}