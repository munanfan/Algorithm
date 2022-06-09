package Algo;

import MyException.IndexOutOfRangeException;

import java.util.Arrays;

/**
 * myHeap:堆，数组的形式
 * size:堆中的元素大小
 *
 */
public class HeapSort {
    private int[] myHeap;   // array of heap
    private int size;       // size of heap
    private int maxLength;  // maxLength of heap

    /**
     * 初始化堆，堆的大小实际为length+1，第一个元素空着不用
     * 这样对于每一个父元素，它的子元素下标分别为2*x、2*x+1
     * @param length 堆的大小
     */
    public HeapSort(int length) throws Exception {
        if(length <= 0){
            throw new Exception("堆大小需要大于等于0");
        }
        size = 0;
        maxLength = length;
        myHeap = new int[length+1];
    }

    public void insert(int element) throws IndexOutOfRangeException {
        if(size == maxLength){
            throw new IndexOutOfRangeException("出错：超出堆的最大范围");
        }
        myHeap[++size] = element;
        // 调整新加入的最后一个元素
        adjustBottom();
    }

    /**
     * 删除堆顶元素
     * 将堆的最后一个元素替换堆顶元素，然后从上到下调整
     */
    public void delete(){
        if(size == 0){
            throw new IndexOutOfBoundsException();
        }
        // 替换堆顶元素，然后大小-1
        myHeap[1] = myHeap[size--];
        adjustTop();
    }

    /**
     * 对堆顶元素进行调整
     */
    public void adjustTop(){
        int index = 1;          // 对顶元素坐标
        // 当还有孩子节点的时候继续遍历
        while(2*index <= size){
            // 记录最小的值得下标
            int minIndex = index;
            // 和左节点比较
            minIndex = myHeap[2*index]<myHeap[minIndex]?2*index:minIndex;
            // 和右节点比较
            minIndex = (2*index+1<=size && myHeap[2*index+1]<myHeap[minIndex])?2*index+1:minIndex;
            // 查看最小值所在的节点是否是孩子节点
            if(minIndex == index){
                // 最小的还是父节点
                break;
            }else{
                // 孩子节点比父节点小，进行交换
                int temp = myHeap[index];
                myHeap[index] = myHeap[minIndex];
                myHeap[minIndex] = temp;
                index = minIndex;
            }
        }
    }

    /**
     * 对最后一个元素进行调整
     */
    public void adjustBottom(){
        int index = size;
        while(index/2 > 0 && myHeap[index] < myHeap[index/2]){
            int temp = myHeap[index];
            myHeap[index] = myHeap[index/2];
            myHeap[index/2] = temp;
            index = index / 2;
        }
    }

    public int getTop(){
        if(size == 0){
            throw new IndexOutOfBoundsException();
        }
        return myHeap[1];
    }

    public void printHeap(){
        int i = 0;
        while(i < size){
            System.out.print(myHeap[i++] + "=>");
        }
        System.out.println(myHeap[size]);
    }

    public int[] sort(){
        int originSize = size;
        while(size != 0){
            int temp = getTop();
            myHeap[1] = myHeap[size];
            adjustTop();
            myHeap[size--] = temp;
        }
        return Arrays.copyOfRange(myHeap, 1, originSize+1);
    }
}
