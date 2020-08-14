package loop;

import java.util.*;

public class LoopInspector {

  public int loopSize(Node node) {
    List<Node> list = new ArrayList<Node>();
    int totalSize = 0;
    int loopSize = 0;
    boolean end = false;
    Node loopStartNode = null;
    
    while(!end) {
      if(!list.contains(node)){
        list.add(node);
        node = node.getNext();
        totalSize++;
      }
      else {
        loopStartNode = node;
        end = true;
      }
    }
    
    return totalSize - list.indexOf(loopStartNode);
  }
}
