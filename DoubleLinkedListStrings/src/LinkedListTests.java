import junit.framework.TestCase;

/** represents the tests for the linked list structure and 
 * it's methods
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class LinkedListTests extends TestCase {
    Sentinel mts;
    Sentinel s1;
    Sentinel s2;
    Sentinel s3;

    Deque mtd;
    Deque d1;
    Deque d2;
    Deque d3;

    Node a;
    Node abc;
    Node bcd;
    Node cde;
    Node def;
    Node first;
    Node second;
    Node third;
    Node fourth;

    /** reset to these states */
    public void reset() {
        this.mts = new Sentinel(null, null);
        this.s1 = new Sentinel(null, null);
        this.s2 = new Sentinel(null, null);
        this.s3 = new Sentinel(null, null);

        this.mtd = new Deque(this.mts);
        this.d1 = new Deque(this.s1);
        this.d2 = new Deque(this.s2);
        this.d3 = new Deque(this.s3);

        this.a = new Node("a", null, null);
        this.abc = new Node("abc", null, null);
        this.bcd = new Node("bcd", null, null);
        this.cde = new Node("cde", null, null);
        this.def = new Node("def", null, null);
        this.first = new Node("first", null, null);
        this.second = new Node("second", null, null);
        this.third = new Node("third", null, null);
        this.fourth = new Node("fourth", null, null);

        //representing an empty list
        this.mts.next = this.mts;
        this.mts.prev = this.mts;
        this.mtd = new Deque(this.mts);

        //representing a list with one item
        this.s1.next = this.a;
        this.s1.prev = this.a;
        this.a.next = this.s1;
        this.a.prev = this.s1;
        this.d1 = new Deque(this.s1);

        //representing the list with abc, bcd, cde, def
        this.s2.next = this.abc;
        this.s2.prev = this.def;
        this.abc.next = this.bcd;
        this.abc.prev = this.s2;
        this.bcd.next = this.cde;
        this.bcd.prev = this.abc;
        this.cde.next = this.def;
        this.cde.prev = this.bcd;
        this.def.next = this.s2;
        this.def.prev = this.cde;
        this.d2 = new Deque(this.s2);

        // representing another list with four other values
        this.s3.next = this.first;
        this.s3.prev = this.fourth;
        this.first.next = this.second;
        this.first.prev = this.s3;
        this.second.next = this.third;
        this.second.prev = this.first;
        this.third.next = this.fourth;
        this.third.prev = this.second;
        this.fourth.next = this.s3;
        this.fourth.prev = this.third;
        this.d3 = new Deque(this.s3);
    }

    /** test the method isSentinel */
    public void testIsSentiel() {
        reset();
        assertTrue(this.mts.isSentinel());
        assertFalse(this.a.isSentinel());
        assertFalse(this.abc.isSentinel());
        assertTrue(this.s1.isSentinel());
    }
    
    /** test size method */
    public void testSize() {
        reset();
        assertEquals(this.mts.size(), 0);
        assertEquals(this.s1.size(), 1);
        assertEquals(this.s2.size(), 4);
        assertEquals(this.a.size(), 1);
        assertEquals(this.abc.size(), 4);
        assertEquals(this.mtd.size(), 0);
        assertEquals(this.d1.size(), 1);
        assertEquals(this.d2.size(), 4);
        assertEquals(this.d3.size(), 4);
    }
    
    /** test addAtHead method */
    public void testAddAtHead() {
        reset();
        this.mts.addAtHead("a");
        assertTrue(this.mts.next.sameNodeData(this.a));
        assertTrue(this.mts.prev.sameNodeData(this.a));
        reset();
        this.mtd.addAtHead("a");
        assertTrue(this.mtd.node.next.sameNodeData(this.a));
        assertTrue(this.mtd.node.prev.sameNodeData(this.a));
        reset();
        this.d2.addAtHead("a");
        assertTrue(this.d2.node.next.sameNodeData(this.a));
        assertTrue(this.d2.node.next.prev.sameNodeData(this.mts));
        assertTrue(this.d2.node.next.next.sameNodeData(this.abc));
        assertTrue(this.d2.node.next.next.prev.sameNodeData(this.a));
        assertFalse(this.d2.node.next.sameNodeData(this.abc));
        assertTrue(this.d2.node.prev.sameNodeData(this.def));
    }  
    
    /** test addAtTail method */
    public void testAddAtTail() {
        reset();
        this.mts.addAtTail("a");
        assertTrue(this.mts.prev.sameNodeData(this.a));
        assertTrue(this.mts.next.sameNodeData(this.a));
        reset();
        this.mtd.addAtTail("a");
        assertTrue(this.mtd.node.prev.sameNodeData(this.a));
        assertTrue(this.mtd.node.next.sameNodeData(this.a));
        reset();
        this.d2.addAtTail("a");
        assertTrue(this.d2.node.prev.sameNodeData(this.a));
        assertTrue(this.d2.node.prev.next.sameNodeData(this.mts));
        assertTrue(this.d2.node.prev.prev.sameNodeData(this.def));
        assertTrue(this.d2.node.prev.prev.next.sameNodeData(this.a));
        assertTrue(this.d2.node.next.sameNodeData(this.abc));
        assertFalse(this.d2.node.prev.sameNodeData(this.def));
    }
    
    /** test removeFromHead method */
    public void testRemoveFromHead() {
        reset();
        this.d1.removeFromHead();
        assertTrue(this.d1.node.next.isSentinel());
        assertTrue(this.d1.node.prev.isSentinel());
        reset();
        this.d2.removeFromHead();
        assertTrue(this.d2.node.next.sameNodeData(this.bcd));
        assertTrue(this.d2.node.prev.sameNodeData(this.def));
        assertTrue(this.d2.node.next.prev.isSentinel());
        assertTrue(this.d2.node.next.next.sameNodeData(this.cde));
        reset();
        this.d3.removeFromHead();
        assertFalse(this.d3.node.next.sameNodeData(this.first));
        assertTrue(this.d3.node.next.sameNodeData(this.second));
        assertTrue(this.d3.node.next.prev.isSentinel());
        assertTrue(this.d3.node.next.next.sameNodeData(this.third));
    }
    
    /** test removeFromTail method */
    public void testRemoveFromTail() {
        reset();
        this.d1.removeFromTail();
        assertTrue(this.d1.node.prev.isSentinel());
        assertTrue(this.d1.node.next.isSentinel());
        reset();
        this.d2.removeFromTail();
        assertTrue(this.d2.node.prev.sameNodeData(this.cde));
        assertTrue(this.d2.node.next.sameNodeData(this.abc));
        assertTrue(this.d2.node.prev.next.isSentinel());
        assertTrue(this.d2.node.prev.prev.sameNodeData(this.bcd));
        reset();
        this.d3.removeFromTail();
        assertFalse(this.d3.node.prev.sameNodeData(this.fourth));
        assertTrue(this.d3.node.prev.sameNodeData(this.third));
        assertTrue(this.d3.node.prev.next.isSentinel());
        assertTrue(this.d3.node.prev.prev.sameNodeData(this.second));
    }
    
    /** test find method */
    public void testFind() {
        reset();
        assertEquals(this.mtd.find("a"), this.mts);
        assertEquals(this.mtd.find(""), this.mts);
        assertEquals(this.d1.find("a"), this.a);
        assertEquals(this.d1.find("b"), this.s1);
        assertEquals(this.d2.find("cde"), this.cde);
        assertEquals(this.d2.find("efg"), this.s2);
        assertEquals(this.d3.find("second"), this.second);
        assertEquals(this.d3.find("fifth"), this.s3);
    }
    
    /** test removeNode method */
    public void testRemoveNode() {
        reset();
        this.d1.removeNode(this.a);
        assertTrue(this.d1.node.next.isSentinel());
        assertTrue(this.d1.node.prev.isSentinel());
        assertTrue(this.d1.node.next.next.isSentinel());
        reset();
        this.d2.removeNode(this.abc);
        assertTrue(this.d2.node.next.sameNodeData(this.bcd));
        assertTrue(this.d2.node.prev.sameNodeData(this.def));
        assertTrue(this.d2.node.next.prev.isSentinel());
        reset();
        this.d2.removeNode(this.cde);
        assertTrue(this.d2.node.next.sameNodeData(this.abc));
        assertTrue(this.d2.node.next.next.next.sameNodeData(this.def));
        assertTrue(this.d2.node.prev.sameNodeData(this.def));
        assertTrue(this.d2.node.prev.prev.sameNodeData(this.bcd));
        assertTrue(this.d2.node.next.next.next.prev.sameNodeData(this.bcd));
        this.d2.removeNode(this.abc);
        assertTrue(this.d2.node.next.sameNodeData(this.bcd));
        assertTrue(this.d2.node.next.next.sameNodeData(this.def));
        assertTrue(this.d2.node.prev.sameNodeData(this.def));
        this.d2.removeNode(this.s2);
        assertTrue(this.d2.node.next.sameNodeData(this.bcd));
        assertTrue(this.d2.node.next.next.sameNodeData(this.def));
        assertTrue(this.d2.node.prev.sameNodeData(this.def));
        this.d3.removeNode(this.fourth);
        this.d3.removeNode(this.third);
        this.d3.removeNode(this.first);
        assertTrue(this.d3.node.next.sameNodeData(this.second));
        assertTrue(this.d3.node.prev.sameNodeData(this.second));
    }
}
