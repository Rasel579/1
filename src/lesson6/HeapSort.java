package lesson6;


public class HeapSort {
    private    int heapSize;
    public void sort(int[] a){
        buildHeap(a);
        while (heapSize > 1){
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }

    private void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = heapSize/2; i >= 0; i--) {
            heapify(a,i);
        }
    }

    private void heapify(int[] a, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l < heapSize && a[i] < a[l]){
            largest = l;
        }
        if(r < heapSize && a[largest] < a[r]){
            largest = r;
        }
        if(i != largest){
            swap(a, i , largest);
            heapify(a, largest);
        }
    }

    private void swap(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }

    private int left(int i) {
        return 2*i + 1;
    }

    private int right(int i) {
        return  2*i + 2;
    }
}
