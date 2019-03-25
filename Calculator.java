public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    private static String[] ops = {"+", "-", "*", "/", "%"};

    private static boolean isOp(String token) {
      for (int i = 0; i < ops.length; i++) {
        if (token.equals(ops[i])) return true;
      }
      return false;
    }

    private static double operate(double a, double b, String op) {
      if (op.equals("+")) return a + b;
      else if (op.equals("-")) return a - b;
      else if (op.equals("*")) return a * b;
      else if (op.equals("/")) return a / b;
      else return a % b;
    }

    public static double eval(String s){
      String[] tokens = s.split(" ");
      MyDeque<Double> stack = new MyDeque<Double>();
      for (int i = 0; i < tokens.length; i++) {
        //System.out.println(tokens[i]);
        //if the token is an operator
        if (!isOp(tokens[i]) {
          stack.addLast(Double.parseDouble(tokens[i]))
        }
        else {
          operate
        }
      return 0.0;
    }


    public static void main(String[] args) {
      eval("10 2.0 +"); //is 12.0
      eval("11 3 - 4 + 2.5 *"); //is 30.0
      eval("8 2 + 99 9 - * 2 + 9 -"); //is 893.0
      eval("1 2 3 4 5 + * - -"); //is 26.0
    }
}
