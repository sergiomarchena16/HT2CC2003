
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cooli
 */
public class Calculos implements calculadora{
    
    protected ArrayList data;
    StackVector<Double> stack;
    
    public Calculos()
    {
        data=new ArrayList<>();
        stack = new StackVector<Double>();
    }
    
    public double operar(String expresion){
        for(int i = 0; i<expresion.length(); i++){
            data.add(expresion.charAt(i));
        }
            
    }
    
    

    
}
