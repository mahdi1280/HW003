public class MyList {

    private Integer[] integers;
    private int index=0;

    public MyList(int len) {
        this.integers = new Integer[len];
    }

    public MyList() {
        this.integers = new Integer[10];
    }

    public void add(int value){
        integers[index++] = value;
    }

    public void add(int index,int value){
        for(int i = this.index+2; i>=index ;i--){
            integers[i]=integers[i-1];
        }
        integers[index]=value;
        this.index++;
    }

    public void  addAll(int[] values){
        for (int i = 0; i < values.length; i++) {
            add(values[i]);
        }
    }

    public void  addAll(int index,int[] values){
        for (int i = index; i < values.length+index; i++) {
            add(i,values[i]);
        }
    }
    
    public Integer get(int index){
       return integers[index];
    }

    public void remove(int index){
        this.integers[index] = null;
        shiftArray(index);
    }

    private void shiftArray(int index) {
        for(int i = index+1;i< this.index;i++){
            this.integers[i-1] = this.integers[i];
        }
    }

    public void clear(){
        integers=new Integer[10];
    }

    public boolean contains(int value){
        for (int a: integers) {
            if(a== value)
                return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return integers[0] == null;
    }

    public int size(){
        return index;
    }
}
