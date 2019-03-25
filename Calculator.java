public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    //returns if the token is an operator (true) or a value (false)
    private static boolean isOp(String token) {
      return (token.equals("+") ||
          token.equals("-") ||
          token.equals("*") ||
          token.equals("/") ||
          token.equals("%"));
          //now much simpler and not looping through an array of the ops... n time
    }
    // based on the operator token, perform the operation on two given doubles
    private static double operate(double a, double b, String op) {
      if (op.equals("+")) return b + a;
      else if (op.equals("-")) return b - a;
      else if (op.equals("*")) return b * a;
      else if (op.equals("/")) return b / a;
      else return b % a;
    }

    public static double eval(String s){
      String[] tokens = s.split(" ");
      MyDeque<Double> stack = new MyDeque<Double>();
      for (int i = 0; i < tokens.length; i++) {
        //if the token is a value
        if (!isOp(tokens[i])) {
          //for the cases where we have multiple values before operations to add to the stack and whittle down
          stack.addLast(Double.parseDouble(tokens[i]));
        }
        else { //when the token is an operator
          double ans = operate(stack.removeLast(), stack.removeLast(), tokens[i]);
          stack.addLast(ans); //removes the last two stacks and adds their result as a new stack
        }
      }
      //eventually you will have one stack left: the answer
      return stack.removeFirst();
    }
}
