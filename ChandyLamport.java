
//chandy Lamport program
import java.io.IOException;
import java.util.*;
 class process {
	 //creation of send and receive queues for processes
    Queue<String> send = new LinkedList<String>();
    Queue<String> receive = new LinkedList<String>();
    int record=0;
    String marker="marker";
    public void sendmsg(String msg)
    {
      send.add(msg);
      
    }
    public void receivemsg(String m)
    {
        receive.add(m);
    }
 }
class Channel{
	//creation of message queue for receiving messages and marker in Channel
    Queue<String> message;
    String name;
    int record=0;
    public Channel()
    {
      message = new LinkedList<String>();
    }
}
public class ChandyLamport{
public static void main(String args[])throws IOException {
    
  Scanner sc = new Scanner(System.in);
  int n,i,j,m,t=0,k;
  String msg;
  String ch;
  System.out.println("Enter number of processes:");
  n=sc.nextInt();
   process p[]=new process[n];
  int a[][]=new int[n][n];
  //creation of adjacency matrix
  System.out.println("Enter the adjacency matrix:");
  for(i=0;i<n;i++){
      for(j=0;j<n;j++){
          a[i][j]=sc.nextInt();
          if(a[i][j]==1){
              t++;
          }
      }
      System.out.println();
  }
  //Entering the channel names
 Channel chan[]=new Channel[t];
  for(k=0;k<t;k++)
  {
      System.out.println("Enter channel name:");
      ch=sc.next();
   chan[k] = new Channel();
   chan[k].name = ch;
  }
  for(i=0;i<n;i++){
	  p[i]=new process();
  }
  int am,c=0,k1=0,m1=k1,p1=1,i1;
  int ar[]=new int[t];
  System.out.println("Enter the initiator node:");
  int init=sc.nextInt();
  //executing the chandy lamport consistent state recording algorithm
  //sending and receiving of messages amongst the processes until all the processes have recoreded their state
  //Also no markers are left in the channels
  while(c<t){
	  am=init;
  for(i=0;i<n;i++)
  {
	  if(a[am][i]==1){
      System.out.println("Enter number of messages to be sent by:"+am);
      m=sc.nextInt();
      for(j=0;j<m;j++){
          System.out.println("Enter message name received by process-id::"+i);
           msg=sc.next();
               p[am].record=1;
               p[am].sendmsg(msg);
               chan[c].message.add(msg);
               if(p[i].record!=1){
               p[i].receivemsg(msg);
            chan[c].message.remove(msg);
               }
      }        
      p[am].sendmsg("marker");
      p[am].send.remove("marker");
      chan[c].message.add("marker");
      if(p[i].record!=1){
      p[i].receivemsg("marker");
      p[i].record=1;
      }
      p[i].receive.remove("marker");
      chan[c].message.remove("marker");
      chan[c].record=1;
      c=c+1;
      ar[k1++]=i;
}
  }
  init=ar[m1];
  m1=m1+1; 
}
//display process and channel states
  for(i=0;i<n;i++)
  {
	 System.out.println("process states of node:"+i);
	 System.out.println(p[i].send);
	 System.out.println(p[i].receive);
  }
  for(i=0;i<t;i++){
	  System.out.println("Channel states of channel:"+chan[i].name);
	  System.out.println(chan[i].message);
  }
} 
  }

