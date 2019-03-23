import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 0;
    end = 0;
    size = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[]) new Object[initialCapacity];
    start = 0;
    end = 0;
    size = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String out = "{";
    if (size == 0) return "{}";
    if (start < end) {
      for (int i = start; i <= end; i++) {
        out += data[i] + " ";
      }
    }
    else {
      for (int i = start; i < data.length; i++) {
          out += data[i] + " ";
      }
      for (int i = 0; i < end; i++) {
          out += data[i] + " "; //to get the left free space being filled by remainder to end
      }
    }
    out += "}";
    return out;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] n = (E[]) new Object[(data.length-1) * 2];
    int in = -1;
    if (start < end) {
      for (int i = start; i <= end; i++) {
        n[++in] = data[i]; //copy over
      }
    }
    else {
      for (int i = start; i < data.length; i++) {
          n[++in] = data[i];
      }
      for (int i = 0; i < end; i++) {
          n[++in] = data[i];
          //other method of copying over when end is not after start
      }
    }
    data = n;
    start = 0;
    end = in + 1;
  }


  //basically same as addLast but start vs end
  public void addFirst(E element){
    if (element == null) throw new NullPointerException("deque does not permit null elements");
    if (size == data.length) resize();
    if (size == 0) {
      if (end == data.length) end =1;
      else end += 1;
    }
    else if (start == 0) {
      start = data.length -1;
    }
    else start--;
  data[start] = element;
  size++;
}
  public void addLast(E element){
    if (element == null) throw new NullPointerException("deque does not permit null elements");
    if (size == data.length) resize();
    if (end == data.length) {
      data[0] = element;
      end = 1;
    }
    else {
      data[end] = element;
      end++;
    }
    size++;
  }
  public E removeFirst(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    E removed = data[start];
    if (start == data.length -1 && size != 1) {
      start = 0;
    }
    else if (size != 1) {
      start++;
    }
    size--;
    return removed;
  }
  public E removeLast(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    E removed = data[end];
    if (end == 0 && size != 1) end = data.length -1;
    else if (size != 1) {
      end--;
    }
    size--;
    return removed;
  }
  public E getFirst(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    return data[start];
  }
  public E getLast(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    return data[end];
  }


  public static void main(String[] args) {
    /*MyDeque<Integer> s = new MyDeque<Integer>();
    s.addLast(5);
    s.addLast(12);
    s.addLast(2);
    s.addLast(3);
    s.addLast(6);
    s.addLast(7);
    s.addLast(8);
    s.addLast(9);
    System.out.println(s.end); //7
    System.out.println(s);
    s.addFirst(40);
    System.out.println("Size : " + s.size()); //9
    System.out.println(s.start); //9
    System.out.println(s); //[40, 5, 12, 2, 3, 6, 7, 8, 9];
    System.out.println(s.getFirst()); //40
    System.out.println(s.removeFirst()); //40;
    System.out.println(s); //[5,12,2,3,6,7,8,9];
    System.out.println("Size : " +  s.size); //8
    System.out.println(s.removeLast()); //9
    System.out.println(s); //[5,12,2,3,6,7,8]
    s.removeLast();
    System.out.println(s); //[5,12,2,3,6,7]
    s.removeLast();
    System.out.println(s); //[5,12,2,3,6]
    s.removeLast();
    System.out.println(s); //[5,12,2,3]
    s.removeLast();
    System.out.println(s); //[5,12,2]
    s.removeLast();
    System.out.println(s); //[5,12]
    s.removeLast();
    System.out.println(s); //[5]
    System.out.println("Size : " +  s.size); //1
    s.removeFirst();
    System.out.println(s); //[]
    System.out.println(s.removeFirst()); //should through the error NoSuchElementException*/
    MyDeque<Integer> mD = new MyDeque<Integer>();
    /*mD.addFirst(0);
    System.out.println(mD);
    mD.removeFirst();
    System.out.println(mD);*/
    for (int i = 0; i < 20; i++) {
      mD.addFirst(i);
      System.out.println(mD);
    }




  }
}
