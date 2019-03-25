public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] tokens = s.split(" ");
      MyDeque<Double> st = new MyDeque<Double>();
      for (int i = 2; i < tokens.length; i++) {
        //System.out.println(tokens[i]);
        //if the token is an operator
        if (tokens[i].equals("*") ||
            tokens[i].equals("/") ||
            tokens[i].equals("-") ||
            tokens[i].equals("+") ||
            tokens[i].equals("%")   ) {
                st.addLast(Double.parseDouble(tokens[i-2]));
                st.addLast(Double.parseDouble(tokens[i-1]));
                double ans = 0.0;
                if (tokens[i].equals("*")) ans = st.removeFirst() * st.removeFirst();
                if (tokens[i].equals("-")) ans = st.removeFirst() - st.removeFirst();
                if (tokens[i].equals("+")) ans = st.removeFirst() + st.removeFirst();
                if (tokens[i].equals("/")) ans = st.removeFirst() / st.removeFirst();
                if (tokens[i].equals("%")) ans = st.removeFirst() % st.removeFirst();
                System.out.println(st);
                st.addLast(ans);
                System.out.println(st);
                i++;
              }
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
