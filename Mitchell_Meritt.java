//Mitchell_Meritt program for deadlock detection
import java.util.*;
import java.io.*;
public class Mitchell_Meritt {
  public static class Process{
	  int u;//public label
	  int v;//private label
	  
  }
  public static void main(String[] args)throws IOException
  {
	Scanner sc=new Scanner(System.in);
	int n,i,j,ch,t;
	boolean isDeadlock = false;
	System.out.println("-----Mitchell meritt algorithm-----");
	System.out.println("Enter number of processes:");
	n=sc.nextInt();
	Process p[] = new Process[n];
	int w[][]=new int[n][n];
	for(i=0;i<n;i++){
		p[i] = new Process();
		p[i].u=i;
		p[i].v=i;
	}
	System.out.println("Enter the Wait-For-Graph:");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++){
			w[i][j]=sc.nextInt();
		}
		System.out.println();
	}
	System.out.println("Initial process's public and private label");
	System.out.println("Process"+ "\t"+"Public label"+"\t"+"Private label");
	for(i=0;i<n;i++){
		System.out.println(i+ "\t"+p[i].u+"\t\t"+p[i].v);
	}
	do{
	System.out.println("0-Check deadlock for same Wait-for-graph");
	System.out.println("1-Process requesting resource");
	System.out.println("2-Process granted the request");
	System.out.println("Enter the choice:");
	ch=sc.nextInt();
	switch(ch)
	{
	case 0:break;
	case 1:System.out.println("Enter the process requesting resource and the process holding the request:");
	       int k,l;
	       k=sc.nextInt();
	       l=sc.nextInt();
	       w[k][l]=1;
	       break;
	case 2:System.out.println("Enter the process requesting resource and the process granting the request:");
	       int m,m1;
           m=sc.nextInt();
           m1=sc.nextInt();
           w[m][m1]=0;
           break;
	}
	int max=0;
	//The block rule applied here
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			if(w[i][j]==1){
				max = 0;
				if(p[i].u>p[j].u)
					max=p[i].u;
					else
				    max=p[j].u;
				p[i].u = max+1;
				p[i].v = p[i].u;
				
				}
			}
		}
	//The transmit rule applied here
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++){
			if(w[i][j]==1)
			{
				if(p[j].u>p[i].u)
					p[i].u = p[j].u;
			}
		}
	}
	//The detect rule applied here
	isDeadlock = false;
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			if(w[i][j]==1)
			{
				if(p[i].v == p[j].u)
					isDeadlock = true;
			}
		}
	}
	System.out.println("Process"+ "\t"+"Public label"+"\t"+"Private label");
	for(i=0;i<n;i++){
		System.out.println(i+ "\t"+p[i].u+"\t\t"+p[i].v);
	}
	if(isDeadlock == true)
		System.out.println("Deadlock detected!");
	else
		System.out.println("Deadlock not detected!");
	System.out.println("Do you want to continue(1/0)?:");
    t=sc.nextInt();
	}while(t==1);
  }	
}
