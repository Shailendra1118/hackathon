package com.hackerrank.dp;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Stones
{
     public static void main(String args[])throws Exception
     {
         Scanner scan = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerrank\\dp\\input.txt"));
         StringTokenizer st = new StringTokenizer(scan.nextLine());
         int n,L,D,i,j;
         
         n=Integer.parseInt(st.nextToken());
         L=Integer.parseInt(st.nextToken());
         D=Integer.parseInt(st.nextToken());
         
         double p[]=new double[n+2];
         int d[]=new int[n+2];
         
         p[0]=1.0;
         d[0]=0;
         p[n+1]=1.0;
         d[n+1]=D;
         
         st=new StringTokenizer(scan.nextLine());
         for(i=1;i<=n;i++)
         {
             p[i]=Double.parseDouble(st.nextToken());
         }
         
         st=new StringTokenizer(scan.nextLine());
         for(i=1;i<=n;i++)
         {
             d[i]=Integer.parseInt(st.nextToken());
         }
         
         for(i=1;i<=n+1;i++)
         {
             j=i-1;
             double val=-1.0;
             while((j>=0) && (d[i]-d[j]<=L))
             {
            	 System.out.println("Max of "+val+" and "+p[j]);
                 val=Math.max(val,p[j]);
                 j--;
                 //System.out.println("In while, val is "+val);
             }
             System.out.println("p[i]*val: "+p[i]+"*"+val);
             p[i]=p[i]*val;
             System.out.println("p[i]: "+Arrays.toString(p));
             if(p[i]<0.0)
             {
                 System.out.println("IMPOSSIBLE");
                 System.exit(0);
             }
         }
           
            
            
         System.out.printf("%.6f",p[n+1]);  
         scan.close();
     }
}