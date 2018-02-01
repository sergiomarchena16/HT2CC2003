
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
        System.out.println(data);
        for(int j=0; j<data.size(); j++)//recorre la expresion y agrega los numeros al stack hasta encontrarse un simbolo
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
                System.out.println(multiplicando);
            }
            else if(data.get(j).equals("-"))//Realiza la resta de los elementos del stack si encuentra un *
            {
                double restando=0;
                for(int k=0; k<stack.size(); k++)
                {
                 restando -= stack.peek();
                 stack.pop();   
                }
                stack.push(restando);
            }
            else if(data.get(j).equals("/"))//Realiza la division de los elementos del stack si encuentra un *
            {
                double dividiendo=1;
                for(int k=0; k<stack.size(); k++)
                {
                    if(stack.peek()==0)//si el denominador es 0, devuelve NaN
                    {
                        stack.pop();
                        stack.pop();
                        stack.push(NaN);
                    }
                    else//si el denominador no es 0, lo divide en el uno
                    {
                        dividiendo=dividiendo/stack.peek();
                        stack.pop();
                        dividiendo=dividiendo*stack.peek();
                        stack.pop();
                        System.out.println(dividiendo);
                        return dividiendo;
                        
                    }
                }
                stack.push(dividiendo);
            }
            else //si el indice del array no retorna uno de los valores, agrega un numero al stack
                {
                System.out.println(data.get(j) + "esta en else");
                stack.push(Double.parseDouble((String) data.get(j)));
                System.out.println(stack.peek() + "ultimo en stack");
                }
        }
        double respuesta=stack.peek();
        stack.empty();
        data.clear();
        System.out.println(respuesta);
         return respuesta;   //devuelve la respuesta
    }
    
    

    
}
