/*
Template
Methods:
... this.directBuddy() ...   - boolean
... this.isEmpty() ...       - boolean
... this.isInList() ...      - boolean
... this.commonBuddies() ... - int
... this.isInNetwork() ...   - boolean
... this.buddyCount() ...    - int
 */
/** represents an empty list of Person's buddies
 * 
 * @author Austin Colcord - ajdcolcord
 * @author Greg Dorshimer
 *
 */
public class MtLoBuddy implements ILoBuddy {
    
    MtLoBuddy() { }

    /** check to see if that person is in this list
     * 
     * @param that the person to check for
     * @reutrn boolean true if that person is in this list
     */
    public boolean inList(Person that) {
        return false;
    }
    
    /** check to see if this list is empty
     * 
     * @return boolean true if this list is empty
     */
    public boolean isEmpty() {
        return true;
    }

    /** return a new ILoBuddy of that list's overlapping buddies of this list
     * 
     * @param that the other list to check with
     * @return ILoBuddy the two overlapping buddy lists in a new list
     */
    public ILoBuddy overlap(ILoBuddy that) {
        return this;
    }

    /** return the lenght of this list
     * 
     * @return int the length of this list
     */
    public int length() {
        return 0;
    }

    /** append that list of buddies to this list of buddies
     * 
     * @param that the other list to append to this
     * @return ILoBuddy the new list of buddies with all buddies combined
     */
    public ILoBuddy append(ILoBuddy that) {
        return that;
    }

    /** check to see if that person is in this network of buddies
     * 
     * @param that the person to check for
     * @param seen the ILoBuddy of buddies that have been seen
     * @return boolean if that person is in this network
     */
    public boolean hasDistantBuddySub(Person that, ILoBuddy seen) {
        return false;
    }
}

