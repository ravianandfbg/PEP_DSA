public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
      int n = preorder.length;
      return helper(preorder , 0 , n-1 , postorder , 0 , n-1);
      
      
  }
  
  // prs : preorder start              pre : preorder end
  // pos : postorder start             poe : postorder end
  public static TreeNode helper(int[] preorder , int prs , int pre , int[] postorder , int pos , int poe){
      if(pos > poe){
          return null;
      }
      
      if(prs == pre){
          return new TreeNode(preorder[prs]);
      }
      
      TreeNode node = new TreeNode(preorder[prs]);
      
      int val = preorder[prs+1];
      
      int idx = -1;
      
      for(int i = pos ; i <= poe ; i++){
          if(postorder[i] == val){
              idx = i;
              break;
          }
      }
      int cls = idx - pos + 1; // cls : count of left subtree
      
      node.left = helper(preorder , prs+1 , prs+cls , postorder , pos , idx);
      node.right = helper(preorder , prs+cls+1 , pre , postorder , idx+1 , poe-1);
      
      return node;
  }