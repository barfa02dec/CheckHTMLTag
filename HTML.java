import java.util.*;
//Link   https://www.hackerrank.com/challenges/tag-content-extractor/problem
public class Solution{

	public static void main(String[] args){
		
		try(Scanner sc = new Scanner(System.in)){
		int front = 0;
        int rear = 0;
        int counter = 0;
        
        int testCases = Integer.parseInt(sc.nextLine());
		
        while(testCases>0){
            
        	char queue[] = new char[100];
        	String line = sc.nextLine();

        	char []ch = line.toCharArray();
        	char p[] = new char[100];//performance decrease -> extra array and size of array
        	int top=0;
          	
        	for(int i = 0; i < ch.length; i++){
                  
                  /* Open HTML Tag */
                  if(counter == 1 && rear == 1){
                      queue[rear++] = '/';
                  }                	  
                  if(ch[i]=='<' && counter == 0){
                      queue[rear++]=ch[i];
                      counter = 1;
                      //System.out.println(counter);
                  }else if(counter == 1 && ch[i] != '>'){
                      queue[rear++] = ch[i];
                      //System.out.println(counter);
                  }else if(counter == 1 && ch[i]=='>'){
                      queue[rear++] = ch[i];
                      counter = 2;
                      //System.out.println(counter);
                  }
                  /* End of open HTML tag */
                  if(counter == 2 && rear != 0){
                      p[top++]=ch[i];
                  }
                  /* Again open HTML tag */
                  if(counter == 3 && ch[i] != '>'){
                      char c = queue[front++];
                      if(c == ch[i])
                        continue;
                      else{                          
                          break;
                      }
                  }
                  else if(counter == 3 && ch[i] == '>' && front == rear-1){
                	  front++;
                	  counter = 4 ;
                  }
                  if(ch[i] == '<' && counter == 2){
                      front++;
                      counter = 3;
                  }
            }
        	if(counter == 4)
        	for(int k=1 ; k<top-1; k++)
                System.out.print(p[k]);
            
			counter = 0 ;
            rear = 0;
            front = 0;
			testCases--;
		}
	}catch(RuntimeException e) {
		e.printStackTrace();
	}
}
}



