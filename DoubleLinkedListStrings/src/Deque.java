/* Template
Fields:
... this.node ... - Sentinel
Methods:
... this.size() ...           - int
... this.addAtHead() ...      - void
... this.addAtTail() ...      - void
... this.removeFromHead() ... - void
... this.removeFromTail() ... - void
... this.find() ...           - ANode
... this.removeNode() ...     - void
Methods for Fields:
... this.node.size() ...            - int
... this.node.addAtHead() ...       - void
... this.node.addAtTail() ...       - void
... this.node.removeFromHead() ...  - void
... this.node.removeFromTail() ...  - void
... this.node.find() ...            - ANode
... this.node.removeNode() ...      - void
*/

/** contains the sentinel for this list (the head)
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class Deque {
    Sentinel node;
    
    Deque(Sentinel node) {
        this.node = node;
    }
    
    /** count the size of the list in this deque
     * 
     * @return int the size of this deque
     */
    public int size() {
        return this.node.size();
    }
    
    /** adds a new head for this list
     * EFFECT: add a new head for the list
     *
     * @param that the String to make as a head
     */
    public void addAtHead(String that) {
        this.node.addAtHead(that);
    }
    
    /**  adds a new tail to the list
     * EFFECT: add a new tail for the list
     * 
     * @param that the String to add to this list
     */ 
    public void addAtTail(String that) {
        this.node.addAtTail(that);
    }
    
    /** removes the head out of the list
     * EFFECT: remove the first node in the list
     */
    public void removeFromHead() {
        this.node.removeFromHead();
    }
    
    /** removes the last node in the list
     * EFFECT: remove the last node in the list
     */
    public void removeFromTail() {
        this.node.removeFromTail();
    }
    
    /** find the given node in the list with the given string
     * 
     * @param that the data of the node to search for
     * @return ANode the node that is found
     */
    public ANode find(String that) {
        return this.node.find(that);
    }
    
    /** removes the given node from this list
     * EFFECT: remove the given node from this list
     * 
     * @param that the node to remove from this list
     */
    void removeNode(ANode that) {
        this.node.removeNode(that);
    }
}