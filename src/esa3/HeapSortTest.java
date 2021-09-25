package esa3;


import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HeapSortTest {
	int[] arr = FileIntArray.FileToIntArray("src/Arrays/Rand10_1");
	int[] arr1 = FileIntArray.FileToIntArray("src/Arrays/Sort10_1");
	 private HeapSort heap;

	  @Before
	  public void initheap() {
	    heap = new HeapSort();
	  }
	
	 
	  @Test
	  public void testNotSame() {
	      final ByteArrayOutputStream out = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(out));
	      HeapSort.heapJunitTest(arr);
	      final String written = out.toString();
	      Assert.assertNotSame("Sortiertes Array: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ", written);
	  }
	  
	  @Test
	  public void testSame() {
	      final ByteArrayOutputStream out = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(out));
	      HeapSort.heapJunitTest(arr);
	      final String written = out.toString();
	      Assert.assertEquals("Sortiertes Array: 1, 2, 3, 5, 7, 7, 9, 11, 12, 16, ", written);
	  }
	  
	  
	  
	  @Test
	  public void testArray() {
	      Assert.assertNotEquals(arr1, heap.heap(arr));
	  }
	 
}
