public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] tokens = s.split(" ");
      for (int i = 0; i < tokens.length; i++) {
        System.out.println(tokens[i]);
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
