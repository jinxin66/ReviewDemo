package Algorithm;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import javafx.beans.binding.When;
import javafx.scene.chart.BubbleChart;

import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

//排序
public class Sorting {
    final static int inter[] = {7,8,9,15,10,11,12,16,17,18,19,1,0,2,13,3,14,4,5,6};

    public static void main(String [] args){
        System.out.println("n^2");
        for(int a:Bubble())
            System.out.print(a+ " ");

        for (int a:Selection())
            System.out.print(a+ " ");

        for (int a:Insertion())
            System.out.print(a+ " ");

        System.out.println("\n n^1.5");
        for (int a:Shell())
            System.out.print(a+ " ");

        System.out.println("\n nlogn");
        for (int a:Merge(Arrays.copyOf(inter, inter.length)))
            System.out.print(a+ " ");

        for (int a:Quck(Arrays.copyOf(inter, inter.length), 0, Arrays.copyOf(inter, inter.length).length-1))
            System.out.print(a+ " ");

        for (int a:Heap())
            System.out.print(a+ " ");

    }

    //Bubble Sort冒泡排序
    public static int[] Bubble(){
        int list[] = Arrays.copyOf(inter, inter.length);
        for (int i=0; i<list.length; i++){
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j=i+1; j<list.length; j++){
                if (list[i] > list[j]){
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
        return list;
    }

    //Selection Sort选择排序
    public static int[] Selection(){
        int list[] = Arrays.copyOf(inter, inter.length);
        for (int i=0; i<list.length; i++){
            int minIndex = i;
            for (int j=i+1; j<list.length; j++){
                if (list[minIndex] > list[j])
                    minIndex = j;
            }
            if (minIndex != i){
                int tenp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = tenp;
            }
        }
        return list;
    }

    //Insertion Sort插入排序
    public static int[] Insertion(){
        int list[] = Arrays.copyOf(inter, inter.length);
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i=1; i<list.length; i++){
            int temp = list[i];
            int j=i;
            while (j>0 && temp < list[j-1]){
                list[j] = list[j-1];
                j--;
            }
            if (j!=i)
                list[j] = temp;;
        }
        return list;
    }

    //Shell Sort希尔排序
    public static int[] Shell(){
        int list[] = Arrays.copyOf(inter, inter.length);
        int gap = list.length;
        while (gap > 1) {
            gap /= 2;
            for (int i = gap; i < list.length; i=i+gap) {
                int temp = list[i];
                int j = i;
                while (j >0 && temp < list[j-gap]) {
                    list[j] = list[j-gap];
                    j -= gap;
                }
                if (j!=i)
                    list[j] = temp;;
            }
        }
        return list;
    }

    //Merge Sort归并排序
    public static int[] Merge(int[] arr){
        if (arr.length < 2) {
            return arr;
        }
        int middle = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(Merge(left), Merge(right));
    }
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    //Quck Sort快速排序
    public static int[] Quck(int[] arr, int left, int right) {
        if (left < right){
            int index = quck(arr, left, right);
            Quck(arr, left, index-1);
            Quck(arr, index+1,right);
        }
        return arr;
    }
    private static int quck(int[] arr, int left, int right) {
        int index  = left;
        int lef2right = index+1;
        for (int i=lef2right; i<arr.length; i++){
            if (arr[i] < arr[index]){
                int temp = arr[lef2right];
                arr[lef2right] = arr[i];
                arr[i] = temp;
                lef2right++;
            }
        }
        int temp = arr[index];
        arr[index] = arr[lef2right-1];
        arr[lef2right-1] = temp;

        return lef2right-1;
    }

    //Heap Sort堆排序
    public static int[] Heap(){
        int list[] = Arrays.copyOf(inter, inter.length);

        int len = list.length;
        buildMaxHeap(list, len);

        for (int i = len - 1; i > 0; i--) {
            swap(list, 0, i);
            len--;
            heapify(list, 0, len);
        }
        return list;
    }
    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Counting Sort计数排序
    public static void Counting(){

    }

    //Bucket Sort桶排序
    public static void Bucket(){

    }

    //Radix Sort基数排序
    public static void Radix(){

    }
}
