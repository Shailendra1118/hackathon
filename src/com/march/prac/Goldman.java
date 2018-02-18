package com.march.prac;

public class Goldman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int operation = 2;
		String msg = "oppeeened";
		String key = "12";
		
		//String msg = "open";
		//String key = "123456";
		if(operation == 1){
			char[] msgc = msg.toCharArray();
			char[] keyc = key.toCharArray();
			StringBuilder sb = new StringBuilder();
			int mcount = msgc.length;
			int kcount = keyc.length;
			int i = 0;
			while(mcount > 0 && kcount >0){
				String rep = Character.toString(keyc[i]);
				int repi = Integer.parseInt(rep);
				System.out.println("rep: "+rep);
				for (int j = 0; j < repi; j++) {
					sb.append(msgc[i]);
				}
				i++;
				mcount--;
				kcount--;
			}
			
			if(msg.length() > key.length()){
				for (int j = i; j < msg.length(); j++) {
					sb.append(msgc[j]);
				}
			}
			System.out.println(sb.toString());
		}
		
		//decoding
		if(operation == 2){
			char[] msgc = msg.toCharArray();
			char[] keyc = key.toCharArray();
			StringBuilder sb = new StringBuilder();
			int mcount = msgc.length;
			int kcount = keyc.length;
			int i = 0;
			int k = 0;
			while(mcount > 0 && kcount >0){
				String rep = Character.toString(keyc[k]);
				int repi = Integer.parseInt(rep);
				System.out.println("rep: "+rep);
				boolean added = false;
				for (int j = repi; j > 0; j--) {
					if(! added){
						sb.append(msgc[i]);
						added = true;
					}
					i++;
				}
				k++;
				mcount--;
				kcount--;
			}
			
			if(msg.length() > key.length()){
				for (int j = i; j < msg.length(); j++) {
					sb.append(msgc[j]);
				}
			}
			System.out.println(sb.toString());
		}
	}

}
