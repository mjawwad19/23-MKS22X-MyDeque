import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  //allocates the default space (10) for a deque
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 0;
    end = 0;
    size = 0;
  }
  //allocates space for a deque of specified size
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[]) new Object[initialCapacity];
    start = 0;
    end = 0;
    size = 0;
  }
  //returns how many elements in deque
  public int size(){
    return size;
  }
  //allows us to see the deque
  public String toString(){
    String out = "{";
    if (size == 0) return "{}";
    if (start < end) {
      for (int i = start; i < end; i++) {
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
  //allocates more space for the deque when it is full
  @SuppressWarnings("unchecked")
  private void resize() {
    E[] n = (E[]) new Object[(data.length-1) * 2];
    int in = -1;
    if (start < end) {
      for (int i = start; i < end; i++) {
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
  //adds to the start of the deque
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
  //adds to the end of the deque
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
  //removes the start element of the deque and returns it
  public E removeFirst(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    E removed = data[start++];
    if (start == data.length) start = 0;
    size--;
    return removed;
  }
  //removes the last element of the deque and returns it;
  public E removeLast(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    E removed = data[--end];
    if (end == 0) end = data.length;
    size--;
    return removed;
  }
  //peeks the start of the deque
  public E getFirst(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    return data[start];
  }
  //peeks the end of the deque
  public E getLast(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    return data[end -1];
  }

  public static void main(String[] args) {
    MyDeque<Integer> mD = new MyDeque<Integer>();
    for (int i = 0; i < 20; i++) {
      mD.addFirst(i);
      System.out.println(mD);
    }
    for (int i = 0; i < 20; i++) {
      mD.removeFirst();
      System.out.println(mD);
    }
  }
}
