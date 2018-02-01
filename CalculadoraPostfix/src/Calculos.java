
import static java.lang.Double.NaN;
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
        data=new ArrayList<String>();
        stack = new StackVector<Double>();
    }
    
    public double operar(String expresion){
        String[] nospace=expresion.split("\\s+");
        for(int i=0; i<nospace.length; i++){
        data.add(nospace[i]);
        }
        for(int j=0; j<nospace.length; j++)//recorre la expresion y agrega los numeros al stack hasta encontrarse un simbolo
        {
            if(data.get(j).equals("+"))//Realiza la suma de los elementos del stack si encuentra un +
            {
                
                double sumando=0;
                for(int k=0; k<stack.size(); k++)
                {
                 sumando += stack.peek();
                 stack.pop();
                }
                
                stack.push(sumando);
            }
            else if(data.get(j).equals("*"))//Realiza la multiplicacion de los elementos del stack si encuentra un *
            {
                double multiplicando=1;
                for(int k=0; k<stack.size(); k++)
                {
                    multiplicando=multiplicando*stack.peek();
                    stack.pop();
                    
                }
                stack.push(multiplicando);
            }
            else if(data.get(j).equals("-"))//Realiza la resta de los elementos del stack si encuentra un -
            {
                double restando=0;
                restando -= stack.peek();
                stack.pop();
                restando+= stack.peek();
                stack.pop();
                
                stack.push(restando);
            }
            else if(data.get(j).equals("/"))//Realiza la division de los elementos del stack si encuentra un *
            {
                if(stack.peek()==0)//si el denominador es 0, devuelve NaN
                    {
                        stack.pop();
                        stack.pop();
                        stack.push(NaN);
                        break;
                    }
                else{
                    //si el denominador no es 0, lo divide por el primer elemento del stack
                    
                        double denominador=stack.pop();
                        double numerador = stack.pop();
                        stack.push(numerador/denominador);
                    
                }
            }
            else //si el indice del array no retorna uno de los valores, agrega un numero al stack
                {
                stack.push(Double.parseDouble((String) data.get(j)));
                }
        }
        double respuesta=stack.peek();
        stack.empty();
        data.clear();
         return respuesta;   //devuelve la respuesta
    }
    
    

    
}
