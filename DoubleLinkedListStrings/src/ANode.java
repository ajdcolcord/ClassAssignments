/*
CLASS DIAGRAM: 

    +------------------+
 +->|     ANode        |
 |  +------------------+      
 |  | String      data |
 +--| ANode       next |     
 +--| ANode       prev |    
    +------------------+     
             ^             
             |
             |
             |
             +
   +--------------------+
   |                    |
   |                    |
   v                    v
+--------+          +-----------+
|  Node  |          |  Sentinel |
+--------+          +-----------+
                            ^
                            |
                            |
        +-------------+     |
        |    Deque    |     |
        +-------------+     |
        | ANode  node |-----+
        +-------------+  
                

 



*/

/* Template
Fields: 
... this.data ... - String
... this.next ... - ANode
... this.prev ... - ANode
Methods:
... this.isSentinel() ...   - boolean
... this.size() ...         - int
... this.sameNodeData() ... - boolean
... this.find() ...         - ANode
... this.removeNode() ...   - void
*/

/** represents the node that contains data, a previous, and a next
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public abstract class ANode {
    String data;
    ANode next;
    ANode prev;
    
    ANode(String data, ANode next, ANode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    /** tells if this is a sentinel or not
     * 
     * @return boolean if this is a sentinel
     */
    public abstract boolean isSentinel();
    
    /** calculate the size of the list
     * 
     * @return int the total size of the list
     */
    public abstract int size();
    
    /** tells if the data in this node is the same as that
     * 
     * @param that the other node to compare with
     * @return boolean true if that has the same data as this
     */
    public boolean sameNodeData(ANode that) {
        return (this.data.equals(that.data));
    }
    
    /** find the node in this list that has that as it's data
     * 
     * @param that the string that will be searched for as node's data
     * @return
     */
    public abstract ANode find(String that);
    
    /** remove that node from this list
     * EFFECT: removes the given node from this list
     * 
     * @param that the node to remove
     */
    public abstract void removeNode(ANode that);
}