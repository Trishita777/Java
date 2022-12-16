import java.util.*;
import java.io.*;
public class TokenBased {
public static class Process{
	int predecessor;
	String name;
	int token=0;//token=1,having the token otherwise not having the token
	Queue<Integer> request;
	public Process(){
		request = new LinkedList();
	}	
}
public static void main(String args[])throws IOException
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number of processes:");
	int n,i,r=0;
	String ch="";
	n=sc.nextInt();
	Process p[]=new Process[n];
	for(i=0;i<n;i++){
	System.out.println("Enter process name and its predecessor-id:");
	p[i]=new Process();
	p[i].name=sc.next();
	p[i].predecessor=sc.nextInt();
	System.out.println("Does the process:"+i+" is the phold?");
	ch=sc.next();
	if(ch.equals("yes")==true){
		p[i].token=1;
	    r=i;
	}
	}
	int j;
	for(i=0;i<n;i++)
	{
		if(p[i].token!=1){
		System.out.println("Does the process:"+i+" requesting CS?");
		ch=sc.next();
		}
		if(ch.equals("yes")==true){
			j=i;
			while(p[j].token!=1){
				j=p[j].predecessor;
		}
			p[j].request.add(i);
	}
		
}	
int q=0;
int c,flag=1;
while(true){
	
	flag=1;
	for(j=0;j<n;j++){
	System.out.println("Process-"+p[j].name+" request array:"+p[j].request);}
	if(p[r].token==1){
	System.out.println("Process:"+p[r].name +" executing in the CS..");
	System.out.println("..................................");
	if(p[r].request.isEmpty()!=true){
     q=p[r].request.remove();
     p[q].token=1;
	}
     p[r].token=0;
    	 while(p[r].request.isEmpty()!=true){
    	c=p[r].request.remove();
    	p[q].request.add(c);
     }
    	 r=q;
	}
	for(j=0;j<n;j++)
	{
		if(p[j].token==1)
		{
			flag=0;
		}
	}
	if(flag==1)
		break;
}
for(i=0;i<n;i++)
{
	System.out.println("Process-"+p[i].name+" request array:"+p[i].request);
}
}
}