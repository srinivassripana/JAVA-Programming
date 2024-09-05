import java.util.*;
import java.lang.*;
import java.io.*;

class basics1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++){
		    for(int j=0;j<2;j++){
		        int X = sc.nextInt();
		        int Y = sc.nextInt();
		        if((X+Y)>6){
		            System.out.println("YES");
		        }
		        else{
		            System.out.println("NO");
		        }
		    }
		}
	}
}
