import java.util.*;

public class CalculatorCli{
  //Enumera os operadores 
   enum Operator{

      SUM('+'){
         //define o corpo do makeCalc
         @Override
       	 double makeCalc(double x, double y){

            return x + y;

	 }

      }, SUBTRACTION('-'){
         //define o corpo do makeCalc
         @Override
	 double makeCalc(double x, double y){

            return x - y;

	 }

      }, MULTIPLICATION('?'){
         //define o corpo do makeCalc
         @Override
	 double makeCalc(double x, double y){

            return x * y;

	 }

      }, DIVISION('/'){
         //define o corpo do makeCalc
         @Override
	 double makeCalc(double x, double y){

            return x / y;

	 }

      };
 
      final char operator;
      
      //metodo sem corpo
      abstract double makeCalc(double x, double y);
      
      //Atribui a variavel a cada operador do enum
      Operator(char operator){

         this.operator = operator;

      }
      //Retorna o valor String do operador
      String getOperator(){

         return String.valueOf(operator);

      }

   }

   public static void main(String[] args){
      //Cria uma lista
      List<String> elements = new LinkedList<>();
      double result = 0.0;

      if(args.length(1)){

	for(Operator x : Operator.values()){
         //Percorre os valores da List elements
         for(int i = 0; i < elements.size(); i++){               //verifica se um argumento é operador
	 //e realiza o calculo
         if(args[0].charAt(i).equals(x.getOperator())){
                                                                       double argX = Double.parseDouble(args[0].charAt(i-1));                                                            double argY = Double.parseDouble(args[0].charAt(i+1));
               result += x.makeCalc(argX, argY);

            }
         }
      }      
         
      }

      //Salva os argumentos na lista
      for(int i = 0; i < args.length; i++){

           elements.add(args[i]);
         		        
      }

      //Percorre os valores do enum Operator   
      for(Operator x : Operator.values()){
         //Percorre os valores da List elements
	 for(int i = 0; i < elements.size(); i++){	
         //verifica se um elemento da lista é igual a um operador e realiza o calculo
         if(elements.get(i).equals(x.getOperator())){

               double argX = Double.parseDouble(elements.get(i-1));
	       double argY = Double.parseDouble(elements.get(i+1));
               result += x.makeCalc(argX, argY);

	    }
	 }
      }
      //Imprime o resultado
      System.out.println(result);

   }
}
