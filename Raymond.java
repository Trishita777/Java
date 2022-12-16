import java.util.*;
import java.io.*;

//Raymond's algorithm execution
public class Raymond
{
	public static class Process{
		String name;
		int parent;//if parent=-1 then its a root node
		int priviledge=0;//if priviledge=1,the node is executing the CS
		Queue<Integer> request;//token request array
		public Process(){
			request = new LinkedList<>();
		}
	}
	public static void main(String[] args)throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n,i,j,flag,r=0;
		String ch;
		System.out.println("Enter the number of processes:");
		n=sc.nextInt();
		Process p[]=new Process[n];
         for(i=0;i<n;i++)
		{
        	System.out.println("Enter the process name's and their parents-id:");
			p[i]=new Process();
			p[i].name=sc.next();
			p[i].parent=sc.nextInt();
			if(p[i].parent==-1){
				r=i;
				p[i].priviledge=1;
			}
        	 
		}
         for(i=0;i<n;i++){
			System.out.println("Is the process-id:"+ i +" requesting token for CS?:");
			ch=sc.next();
			if(ch.equals("yes")==true){
			p[i].request.add(i);
			j=i;
			flag=1;
			while(p[j].parent!=-1){
				for(Integer item:p[p[j].parent].request){
					if(item==j){
						flag=0;
					}
				}
				if(flag==1){
				p[p[j].parent].request.add(j);}
				j=p[j].parent;
			
			}
			}	
		}
        
         int q=0;
        int c=0;
        int flag1=1;
       //Raymond's algorithm execution
        while(true){
        	i=r;     	
        	flag1=1;
        	 for(j=0;j<n;j++){
            	 System.out.println("Request array of process:"+p[j].name+":"+p[j].request);
            	
             }
        	 if(p[i].priviledge==1){
        		 q=p[i].request.remove();
        		 p[i].priviledge=0;
        		 p[i].parent=q;
        		 p[q].parent=-1;
        		 p[q].priviledge=1;
        		 r=q;
        		 if(q==i)
        		 {
        			 if(p[i].request.isEmpty()!=true){
        			 c=p[i].request.remove();
        			 p[c].priviledge=1;
        			 p[i].priviledge=0;
        			 p[i].parent=c;
        			 p[c].parent=-1;
        			 }
        			 System.out.println(p[q].name +" executing critical section.....");
        			 System.out.println("........................................."); 
        			 if(p[i].request.isEmpty()!=true)
        			 {
            			 p[c].request.add(i);
            			 }
        			 r=c;
        		 }
        		 else{
        			 if(p[i].request.isEmpty()!=true)
        			 {
            			 p[q].request.add(i);
            			 }
        			 r=q;
        		 }
        		 } 
        	for(i=0;i<n;i++){
        		if(p[i].request.isEmpty()!=true)
        			flag1=0;
        	}
        	 if(flag1==1)
        		 break;
         } 
        
         for(i=0;i<n;i++){
        	 System.out.println("Request array of process:"+p[i].name+":"+p[i].request);
        	
         }
			
	}
		
	}
	







	


