/* CLASS DIAGRAM

        +-----------+
        |  ILoBuddy |
        +-----------+
              ^
              |
        +-----+-----+
        |           |
+-----------+   +--------------------+
| MTLoBuddy |   |     ConsLoBuddy    |
+-----------+   +--------------------+
                |  Person   first    |--+
                |  ILoBuddy rest     |  |
                +--------------------+  |
                                        |
                                        V
                                 +------------------+
                                 |   Person         |
                                 +------------------+
                                 | String  username |
                                 | ILoBuddy buddies |
                                 +------------------+


*/
/** represents a list of Person's buddies
 * 
 * @author Austin Colcord - ajdcolcord
 * @author Greg Dorshimer
 *
 */
public interface ILoBuddy {
    
    /** determines if given person is in this list of buddies
     * 
     * @param that the person to check
     * @return true if that person is in this list
     */
    public boolean inList(Person that);
    
    /** determines if this is empty
     * 
     * @return true if this is empty
     */
    public boolean isEmpty();
    
    /** returns a list of the buddies that
     * this list and given list have in common
     * 
     * @param that the list to check against this
     * @return ILoBuddy the list of buddies that overlap
     */
    public ILoBuddy overlap(ILoBuddy that);
    
    /** returns length of this list
     * 
     * @return int the length of this list
     */
    public int length();
    
    /** append this list and given list
     * 
     * @param that the list to append to this
     * @return ILoBuddy the two lists combined
     */
    public ILoBuddy append(ILoBuddy that);
    
    /** checks to see if that person is in this network
     * 
     * @param that the person to check for in this network
     * @param seen the list of buddies that have been seen so far
     * @return boolean true if that person is in this network
     */
    public boolean hasDistantBuddySub(Person that, ILoBuddy seen);
}