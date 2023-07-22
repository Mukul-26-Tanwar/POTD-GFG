//{ Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;
import java.io.*;
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}

class Remove_Duplicate_From_LL
{
    Node head;  
    Node temp;
	public void addToTheLast(Node node) 
	{

	  if (head == null) 
	  {
	    head = node;
	    temp = node;
	  }
	  else{
	      temp.next = node;
	      temp = node;
	  }
	}

      void printList(PrintWriter out)
    {
        Node temp = head;
        while (temp != null)
        {
           out.print(temp.data+" ");
           temp = temp.next;
        }  
        out.println();
    }
	
	/* Drier program to test above functions */
	public static void main(String args[])throws IOException
    {
       
        
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
         PrintWriter out=new PrintWriter(System.out);
		 int t=Integer.parseInt(in.readLine().trim());
		  
		 while(t>0)
         {
			int n = Integer.parseInt(in.readLine().trim());
			Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
			String s[]=in.readLine().trim().split(" ");
			int a1=Integer.parseInt(s[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = Integer.parseInt(s[i]); 
				llist.addToTheLast(new Node(a));
			}
		//llist.printList();	
        Solution g = new Solution();
		llist.head = g.removeDuplicates(llist.head);
		llist.printList(out);
		
        t--;		
        }
        out.close();
    }
}

// } Driver Code Ends


/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class Solution
{
    //Function to remove duplicates from unsorted linked list.
   public Node removeDuplicates(Node head)          // TC : n
   {
       
       Set<Integer> s = new HashSet<>();
       Node temp=head,prev=null;
       while(temp!=null)
       {
           if(s.contains(temp.data))
           {
               prev.next=temp.next;
               temp=temp.next;
           }
           else
           {
               s.add(temp.data);
               prev=temp;
               temp=temp.next;
           }
           
       }
       return head;
   }
}
/*
 public Node removeDuplicates(Node head)        //TC : 2n
    {
         // Your code here
         LinkedHashSet<Integer> ans = new LinkedHashSet<>();
         Node temp = head,helper;
         int i=0;
         while(temp!=null)
         {
             ans.add(temp.data);
             temp=temp.next;
         }
        // System.out.print(ans);
         helper=temp=head;
         for(int x : ans)
         {
             temp.data=x;
             temp=temp.next;
             if(i>=1)   helper=helper.next;
             i++;
         }
         helper.next=null;
         return head;
    }
*/