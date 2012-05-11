
public class LCA {
	
	/**
	 * 
	 * @param root, the root of the BST
	 * @param a, one node
	 * @param b, one node
	 * @return the lowest common ancestor
	 */
	public static Node LCA(Node root, Node a, Node b)
	{
		if(root == null || a==null || b==null)
		{
			return null;
		}
		
		if((a.value - root.value) * (b.value - root.value) <= 0)
		{
			return root;
		}
		else if((a.value - root.value) * (b.value - root.value) > 0)
		{
			if((a.value - root.value)>0)
			{
				return LCA(root.right, a, b);
			}
			else
			{
				return LCA(root.left, a, b);
			}
		}
		return null;
	}
	
	private class Node
	{
		int value;
		Node left;
		Node right;
	}
}
