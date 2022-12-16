import java.io.*;
import java.util.*;
//Termination detection diffusion computation based algorithm
public class Termination_Detection {
public static class process
{
	int active;//if active=1, then process is active ; if active=0 then process is passive 
	List<Integer> send = new ArrayList<Integer>();
	List<Integer> receive = new ArrayList<Integer>();
}
public static void main(String[] args)throws IOException
{
	int i,n,ch,j,m;
	Scanner sc = new Scanner(System.in);
	System.out.println("--------------Diffusion computation based Termination Detection algorithm--------------");
	System.out.println("Enter the number processes:");
	n = sc.nextInt();
	int a[][]=new int[n][n];
	process p[] = new process[n]; 
	for(i=0;i<n;i++)
	{
    p[i] = new process();
	System.out.println("Is the process-"+i+" active or passive(1/0)?:");
	ch = sc.nextInt();
	p[i].active=ch;		
	}
	System.out.println("Enter initiator process id:");
	ch = sc.nextInt();
	p[ch].active=0;
	System.out.println("Enter the Wait-For-Graph:");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
		a[i][j]=sc.nextInt();
		}
		System.out.println();
	}
	for(i=0;i<n;i++)
	{
		if(a[ch][i]==1)
		{
		p[ch].send.add(i);	
		}
	}
	for(i=0;i< p[ch].send.size();i++){
		m=p[ch].send.get(i);
		for(j=0;j<n;j++)
		{
			if(a[m][j]==1)
			{
				p[m].send.add(j);
				if(p[j].active==0)
					p[m].receive.add(j);
			}
		}
			if((p[m].send.size()==p[m].receive.size()) && (p[m].active==0))
				p[ch].receive.add(m);
		
	}
	
	if(p[ch].send.size()==p[ch].receive.size())
	{
		System.out.println("Messages send by process-"+ch+":"+p[ch].send);
		System.out.println("Replies received by process-"+ch+":"+p[ch].receive);
		System.out.println("Termination detected by process-"+ch+"!");
	}	
	else
	{
		System.out.println("Termination is undetected by process-"+ch+"!");
	}
}	
}
