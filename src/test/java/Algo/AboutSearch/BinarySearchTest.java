package Algo.AboutSearch;

import junit.framework.TestCase;
import org.junit.Test;

public class BinarySearchTest extends TestCase {

    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    public void testSearchFirst() {
        int[] array = {1,2,3,4,4,5};
        int index = binarySearch.searchFirst(array, 1);
        System.out.println(index);
    }

    @Test
    public void testSearchLast(){
        int[] array = {1,2,3,4,4,4,5};
        int index = binarySearch.searchLast(array, 4);
        System.out.println(index);
    }
}