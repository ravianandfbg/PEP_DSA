
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ GFG ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


// class GFG
// {
//     Node buildTree(int inorder[], int level[])
//     {
//         //your code here
//         hm = new HashMap<>(); //ele vs its index in iorder
        
//         for(int i = 0 ; i < inorder.length ; i++){
//             hm.put(inorder[i] , i);
//         }
//         return helper(level , inorder , 0 , inorder.length - 1);
//     }
    
//     HashMap<Integer,Integer> hm;
    
//     Node helper(int[] level , int[] inorder , int is , int ie){
//         if(is > ie){
//             return null;
//         }
        
//         Node node = new Node(level[0]);
//         int k = hm.get(node.data);
        
//         int ls = k - is; // ls : left size
//         int rs = level.length - ls - 1; // rs : right size
        
//         int[] llo = new int[ls]; // llo : left level order
//         int[] rlo = new int[rs]; // rlo : right level order
        
//         int p = 0 , q = 0;
        
//         for(int i = 1 ; i < level.length ; i++){
//             int idx = hm.get(level[i]);
            
//             if(idx < k ){
//                 llo[p++] = level[i];
//             }
//             else if(idx > k){
//                 rlo[q++] = level[i];
//             }
//         }
//         node.left = helper(llo , inorder , is , k - 1);
//         node.right = helper(rlo , inorder , k + 1 , ie);
        
//         return node;
//     }
// }

