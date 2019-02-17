package hackerrank;

public class IsNodePresentInTree {
	
	public static void main(String[] args) {
		System.out.println();
	}
	
	private static int isPresent(Node root, int val) {
		if(root == null) return 0;
		
		if(root.data == val) {
			return 1;
		} else if (root.data < val) {
			return isPresent(root.left, val);
		} else {
			return isPresent(root.right, val);
		}
	}

}


class Node {
	Node left, right;
	int data;

	Node(int newData) {
		left = right = null;
		data = newData;
	}
}