class DynMain{
    public static void main(String[] args) {
        DynamicArray dynArr = new DynamicArray(5);
        dynArr.add(5);
        dynArr.add(3);
        dynArr.add(8);
        dynArr.add(10);
        dynArr.insertAtIndex(1,100);
        dynArr.add(11);
        System.out.println("size: "+dynArr.size);
        System.out.println("capacity: " +dynArr.capacity);


        System.out.println(dynArr);
        System.out.println("element found at index:" +dynArr.search(3));
    }
}
public class DynamicArray {

    int size;
    int capacity = 10;
    Object[] array;
    public DynamicArray(){

        this.array = new Object[capacity];
    }

    public DynamicArray(int capacity){
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public Object get(int index){

        return array[index];
    }

    public void add(Object data){
        if(size >= capacity){
            grow();
        }
        array[size++] = data;

    }

    public void insertAtIndex(int index, Object data){
        if(size >= capacity){
            grow();
        }
        for (int i = size; i>index; i--) {
            array[i] = array[i-1];
        }
        array[index] = data;
        size++;
    }

    public void grow(){
        int newCapacity = capacity*2;
        Object[] newArray = new Object[newCapacity];

        for(int i = 0; i<size; i++){
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public int search(Object data){
        for (int i = 0; i <size; i++) {
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        String s = "[";
        for (int i =0; i<size; i++){
            s= s + array[i] ;
             if(i<size-1){
                s +=  ",";
             }
        }
         s += "]";
        return s;
    }

}
