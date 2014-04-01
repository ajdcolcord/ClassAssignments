/* Template
Methods:
... this.isSentinel() ...     - boolean
... this.size() ...           - int
... this.addAtHead() ...      - void
... this.addAtTail() ...      - void
... this.removeFromHead() ... - void
... this.removeFromTail() ... - void
... this.find() ...           - ANode
... this.removeNode() ...     - void
Methods for Fields:
... this.next.isSentinel() ... - boolean
... this.next.size() ...       - int
... this.next.find() ...       - ANode
... this.next.removeNode() ... - void
*/
/** provides the link to the head of the list and to the tail of the list.
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class Sentinel extends ANode {
    
    Sentinel(ANode next, ANode previous) {
        super("", next, previous);
    }
    
    /** tell that this is a sentinel
     * 
     * @return boolean if this is a sentinel
     */
    public boolean isSentinel() {
        return true;
    }
    
    /** count how many nodes are in this list
     * 
     * @return int the size of this list
     */
    public int size() {
        if (this.next.isSentinel()) {
            return 0;
        }
        else {
            return this.next.size();
        }
    }
    
    /** adds a new head to this list
     * EFFECT: add a new head in the list
     * 
     * @param that the data for the new node to be added
     */
    public void addAtHead(String that) {
        Node firstNode = new Node(that, this.next, this);
        this.next.prev = firstNode;
        this.next = firstNode;
    }
    
    /** adds a new tail to the list with the given string
     * EFFECT: add a new tail in the list
     * 
     * @param that the data to be added as a node at the tail
     */
    public void addAtTail(String that) {
        Node lastNode = new Node(that, this, this.prev);
        this.prev.next = lastNode;
        this.prev = lastNode;
    }
    
    /** removes the head node from the list 
     * EFFECT: remove the first node in the list, setting the next
     *          node as the head
     */
    public void removeFromHead() {
        if (this.next.isSentinel()) {
            throw new RuntimeException("No items in this list.");
        }
        else {
            this.next.next.prev = this;
            this.next = this.next.next;
        }
    }
    
    /** removes the tail node from the list
     * EFFECT: remove the first node in the list
     */
    public void removeFromTail() {
        if (this.prev.isSentinel()) {
            throw new RuntimeException("No items in this list.");
        }
        else {
            this.prev.prev.next = this;
            this.prev = this.prev.prev;
        }
    }
    
    /** find the node in this list with the same data as that
     * 
     * @param that the data for the node to find
     * @return ANode the node that is found
     */
    public ANode find(String that) {
        if (this.next.isSentinel()) {
            return this;
        }
        else {
            return this.next.find(that);
        }
    }
    
    /** remove the node from this list
     * EFFECT: removes the given node from the list
     * 
     * @param that the node to remove
     */
    public void removeNode(ANode that) {
        if (this.next.sameNodeData(that)) {
            this.removeFromHead();
        }
        else {
            this.next.removeNode(that);
        }
    }
}