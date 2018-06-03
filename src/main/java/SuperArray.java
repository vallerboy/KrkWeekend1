public class SuperArray<T> {
    private Object[] data;
    private int counter;

    public SuperArray(int size){
        data = new Object[size];
        //data = (T[]) data;
    }

    public void add(T something){
        if(counter >= data.length){
            throw new ArrayIndexOutOfBoundsException();
        }

        data[counter++] = something;
    }


    public T get(int index){
        return (T) data[index];
    }

    public void remove(int index){
        System.arraycopy(data, index + 1, data, index, counter - index);
        counter--;
    }
}
