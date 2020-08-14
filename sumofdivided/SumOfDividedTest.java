package sumofdivided;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfDividedTest {

  @Test
  public void testOne() {
      int[] lst = new int[] {12, 15};
      assertEquals("(2 12)(3 27)(5 15)", SumOfDivided.sumOfDivided(lst));
  }

  /*
   * @Test public void test300() { int[] lst = new int[] {300};
   * assertEquals("(2 12)(3 27)(5 15)", SumOfDivided.sumOfDivided(lst)); }
   */

  
    @Test public void test1() { int[] lst = new int[] {458, -91, 70, 1, -31, 429, 122, 66, 430, 249, 335, 433, -86};
    assertEquals("(2 1060)(3 744)(5 835)(7 -21)(11 495)(13 338)(31 -31)(43 344)(61 122)(67 335)(83 249)(229 458)(433 433)", SumOfDivided.sumOfDivided(lst)); }
   
}
