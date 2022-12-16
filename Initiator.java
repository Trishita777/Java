//finding initiator nodes in a graph
import java.util.*;
public class Initiator {
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	String nodes[]=new String[100];
	System.out.println("Enter no of nodes:");
	int n=sc.nextInt();
	System.out.println("Enter node names:");
	int i,j,m=0;
	int in[]=new int[n];
	int out[]=new int[n];
	int adj[][]=new int[n][n];
	String k="";
	//input the node names
	for(i=0;i<n;i++)
	{
		nodes[i]=sc.next();
	}
	//take input the adjacency matrix of the graph
	System.out.println("Enter the adjacency matrix:");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			adj[i][j]=sc.nextInt();
		}
	}
	//calculating indegree and outdegree of the nodes
	for(i=0;i<n;i++)
	{
		int t=0,t1=0;
		for(j=0;j<n;j++)
		{
			if(adj[i][j]==1){
				t=t+1;
               out[i]=t;
			}
			if(adj[j][i]==1){
				t1=t1+1;
				in[i]=t1;
			}  
		}
	}
	//display the indegree and outdegree of the nodes
	System.out.println("Indegree and outdegree of the nodes are:");
	for(i=0;i<n;i++)
	{
		System.out.println(nodes[i]+" "+in[i]+" "+out[i]);
	}
	for(i=0;i<n;i++){
		if(in[i]==0){
			m++;
			k=nodes[i];
		}
	}
	//different cases of finding the initiator node(s) in the graph
	if(m==1)
	System.out.println(k+" is the only initiator node in the graph.");
	else if(m>=2)
		System.out.println("There are no initiator nodes in the graph.");
	else if(m==0)
	{
		for(i=0;i<n;i++){
			if(out[i]!=0){
				System.out.println(nodes[i]+" can be taken as an initiator node in the graph.");
			}
			
		}
	}
	
}
}

