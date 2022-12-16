//ricart agarwala algorithm
import java.util.*;
import java.io.*;
public class Ricart {
    public static class Process{
        String name;
        int timestamp;
        int req_criticalsec=0;
        Queue<String> request;//request array of a process
        Queue<String> approval;//approval array of a process
        Queue<String> deferred_req;//deferred request array of a process
        public Process()
        {
          request=new LinkedList<>();
          approval=new LinkedList<>();
          deferred_req=new LinkedList<>(); 
    }
    }
    public static void main(String[] args)throws IOException, InterruptedException {
        int n,i,j,k=0;
        String ch;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of processes:");
        n=sc.nextInt();
        int c=0;
        int ar[]=new int[n];
        Process p[]=new Process[n];
        for(i=0;i<n;i++)
        {
            p[i]=new Process();
            System.out.println("Enter process name and timestamp:");
            p[i].name=sc.next();
            p[i].timestamp=sc.nextInt();
            System.out.println("Does this process request the critical section:");
            ch=sc.next();
            if(ch.equals("yes"))
            {
                p[i].req_criticalsec=1;
                ar[k]=i;
                k=k+1;
                            
            }
        }
        int temp;
        //sorting the processes according to their timestamps who wish to enter the CS
        for(i=0;i<k;i++)
        {
        	for(j=0;j<k-i-1;j++)
        	{
        		if(p[ar[j+1]].timestamp<p[ar[j]].timestamp){
        			temp=ar[j];
        			ar[j]=ar[j+1];
        			ar[j+1]=temp;
        			
        		}
        	}
        }
        //Implementing the Ricart-Agarwala algorithm
        for(i=0;i<k;i++){
                for(j=0;j<n;j++){
                    if(j!=ar[i]){
                        p[ar[i]].request.add(p[j].name);
              if(p[j].req_criticalsec==0)
              {
                  p[ar[i]].approval.add(p[j].name);
                  System.out.println("Process name:"+p[ar[i]].name);
                  System.out.println("Request array of the process:"+p[ar[i]].request);
                  System.out.println("Approval arrray of the process:"+p[ar[i]].approval);
                  System.out.println("Deffered_Request of the process:"+p[ar[i]].deferred_req);
              
              }
              else if(p[j].req_criticalsec==1)
              {
                  if(p[ar[i]].timestamp<p[j].timestamp)
                  {
                     p[ar[i]].approval.add(p[j].name);
                     p[ar[i]].deferred_req.add(p[j].name);
                     System.out.println("Process name:"+p[ar[i]].name);
                     System.out.println("Request array of the process:"+p[ar[i]].request);
                     System.out.println("Approval arrray of the process:"+p[ar[i]].approval);
                     System.out.println("Deffered_Request of the process:"+p[ar[i]].deferred_req);
                 
                  }
              }
                    }
                }
            if(p[ar[i]].approval.size()==n-1){
                System.out.println("process:"+p[ar[i]].name+" executing CS");
               p[ar[i]].req_criticalsec=0;
               System.out.println(".......................................");
               System.out.println(".......................................");
               System.out.println(".......................................");
               System.out.println("process:"+p[ar[i]].name+" completes CS");
               while(p[ar[i]].deferred_req.isEmpty()!=true){
            	   p[ar[i]].deferred_req.remove();
               }
               System.out.println("Process name:"+p[ar[i]].name);
               System.out.println("Request array of the process:"+p[ar[i]].request);
               System.out.println("Approval arrray of the process:"+p[ar[i]].approval);
               System.out.println("Deffered_Request of the process:"+p[ar[i]].deferred_req);
               System.out.println("-------------------------------------------------");
            }
                    }
        //displaying the final status of all processes
        System.out.println("------Final status of all the processes------");
        for(i=0;i<n;i++){
            System.out.println("Process name:"+p[i].name);
            System.out.println("Request array of the process:"+p[i].request);
            System.out.println("Approval arrray of the process:"+p[i].approval);
            System.out.println("Deffered_Request of the process:"+p[i].deferred_req);
        
    }
        
    }    
        
    }




    
       
        