package Test;

import Algo.HeapSort;
import Utils.OutUtils;

import java.util.Random;

public class TestHeapSort {
    public static void main(String[] args) throws Exception {
        HeapSort heapSort = new HeapSort(100);
        Random random = new Random();
        System.out.println("正在创建堆...");
        for(int i=0; i<10; i++){
            heapSort.insert(random.nextInt(100));
        }
        System.out.println("堆创建完毕，堆中的元素如下：");
        heapSort.printHeap();
        //System.out.println("正在往堆中添加元素...");
        //for (int i=0; i<5; i++){
        //    int randomInt = random.nextInt(100);
        //    System.out.println("新插入的元素为:"+randomInt);
        //    heapSort.insert(randomInt);
        //    System.out.println("插入后堆为：");
        //    heapSort.printHeap();
        //}
        //OutUtils.printIntArray(heapSort.sort());
        System.out.println("正在往堆中删除元素...");
        for (int i=0; i<5; i++){
            System.out.println("即将删除的元素为:"+ heapSort.getTop());
            heapSort.delete();
            System.out.println("删除元素后堆为：");
            heapSort.printHeap();
        }
        OutUtils.printIntArray(heapSort.sort());
    }
}
