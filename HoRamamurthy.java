import java.io.*;
import java.util.*;
public class HoRamamurthy {
	static int a[][] = new int[100][100];
	static int a1[][] = new int[50][50];
	static int n1;
	static int p=-1;
	public static class Site{
		//the process status table
		List<Integer> blocked = new ArrayList<Integer>();
		List<Integer> blocking = new ArrayList<Integer>();
		}
	public static void main(String[] args)throws IOException
	{
		int n,i,j,ch,ch1,m,count=0,k=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------Ho-ramamurthy deadlock detection-----------");
		System.out.println("Enter number of sites:");
		n = sc.nextInt();
		System.out.println("Enter number of processes:");
		n1 = sc.nextInt();
		Site s[] = new Site[n];
		for(i=0;i<n;i++){
			s[i] = new Site();
			System.out.println("Site:"+ i);
			do
			{
				System.out.println("Enter blocked and blocking processes id:");
				ch = sc.nextInt();
				ch1 = sc.nextInt();
				a[ch][ch1] = 1;
			    s[i].blocked.add(ch);
			    s[i].blocking.add(ch1);
			    System.out.println("Do you want to continue(1/0)?");
			    k = sc.nextInt();
			    }while(k==1);
		}
		for(i=0;i<n;i++)
		{
			System.out.println("Site:"+i);
			System.out.println("Blocked process list:"+s[i].blocked);
			System.out.println("Blocking process list:"+s[i].blocking);			
		}
		System.out.println("The control site creates the total Wait-For-Graph:");
		for(i=0;i<n1;i++){
			for(j=0;j<n1;j++){
				if(a[i][j]!=1)
				{
					a[i][j]=0;
				}
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
		//check for cycle to detect the deadlock
			for(i=0;i<n1;i++)
			{
			m = cycle(i,i);	
			if(m==i)
				count=count+1;
			}		
	if(count > 0)
		System.out.println("Cycle is there.Deadlock is detected!");
	else
		System.out.println("Cycle is not there.Deadlock is not there!");		
			
	}
	public static int cycle(int i,int i1)
	{
		int j;
		for(j=0;j<n1;j++)
		{
		if (a[i1][j]==1){
			if(i == j){
				p=j;
				break;
			}
			cycle(i,j);
		}
		}
		return p;
	
	}
}

	
		
		
		
		
	


