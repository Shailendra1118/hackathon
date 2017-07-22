package com.march.prac;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class StartEnd {
    public static void main(String args[] ) throws Exception {
       
        Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\march\\prac\\seinput.txt"));
        String sw = s.next();
        String ew = s.next();
        int N = s.nextInt();
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < N; i++) {
            dict.add(s.next());
        }
        
        process(sw, ew, dict);
        s.close();
    }
    
    
    private static void process(String sw, String ew, Set<String> dict){
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0,sw));
        while(! q.isEmpty()){
            
            Node cur = q.remove();
            Iterator<String> iter = dict.iterator();
            while(iter.hasNext()){            	
                String temp = iter.next();
                int count = cur.count+1;
                System.out.println("from dict: "+temp+", from Q: "+cur.val);
                if(isNext(temp, cur.val)){
                	//System.out.println("are adjacent");
                    q.add(new Node(count, temp));
                    
                    iter.remove();  
                    display(dict);
                    
                    if(temp.equals(ew)){
                        System.out.println(cur.count);
                        break;
                    }
                    
                }
                //mark that word visited
                //dict.remove(temp); //concurrent modification
               
            }
        }
        
    }
    
    private static void display(Set<String> dict) {
    	System.out.println("after remove");
    	dict.forEach(System.out::println);
    	//System.out.println();
		
	}


	private static boolean isNext(String one, String two){
        int diff = 0;
        for(int i=0; i<one.length(); i++){
            if(one.charAt(i) != two.charAt(i)){
                diff++;
            }
        }
        if(diff >1)
        return false;
        else
        return (diff == 1) ?true:false;
    }
    
   
}
class Node{
    int count;
    String val;
    
    public Node(int count, String val){
        this.count = count;
        this.val = val;
    }
}

