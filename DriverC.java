public class DriverC {
  public static void main(String[] args) {
    System.out.println(Calculator.eval("10 2.0 +")); //is 12.0 CORRECT
    System.out.println();
    System.out.println(Calculator.eval("11 3 - 4 + 2.5 *")); //is 30.0 CORRECT
    System.out.println();
    System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -")); //is 893.0 CORRECT
    System.out.println();
    System.out.println(Calculator.eval("1 2 3 4 5 + * - -")); //is 26.0 CORRECT
    System.out.println();
  }
}
