/*
 * Principal.java
 * 30/01/2018
 * Andrea Arguello 17801
 */
import java.util.*;
import java.io.*;
import static java.lang.Double.NaN;

/**
 *
 * @author Andrea Arguello 17801
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        String expresion="";
        File datos = null;
        FileReader reader = null;
        BufferedReader buffer = null;
        try {
            datos = new File("C:\\Users\\cooli\\Desktop\\Programacion\\datos.txt");
            reader = new FileReader(datos);
            buffer = new BufferedReader(reader);
            calculadora postfixCalc = new Calculos();
            String expresionnn;
            while ((expresionnn = buffer.readLine()) != null) {
                expresion = expresion + expresionnn;
            }
            if (Double.isNaN(postfixCalc.operar(expresion))) {
                System.out.println("MATH ERROR");
            } else {
                System.out.println("Resultado: " + postfixCalc.operar(expresion));
            }
        } catch (Exception e) {
            if(expresion.equals(""))
            {
            System.out.println("No se pudo hallar el archivo 'datos.txt'");
            }
            else{
                System.out.println("El archivo 'datos.txt' contiene una letra o una expresion inoperable");
            }
            
        }

    }

}
