public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 5;
    end = 5;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[]) new Object[initialCapacity];
    start = initialCapacity / 2;
    end = initialCapacity /2;
  }

  public int size(){
    int s;
    if (end < start) {
      s = (data.length - start) + (end);
    }
    else s = end - start;
    return s;
  }

  public String toString(){
    String out = "[";
    if (end < start) {
      for (int i = start +1; i < data.length; i++) {
        out += data[i] + ", ";
      }
      for (int j = 0; j < end +1; j++) {
        if (j != end)  out += data[j] + ", ";
        else out += data[j];
      }
    }
    else {
      for (int i = start +1; i < end + 1; i++) {
        if (i != end) out += data[i] + ", ";
        else out += data[i];
      }
    }
    out += "]";
    return out;
  }



  public void addFirst(E element){}
  public void addLast(E element){
    if (end != data.length -1) {
      data[end +1] = element;
      end++;
    }
    else {
      end = 0;
      data[end] = element;
    }
  }
  /*public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }*/


  public static void main(String[] args) {
    MyDeque<Integer> s = new MyDeque();
    s.addLast(5);
    s.addLast(12);
    System.out.println(s.start); //still 5
    System.out.println(s.end); //now 7
    System.out.println(s); //[5,12]
    s.addLast(2);//end is 8
    s.addLast(2); //end is 9
    s.addLast(6); //end is 0
    s.addLast(2); //end is 1
    s.addLast(2); //end is 2
    s.addLast(2); //end is 3;
    System.out.println(s.end);
    System.out.println(s);

  }
}
