/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
import static java.lang.Double.NaN;

/**
 *
 * @author cooli
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
            datos = new File("datos.txt");
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
