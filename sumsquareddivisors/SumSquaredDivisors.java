package sumsquareddivisors;
import java.util.*;

public class SumSquaredDivisors {
  public static String listSquared(long m, long n) {
    long sum;
    List<Long> divisors;
    List<Long> squaredDivisors;
    List<String> resultList = new ArrayList<String>();
    
    for(long i = m; i <= n; i++) {
      divisors = findDivisors(i);
      squaredDivisors = square(divisors);
      sum = sumList(squaredDivisors);
      //System.out.println("i= " + i + ", sum = " + sum);
      
      if( Math.sqrt(sum*1.0) == Math.floor(Math.sqrt(sum*1.0))) {
        //System.out.println("sqrt(" + sum + ") = " + Math.sqrt(sum*1.0));
        //System.out.println("[" + i + ", " + sum + "]");
        resultList.add(Arrays.toString(new long[]{i, sum}));
      }
    }
    
   System.out.println(Arrays.toString(resultList.toArray()));
   return Arrays.toString(resultList.toArray());
  }
  
  public static List<Long> findDivisors(long n) {
    List<Long> divisors = new ArrayList<Long>();
    
    long divisor = 1;
    while(divisor <= n) {
      if(n % divisor == 0) {
        //System.out.println("divisor = " + divisor);
        divisors.add(divisor);
      }
      divisor++;
    }

    return divisors;
  }
  
  public static List<Long> square(List<Long> ns) {
    List<Long> list = new ArrayList<Long>();
    ListIterator<Long> iterator = ns.listIterator();
    Long value;
    
    while(iterator.hasNext()) {
      value = (Long) iterator.next();
      list.add(value*value);
      //System.out.println(value + "->" + (value*value));
    }
    return list;
  }
  
  public static long sumList(List<Long> list) {
    ListIterator<Long> iterator = list.listIterator();
    long sum = 0;
    
    while(iterator.hasNext()) {
      sum += iterator.next();
    }
    
    return sum;
  }
}
