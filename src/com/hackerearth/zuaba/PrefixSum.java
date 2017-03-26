package com.hackerearth.zuaba;

public class PrefixSum {

	static long[][] val = new long[8][11];
	public static void main(String[] args) {
		init();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 11; j++) {
				System.out.print(val[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	static void init()
	{
		for(int i=2;i<11;i++)
		{
			int curr=i,num=2;
			while(curr>1)
			{
				while(curr%num==0)
				{
					curr/=num;
					//System.out.println("val[num][i] "+ val[num][i]);
					val[num][i]++;
				}
				num++;
			}
		}
	}

}
