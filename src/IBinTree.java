import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();
 // returns value of node
 int getNode();
 boolean isValidHeap();
 List<Integer> convertToList();
}


class MtBT implements IBinTree {
 MtBT(){}

 // returns false since empty tree has no elements
 public boolean hasElt(int e) {
  return false;
 }

 // returns 0 since enpty tree has no elements
 public int size() {
  return 0;
 }

 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }

 public int getNode(){ return Integer.MAX_VALUE;}

 public IBinTree getRight(){return new MtHeap();}

 public IBinTree getLeft(){return new MtHeap();}

 public boolean isValidHeap(){ return false; }

 /**
  * converts a binary tree to an array of integers
  * @return an array of integers
  */
 public List<Integer> convertToList(){
     List<Integer> emptyList = new ArrayList<>();
     return emptyList;
 }
}


class DataBT implements IBinTree {
 int data;
 IBinTree left;
 IBinTree right;

 DataBT(int data, IBinTree left, IBinTree right) {
  this.data = data;
  this.left = left;
  this.right = right;
 }

 // an alternate constructor for when both subtrees are empty
 DataBT(int data) {
  this.data = data;
  this.left = new MtBT();
  this.right = new MtBT();
 }

 // determines whether this node or node in subtree has given element
 public boolean hasElt(int e) {
  return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
 }

 // adds 1 to the number of nodes in the left and right subtrees
 public int size() {
  return 1 + this.left.size() + this.right.size();
 }

 // adds 1 to the height of the taller subtree
 public int height() {
  return 1 + Math.max(this.left.height(), this.right.height());
 }

 /**
  * returns value of node
  * @return value of node
  */
 public int getNode() {
  return this.data;
 }

 /**
  * determines whether given heap is valid heap
  * @return boolean indicating whether given heap is a valid heap
  */
 public boolean isValidHeap() {
   if (this.getNode() <= this.getLeft().getNode() && this.getNode() <= this.getRight().getNode()) {
    if (this.getLeft().size() == 0 && this.getRight().size() == 0)
     return true;
    else if (this.getLeft().size() == 0)
     this.getRight().isValidHeap();
    else if (this.getRight().size() == 0)
     this.getRight().isValidHeap();
    this.getLeft().isValidHeap();
    this.getRight().isValidHeap();
    return true;
   }
   return false;
  }

 /**
  * converts a binary tree to an array of integers
  * @return an array of integers
  */
 public List<Integer> convertToList() {
  List<Integer> convertedList = new ArrayList<>();

  if(getLeft().getNode() != Integer.MAX_VALUE)
   convertedList.addAll(getLeft().convertToList());

  if(getRight().getNode() != Integer.MAX_VALUE)
   convertedList.addAll(getRight().convertToList());

  convertedList.add(getNode());

  return convertedList;
 }

 /**
  * returns left subtree
  * @return left IBinTree
  */
 public IBinTree getLeft() { return this.left; };

 /**
  * returns right subtree
  * @return right IBinTree
  */
 public IBinTree getRight() { return this.right; }

}

