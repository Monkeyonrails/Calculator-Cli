import java.util.*;

public class CalculatorCli{
   
   enum Operator{

      SUM('+'){

         @Override
       	 double makeCalc(double x, double y){

            return x + y;

	 }

      }, SUBTRACTION('-'){

         @Override
	 double makeCalc(double x, double y){

            return x - y;

	 }

      }, MULTIPLICATION('*'){

         @Override
	 double makeCalc(double x, double y){

            return x * y;

	 }

      }, DIVISION('/'){

         @Override
	 double makeCalc(double x, double y){

            return x / y;

	 }

      };
 
      final char operator;

      abstract double makeCalc(double x, double y);

      Operator(char operator){

         this.operator = operator;

      }

      String getOperator(){

         return String.valueOf(operator);

      }

   }

   public static void main(String[] args){

      List<String> elements = new LinkedList<>();
      double result = 0.0;

      for(int i = 0; i < args.length; i++){

         if(!args[i].isBlank()){

           elements.add(args[i]);
         		        
	}
      }

      for(int i = 0; i < elements.size(); i++){

         for(Operator x : Operator.values()){

            if(elements.get(i).equals(x.getOperator())){

               double argX = Double.parseDouble(elements.get(i-1));
	       double argY = Double.parseDouble(elements.get(i+1));
               result += x.makeCalc(argX, argY);

	    }
	 }
      }

      System.out.println(result);

   }
}
