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
		int [] arr = new int[10];
		arr[0]=5;
		arr[1]=3;
		arr[2]=8;
		arr[3]=1;
		arr[4]=59;
		arr[5]=512;
		arr[6]=54;
		arr[7]=5;
		arr[8]=51;
		arr[9]=55;
		System.out.println(binarySearch(arr, 100));
	}
	public static int binarySearch( int [ ] a, int x )
	 {
	 // här kommer Tony att lägga till kod ( se uppgift d)

	 int NOT_FOUND=-1;
	 int low = 0;
	 int high = a.length - 1;
	 int mid;
	 while( low <= high )
	 {
	 mid = ( low + high ) / 2;
	 if ( x> a[ mid ] )
	 low = mid + 1;
	 else if(x< a[ mid ] )
	 high = mid - 1;
	 else
	 return mid; }
	 return NOT_FOUND;
	 }

}
