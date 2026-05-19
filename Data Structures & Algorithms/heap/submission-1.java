class MinHeap {

    /**
                                                            3     (1 * 2 - 1, 1 * 2)
                                                        [1, ..]
                                4  (2 * 2 - 1, 2 * 2)                                   6 (3 * 2 - 1, 3 * 2)
                            [1, 2, ..]                                             [1, 2, 3, ..]
                    5                           8                          9                            10
            [1, 2, 3, 4, ..]           [1, 2, 3, 4, 5, ..]       [1, 2, 3, 4, 5, 6, ..]       [1, 2, 3, 4, 5, 6, 7]
    **/


    /**

    Find top k values

        "MinHeap" is going to work in O(log k):
            If and only if:
                1. Given that the logic is if element < 3, skip otherwise replace 3.
                    It will work in O(log k) if and only if:
                        2. The way you are using is such a way that the MinHeap's Array is size bound with size == k
                     Otherwise:
                        2. It will not give O(log k), it will give O(log n), and while it could would it wouldn't logically make sense.

        So THE USER NEEDS TO ENSURE THEY HAVE THE RIGHT LOGIC. Now that we ensured that the Usage will be as expected, we go:

    **/

    List<Integer> list = new ArrayList<>();

    public MinHeap() {
        list.add(69);
    }

    public void push(int val) {
        list.add(val);
        bubbleUp(list.size() - 1);
    }
    
    public void bubbleUp(int index) {
        if (index <= 1) return;
        int parentIndex = parentIndex(index);
        if (list.get(parentIndex) > list.get(index)) {
            swap(parentIndex, index);
            bubbleUp(parentIndex);
        }
    }

    public void swap(int indexA, int indexB) {
        int temp = list.get(indexA);
        list.set(indexA, list.get(indexB));
        list.set(indexB, temp);
    }

    public void bubbleDown(int index) {
        int leftChildIndex = leftChildIndex(index);
        if (leftChildIndex > list.size() - 1) return;
        int rightChildIndex = rightChildIndex(index) >= list.size() ? -1 : rightChildIndex(index);
        int childIndex = rightChildIndex == -1 ? leftChildIndex : ((list.get(leftChildIndex) > list.get(rightChildIndex)) ? rightChildIndex : leftChildIndex);
        if (list.get(index) > list.get(childIndex)) {
            swap(index, childIndex);
            bubbleDown(childIndex);
        }
    }

    public int leftChildIndex(int parentIndex) {
        return (parentIndex * 2);
    }

    public int rightChildIndex(int parentIndex) {
        return ((parentIndex * 2) + 1);
    }

    public int parentIndex(int childIndex) {
        return ((childIndex / 2));
    }

    public Integer pop() {
        int top = top();
        if (list.size() <= 1) return -1;
        if (list.size() == 1) {
            list.remove(list.size() - 1);
            return top;
        }
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        bubbleDown(1);
        return top;
    }

    public Integer top() {
        if (list.size() <= 1) return -1;
        return list.get(1);
    }

    public void heapify(List<Integer> nums) {
        for (Integer num : nums) {
            push(num);
        }
    }
}
