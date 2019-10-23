package com.interrator;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Code69 {
    public static void main(String[] ags) {
        int[] arr = getMaxSum(new int[]{1,2,3,4,5},new int[]{3,5,7,9,11},4);
        for (int a:arr
        ) {
            System.out.println(a);
        }
    }

    /**
     * 两个数组有序中各取出一个数相加,获取最大的K个数
     * 时间复杂度O(K*Log(K))
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static int[] getMaxSum(int[] a, int[] b, int k) {
        int[] res = new int[k];
        Heaps heap = new Heaps(k + 1, (o1,o2)->((HeapNode)(o1)).value-((HeapNode)(o2)).value);
        int i = a.length - 1;
        int j = b.length - 1;
        HeapNode h = new HeapNode(i, j, a[i] + b[j]);
        heap.insert(h);
        int index = 0;
        Set<String> set = new HashSet<String>();
        set.add(i+"_"+j);
        while (index < k) {

            h = heap.poll();
            res[index++] =h.value;
            i = h.i;
            j = h.j;
            if (i>0&&!set.contains((i-1)+"_"+j)){
                h = new HeapNode(i-1, j, a[i-1] + b[j]);
                heap.insert(h);
                set.add((i-1)+"_"+j);
            }
            if(j>0&&!set.contains(i+"_"+(j-1))){
                h = new HeapNode(i-1, j, a[i] + b[j-1]);
                heap.insert(h);
                set.add(i+"_"+(j-1));
            }

        }
        return res;
    }
}

class HeapNode {
    int i;
    int j;
    int value;

    public HeapNode(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }
}

class Heaps {

    HeapNode[] values;
    int size;
    Comparator comparator = null;

    public Heaps(int length, Comparator comparator) {
        values = new HeapNode[length];
        size = 0;
        this.comparator = comparator;
    }

    public void insert(HeapNode a) {
        values[size++] = a;
        heapify();
    }

    public HeapNode poll() {
        HeapNode heapNode = values[0];
        values[0]=null;
        swap(values, 0, --size);
        heapifyPoll();
        return heapNode;
    }

    private void heapifyPoll() {
        HeapNode res = values[0];
        int m = 0 * 2 + 1;
        int i = 0;
        while (m <= size - 1) {
            if (m + 1 <= size - 1 && comparator.compare(values[m + 1], res) > 0 &&
                    comparator.compare(values[m + 1], values[m]) > 0) {
                values[i] = values[m + 1];
                i = ++m;
                m = m * 2 + 1;
            } else if (comparator.compare(values[m], res) > 0) {
                values[i] = values[m];
                i = m;
                m = m * 2 + 1;
            }
        }
    }

    private void swap(HeapNode[] value, int i, int j) {
        HeapNode heapNode = value[i];
        value[i] = value[j];
        value[j] = heapNode;
    }

    private void heapify() {
        int n = size - 1;
        HeapNode res = values[n];
        while (n != 0) {
            if (comparator.compare(values[n], values[(n - 1) / 2]) > 0) {
                values[n] = values[(n - 1) / 2];
                n = (n - 1) / 2;
            } else {
                break;
            }
        }
        values[n] = res;
    }
}
