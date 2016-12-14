
public class TernaryTree {
	class Node{
		int value;
		Node left,right,middle;
		public Node(int value){
			this.value=value;
			this.left=this.right=this.middle=null;
		}
	}
	Node root;
	TernaryTree(){
		root=null;
	}
	private void insert(int key) {
		// TODO Auto-generated method stub
		root=insertValue(root,key);
		
	}
	private Node insertValue(Node root, int key) {
		// TODO Auto-generated method stub
		if(root==null){
			root=new Node(key);
			return root;
		}
		if(key<root.value){
			root.left=insertValue(root.left,key);
		}
		else if(key>root.value){
			root.right=insertValue(root.right,key);
		}
		else if(key==root.value){
			root.middle=insertValue(root.middle,key);
		}
		return root;
	}
	void inorder(){
		inorderRec(root);
	}
	void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.value);
            inorderRec(root.middle);
            inorderRec(root.right);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TernaryTree bst=new TernaryTree();
		bst.insert(5);
		bst.insert(4);
		bst.insert(9);
		bst.insert(5);
		bst.insert(7);
		bst.insert(2);
		bst.insert(2);
		//bst.inorder();
		//System.out.println(bst.root.left.left.value);
		System.out.println("delete 5");
		bst.delete(5);
		bst.inorder();
		
	}
	private void delete(int key) {
		// TODO Auto-generated method stub
		root=deleteValue(root,key);
		System.out.println("root.value:"+root.value);
		
		
	}
	private Node deleteValue(Node root, int key) {
		// TODO Auto-generated method stub
		if(root==null){
			return root;
		}
		if(key<root.value){
			root.left=deleteValue(root.left,key);
		}
		else if(key>root.value){
			root.right=deleteValue(root.right, key);
		}
		else{
			if(root.middle!=null){
				root.value=root.middle.value;
				root.middle=null;
				return root;
			}
			if(root.left==null && root.right==null && root.middle==null){
				return null;
			}
			if(root.left==null && root.middle==null && root.right!=null){
				return root.right;
			}
			if(root.right==null && root.middle==null && root.left!=null){
				return root.left;
			}
			root.value=minValue(root.right);
			root.right=deleteValue(root.right,root.value);
			
		}
		return root;
	}
	private int minValue(Node root) {
		// TODO Auto-generated method stub
		int minValue=root.value;
		while(root.left!=null){
			minValue=root.left.value;
			root=root.left;
		}
		return minValue;
	}

	


	

}
