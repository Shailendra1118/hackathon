import java.util.Iterator;
import java.util.TreeSet;


public class Test {
	int a = 0;

	public static void main(String[] args) {
		int A[] = {-876,87,0,876,-77,3,5,6,2,-2147483648}; //2147483647 failing for max
		System.out.println("res "+solution(A));
		//System.out.println("res1 "+solution1(A));
	}

	private static int solution1(int[] A) {
		int res = 0;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 0) {
				//System.out.println("inserting into tree "+ A[i]);
				set.add(A[i]);
			}
		}
		
		Iterator<Integer> iter = set.iterator();	
		System.out.println(set.toString());
		int last = 0, curr = 0;
		// if all negative return 1
		if(iter.hasNext()){
			last = iter.next();
			if( !iter.hasNext() && last > 1){
				return 1;
			}
		}
		else
			return 1;
		// otherwise return next positive 
		while(iter.hasNext()){
			curr = iter.next();
			if(last+1 == curr){
				last = curr;
			}else{
				res = last+1;
				break;
			}
		}
		return res;
	}

	public static int solution(int[] A) {	
		int arr[] = new int[1000];
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 0) {
				System.out.println(A[i]);
				arr[A[i]] = 1;
			}
		}
		//System.out.println(Arrays.toString(arr));
		int lastMin = 1; //for extreme single case		
		for (int j = 1; j < arr.length; j++) {
			if (arr[j] == 0) {
				System.out.println("j:"+j);
				lastMin = j;
				break;
			}
		}

		return lastMin;
	}

}
