/* CLASS DIAGRAM

                 +-----------------------+
                 | abstract class ABST   |
                 +-----------------------+
      +----------| IBookComparator order |
      |          +-----------------------+
      |                 / \
      |                 ---
      |                  |
      |      -----------------
      |      |               |
      |   +------+   +------------+
      |   | Leaf |   | Node       |
      |   +------+   +------------+
      |              | Book data  |--------+
      |              | ABST left  |        |
      |              | ABST right |        |
      |              +------------+        |
      |                                    v
      v                            +---------------+
+-------------------------------+  | Book          |<------+
| IBookComparator               |  +---------------+       |
+-------------------------------+  | String title  |       |
| int compare(Book b1, Book b2) |  | String author |       |
+-------------------------------+  | int price     |       |
                                   +---------------+       |
                                                           |
                                                           |
           +--------------------+                          |
           |     ILoBook        |<-----------------------+ |
           +--------------------+                        | |
                   |                                     | |
          +------------------+                           | |
          v                  v                           | |
+---------------------+    +---------------------+       | |
|      MtLoBook       |    |     ConsLoBook      |       | | 
+---------------------+    +---------------------+       | |
+---------------------+  +-| Book          first |       | |
                         | | ILoBook       rest  |-------+ |
                         | +---------------------+         |
                         |                                 |
                         |                                 |
                         +---------------------------------+              

 */
/* Template
Fields: 
...this.order... - IBookCompaprator
Methods:
...this.insert... - ABST
...this.isLeaf... - boolean
...this.getFirst... - Book
...this.getRest... - ABST
...this.sameLeaf... - boolean
...this.sameNode... - boolean
...this.sameTree... - boolean
...this.thisBook... - Book
...this.bookInThis... - boolean
...this.thisInThat... - boolean
...this.sameData... - boolean
...this.buildList... - ILoB
...this.sameAsList... - boolean
 */
/** represents an abstract binary search tree for a library of books
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public abstract class ABST {
    IBookComparator order;
    
    public ABST(IBookComparator order) {
        this.order = order;
    }
    
    
    /** to create a new ABST which contains the new book
     * 
     * @param b the book to insert
     * @return ABST the new tree with the inserted book
     */
    public abstract ABST insert(Book b);
    
    /** to tell if the ABST is a leaf
     * 
     * @return boolean true if this is a leaf
     */
    public abstract boolean isLeaf();

    /** to get the first Book in the tree
     * 
     * @return Book the first book in the tree
     */
    public abstract Book getFirst();

    /** to get the rest of the tree, without the first book in the tree
     * 
     * @return ABST the rest of the tree
     */
    public abstract ABST getRest();

    /** tell if that leaf is the same as this
     * 
     * @param that the leaf to compare to this 
     * @return true if that leaf is the same as this 
     */
    abstract boolean sameLeaf(Leaf that);


    /** tell if that node is the same as this
     * 
     * @param that the node to compare to this 
     * @return true if that node is the same as this
     */
    public abstract boolean sameNode(Node that);


    /** tell if that tree is the same as this
     * 
     * @param that the tree to compare to this
     * @return true if that tree is the same as this tree
     */
    public abstract boolean sameTree(ABST that);
    
    /** return this book
     * 
     * @return Book the book at this root of the tree
     */
    public abstract Book thisBook();
    
    /** is the given book in this tree
     * 
     * @param book the book to check for in this tree
     * @return boolean true if that book is in this tree
     */
    public abstract boolean bookInThis(Book book);

    /** tell if that tree has the same data as this
     * 
     * @param that to check if the data in this tree is in that
     * @return true if the data in this tree is in that
     */
    public abstract boolean thisInThat(ABST that);
    
    /** tell if these two trees have the same books as each other
     * 
     * @param that the ABST to check
     * @return true if that tree and this have the same books
     */
    public boolean sameData(ABST that) {
        return (this.thisInThat(that) && that.thisInThat(this));
    }
    
    /** turn ABST to list of book
     * 
     * @return ILoB the list of books to build a BST from
     */
    public abstract ILoB buildList();

    /** tell if this list is the same as that
     * 
     * @param list the other list to check
     * @return boolean if that list is the same as this
     */
    public boolean sameAsList(ILoB list) {
        return list.compareList(this);
    }
    
    // sort sorts the tree
   // abstract ABST sort(ABST acc);
}