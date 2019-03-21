public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[]) new Object[initialCapacity];
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
      for (int i = start; i < data.length; i++) {
        out += data[i] + ", ";
      }
      for (int j = 0; j < e; j++) {
        if (j != e -1)  out += data[j] + ", ";
        else out += data[j];
      }
    }
    else {
      for (int i = start; i < e; i++) {
        if (i != e -1) out += data[j] + ", ";
        else out += data[j];
      }
    }
    out += "]";
    return out;



      public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}
