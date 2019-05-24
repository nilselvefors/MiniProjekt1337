package s;

import java.time.Instant;

public class tenta {
	
	public static int ones(int n) {
			// n ---->
		if(n==0) {
			return 0;
		}
		else if (n%2==0) {
//			System.out.println(n + "    n%2");
			return ones(n/2);   // return n / 2 
					 
		}
		else {
//			System.out.println(n + "   n / 2");
			return 1+ones(n/2);  // add 1 to the total ones and return n/2 
		}
	}
	public static void main(String[] args) {
		System.out.println(ones(100));
			
		
		
	}

}
