package sumofdivided;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SumOfDivided {
  public static String sumOfDivided(int[] l) {
    System.out.println("---------------------------------");
    System.out.println("sumOfDivided - l = " + Arrays.toString(l));
    
    //List<Integer> divisors = findAllPrimeFactors(l);
    HashMap<Integer, List<Integer>> allPrimefactors = findAllPrimeFactors(l);
    
    //1) trouver tous les facteurs premiers de tous les nombres
    allPrimefactors.get(-1).sort(Comparator.naturalOrder());
    System.out.println("sumOfDivided - listPrimeFactors = " + Arrays.toString(allPrimefactors.get(-1).toArray()));
    
    //2) pour chaque facteur premier, récolter tous les nombres qu'il divise + leur somme s'ils sont plus d'un
    String result = "";
    int p = -1;
    int sum = -1;
    for(int i = 0; i < allPrimefactors.get(-1).size(); i++) {
      p = allPrimefactors.get(-1).get(i);
      sum = 0;
      for(int j = 0; j < l.length; j++) {
        //System.out.println("list("+l[j]+") = " + Arrays.toString(allPrimefactors.get(l[j]).toArray()));
        if(allPrimefactors.get(l[j]).contains(p)) {
          sum += l[j];
        }
      }
      result += "(" + p + " " + sum + ")";
    }
    System.out.println("result = " + result);
    return result;
  }
  
  public static HashMap<Integer, List<Integer>> findAllPrimeFactors(int[] numbers) {
    HashMap<Integer, List<Integer>> list = new HashMap<Integer, List<Integer>>();
    List<Integer> listPrimeFactors = new ArrayList<Integer>();
    List<Integer> tmp;
    
    for(int i = 0; i < numbers.length; i++) {
      tmp = findPrimeFactors(numbers[i]);
      list.put(numbers[i], tmp);
      //System.out.println("findAllPrimeFactors - list["+ numbers[i] +"] = " + Arrays.toString(list.get(numbers[i]).toArray()));
      for(int j = 0; j < tmp.size(); j++) {
        if(!listPrimeFactors.contains(tmp.get(j))) {
          listPrimeFactors.add(tmp.get(j));
        }
      }
    }
    
    list.put(-1, listPrimeFactors);
    return list;
  }
  
  public static List<Integer> findPrimeFactors(int n) {
    List<Integer> list = new ArrayList<Integer>();
    int divisor = 2;
    n = Math.abs(n);
    
    while((divisor <= n)) {
      if((n % divisor == 0) && !containsMultiple(list, divisor)) {
        list.add(divisor);
        n /= divisor;
      }
      divisor++;
    }
    return list;
  }
  
  public static boolean containsMultiple(List<Integer> list, int n) {
    int i = 0;  
    while(i < list.size()) {
      if(n % list.get(i) == 0) return true;
      i++;
    }  
    return false;
  }
}
