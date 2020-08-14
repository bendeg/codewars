package brainluck;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class BrainLuck {
  private char[] data = new char[30000];
  private char[] code;
  private int dataPointer = 15000;
  private int instructionPointer = 0;
  private int inputPointer = 0;
  private char[] input;
  private String output = "";
  private HashMap<Integer, Integer> brackets = new HashMap<Integer, Integer>();
  
  public BrainLuck(String code) {
    this.code = new char[code.length()];
    code.getChars(0, code.length(), this.code, 0);
    System.out.println("CODE = " + code);
    brackets = findAllMatchingBrackets(code);
  }

  private HashMap<Integer, Integer> findAllMatchingBrackets(String code) {
    Stack<Integer> stack = new Stack<Integer>();
    int tmp;
    
    int index = 0;
    while(index < code.length()) {
      switch(code.charAt(index)) {
      case '[':
        stack.push(index);
        break;
      case ']':
        tmp = stack.pop();
        brackets.put(tmp, index);
        brackets.put(index, tmp);
        break;
      default:
      }
      index++;
    }
    return brackets;
  }

  public String process(String input) {
    this.input = new char[input.length()];
    input.getChars(0, input.length(), this.input, 0);
    System.out.println("INPUT = " + Arrays.toString(this.input));
    
    boolean end = false;
    char c;
    while(!end) {
      switch(this.code[this.instructionPointer]) {
        case '>' :         
          this.dataPointer++;  
          System.out.println("increment DATA pointer (pointer = " + this.dataPointer + ")");
          break;
        case '<' :
          this.dataPointer--;  
          System.out.println("decrement DATA pointer (pointer = " + this.dataPointer + ")");
          break;
        case '+' :
          if(this.data[this.dataPointer] == 255) {
            this.data[this.dataPointer] = 0;
          }
          else {
            this.data[this.dataPointer]++;
          }
          System.out.println("increment DATA (data = " + (byte)this.data[this.dataPointer] + ")");
          break;
        case '-' :
          if(this.data[this.dataPointer] == 0) {
            this.data[this.dataPointer] = 255;
          }
          else {
            this.data[this.dataPointer]--;
          }
          System.out.println("decrement DATA (data = " + (byte)this.data[this.dataPointer] + ")");
          break;
        case '.' : 
          this.output += this.data[this.dataPointer];
          System.out.println("output byte : " + this.data[this.dataPointer]);
          break;
        case ',' : 
          System.out.println("accept byte from INPUT : " + (byte)this.input[this.inputPointer]);
          this.data[this.dataPointer] = this.input[this.inputPointer];
          this.inputPointer++;
          break;
        case '[' : 
          System.out.println("next command OR jump forward (data = " + (byte)this.data[this.dataPointer] + ")");
          if(this.data[this.dataPointer] == 0) {
            this.instructionPointer = this.brackets.get(this.instructionPointer);
          }
          break;
        case ']' : 
          System.out.println("next command OR jump back");
          if(this.data[this.dataPointer] != 0) {
            this.instructionPointer = this.brackets.get(this.instructionPointer);
          }
      }
      this.instructionPointer++;
 
      if(this.instructionPointer == this.code.length) end = true;
    }
    System.out.println(this.output);
    return this.output;
  }
}