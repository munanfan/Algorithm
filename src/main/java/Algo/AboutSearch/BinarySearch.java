package Algo.AboutSearch;

/**
 * 普通版本二分查找
 * 如果找到了目标值，返回目标值在数组的下标；
 * 如果没有找到，返回-1。
 */
public class BinarySearch {
    // 返回目标值的下标
    public int search(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    // 返回第一个目标值
    public int searchFirst(int[] array, int target){
        int start = 0;
        int end = array.length-1;
        // 当此处不能start=end，当start=end时，
        while(start < end){
            int mid = start + (end - start) / 2;
            // 关键：当当前值大于等于目标值
            if(array[mid] >= target){
                // 如果大于等于就移动到mid，保证end不会越过目标值
                end = mid;
            }else{
                // 如果小于，start就移动，保证start不会超过第一个符合要求的
                start = mid + 1;
            }
        }
        return start;
    }

    // 返回相同值得最后一个
    public int searchLast(int[] array, int target){
        int start = 0;
        int end = array.length-1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(array[mid] < target){
                start = mid + 1;
            }else{
                // 当前值大于等于target
                end = mid;
            }
        }
        return start;
    }
}
