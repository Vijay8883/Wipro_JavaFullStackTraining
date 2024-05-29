package DAY13Assignments;


/*Day 13
Task 3:
Below is a simple implementation of a Min-Heap in Java, which includes methods for insertion, deletion, and fetching the minimum element:*/

public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) { return pos / 2; }
    private int leftChild(int pos) { return (2 * pos); }
    private int rightChild(int pos) { return (2 * pos) + 1; }
    private boolean isLeaf(int pos) { return pos > (size / 2) && pos <= size; }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i]
                             + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int remove() {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        minHeapify(1);
        return popped;
    }

    public int getMin() {
        return Heap[1];
    }
}


/*
 * This code defines a MinHeap class with an array to store the heap elements.
 * The insert method adds a new element to the heap and ensures the heap
 * property is maintained by comparing the added element with its parent and
 * swapping if necessary. The remove method removes and returns the minimum
 * element (root of the heap) and then restructures the heap using the
 * minHeapify method to maintain the heap property. The getMin method simply
 * returns the element at the root of the heap, which is the minimum element.
 */