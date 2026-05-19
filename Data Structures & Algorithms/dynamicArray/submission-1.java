/**



*/

class DynamicArray {

    int capacity = 0;
    int pointer = -1;
    int[] array;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (pointer + 1 == capacity) {
            resize();
        }
        array[++pointer] = n;
    }

    public int popback() {
        int ans = array[pointer];
        array[pointer] = 0;
        pointer--;
        return ans;
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];
        for (int i = 0; i < pointer + 1; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    public int getSize() {
        return pointer + 1;
    }

    public int getCapacity() {
        return capacity;
    }
}
