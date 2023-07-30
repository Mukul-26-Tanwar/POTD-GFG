//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str)
    {
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }

    public static Node search(Node root,int x){
		if(root==null||root.data==x)
			return root;
		if(root.data>x)
			return search(root.left,x);
		return search(root.right,x);
	}

	public static void main (String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int t=Integer.parseInt(br.readLine());
            
            while(t > 0){
                String s = br.readLine();
                Node root = buildTree(s);
                
                int k=Integer.parseInt(br.readLine());
                Node kNode = search(root,k);
                
                Solution g = new Solution();
                Node x = g.inorderSuccessor(root,kNode);
                
                if(x==null) System.out.println("-1");
                else System.out.println(x.data);
                t--;
            }
    }
}
// } Driver Code Ends


//User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/

class Solution{
	public Node inorderSuccessor(Node root,Node k)
	{
		if(root==null||k==null)
			return null;
		Node temp=null;
		while(root!=null){
			if(root.data<=k.data){
				root=root.right;
			}
			else{
				temp=root;
				root=root.left;
			}
		}
		return temp;
		
	}
}


// class Solution
// {
//     // returns the inorder successor of the Node x in BST (rooted at 'root')
// 	public Node inorderSuccessor(Node root,Node x)
//          {
//           //add code here.
          
//           ArrayList<Integer> l = new ArrayList<>();
//           find(root,l);
//           int res = 0;
//           for(int i =0;i<l.size()-1;i++){
              
//               if(l.get(i)==x.data){
                  
//                   res = l.get(i+1);
//               }
//           }
//           if(res == 0){
//               res = -1;
//           }
//           Node temp = new Node(res);
//           return temp;
          
//          }
         
//          public static void find(Node root, ArrayList<Integer> l){
//              if(root==null){
//                  return;
//              }
//              find(root.left,l);
//              l.add(root.data);
//              find(root.right,l);
//          }
         
// }