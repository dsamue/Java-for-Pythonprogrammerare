import java.util.Scanner;
import java.io.*;

public class Talfoljd {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner data = null;
        Integer start;
        Integer slut;
        Integer antalSteg;

        //File testData = new File("samples/sequence.2.in");
        
        //OBS byt till System.in vid inlämning
        data = new Scanner(System.in);              
        start = Integer.parseInt(data.next());  
        slut = Integer.parseInt(data.next());


        for(Integer i = start; i <= slut; i++ ) { 

            Integer j = 0;
            Integer k = i;

            while (k!=1 && k!=0){   //Vet inte om det var nödvändigt att hantera nollan men gick igenom iaf.

                //Om talet är jämt:
                if (k%2 == 0){
                    k = k/2;
                    j = j+1;
                }

                //Om talet är ojämnt:
                else{
                    k = k*3+1;
                    j = j+1;
                }      
            }
            System.out.println(j);      
        }
        System.exit(0);
    }
}