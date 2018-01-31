
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
        data=new ArrayList<>();
        stack = new StackVector<Double>();
    }
    
    public double operar(String expresion){
        for(int i = 0; i<expresion.length(); i++){
            data.add(expresion.charAt(i));
        }
        for(int j=0; j<expresion.length(); j++)//recorre la expresion y agrega los numeros al stack hasta encontrarse un simbolo
        {
            if(data.get(j)=="+")//Realiza la suma de los elementos del stack si encuentra un +
            {
                double sumando=0;
                for(int k=0; k<stack.size(); k++)
                {
                 sumando += stack.peek();
                 stack.pop();   
                }
                stack.push(sumando);
            }
            if(data.get(j)=="*")//Realiza la multiplicacion de los elementos del stack si encuentra un *
            {
                double multiplicando=1;
                for(int k=0; k<stack.size(); k++)
                {
                    multiplicando=multiplicando*stack.peek();
                    stack.pop();
                }
                stack.push(multiplicando);
            }
            if(data.get(j)=="-")//Realiza la resta de los elementos del stack si encuentra un *
            {
                double restando=0;
                for(int k=0; k<stack.size(); k++)
                {
                 restando -= stack.peek();
                 stack.pop();   
                }
                stack.push(restando);
            }
            if(data.get(j)=="/")//Realiza la division de los elementos del stack si encuentra un *
            {
                double dividiendo=1;
                for(int k=0; k<stack.size(); k++)
                {
                    if(k==0 && stack.peek()==0)//si el denominador es 0, devuelve NaN
                    {
                        stack.pop();
                        stack.pop();
                        stack.push(NaN);
                    }
                    else if(k==0 && stack.peek()!=0)//si el denominador no es 0, lo divide en el uno
                    {
                        dividiendo=dividiendo/stack.peek();
                        stack.pop();
                    }
                    else if(k==1)//multiplica el siguiente numero por la division anterior (1/dividendo)
                    {
                        dividiendo=dividiendo*stack.peek();
                        stack.pop();
                    }
                }
                stack.push(dividiendo);
            }
            else //si el indice del array no retorna uno de los valores, agrega un numero al stack
                {
                stack.push((double)data.get(j));
                }
        }
        
         return stack.peek();   
    }
    
    

    
}
