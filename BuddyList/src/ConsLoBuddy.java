/*
Template
Fields:
... this.first ... - Person
... this.rest ...  - ILoBuddy
Methods:
... this.directBuddy() ...   - boolean
... this.isEmpty() ...       - boolean
... this.isInList() ...      - boolean
... this.commonBuddies() ... - int
... this.isInNetwork() ...   - boolean
... this.buddyCount() ...    - int
Methods for Fields:
... this.rest.directBuddy() ...         - boolean
... this.rest.isInList() ...            - boolean
... this.rest.commonBuddies() ...       - int
... this.first.buddies.isInList() ...   - boolean
... this.rest.isInList() ...            - boolean
... this.first.buddies.buddyCount() ... - int
... this.rest.buddyCount() ...          - int
 */
/** represents the non-empty list of buddies
 * 
 * @author Austin Colcord - ajdcolcord
 * @author Greg Dorshimer
 *
 */
public class ConsLoBuddy implements ILoBuddy {
    Person first;
    ILoBuddy rest;

    ConsLoBuddy(Person first, ILoBuddy rest) {
        this.first = first;
        this.rest = rest;
    }

    /** check to see if that person is in this list
     * 
     * @param that the person to check for
     * @return boolean if that person is in this list
     */
    public boolean inList(Person that) {
        return this.first.equals(that) ||
                this.rest.inList(that);
    }

    /** check to see if this list is empty
     * 
     * @return boolean true if this list is empty
     */
    public boolean isEmpty() {
        return false;
    }

    /** return a new list of buddies of the buddies in that list and this
     * 
     * @param that the other list of buddies
     * @return ILoBuddy the other list of buddies
     */
    public ILoBuddy overlap(ILoBuddy that) {
        if (that.isEmpty()) {
            return that;
        }
        else if (that.inList(this.first)) {
            return new ConsLoBuddy(this.first, this.rest.overlap(that));
        }
        else {
            return this.rest.overlap(that);
        }
    }

    /** return the length of this list
     * 
     * @return int the length of this list
     */
    public int length() {
        return 1 + this.rest.length();
    }

    /** append that list of buddies to this list of buddies
     * 
     * @param that the other list of buddies
     * @return ILoBuddy the appended list of buddies
     */
    public ILoBuddy append(ILoBuddy that) {
        return new ConsLoBuddy(this.first, this.rest.append(that));
    }

    /** check to see if that person is in this network of buddies
     * 
     * @param that the person to check for in this network
     * @param seen the list of buddies that have been seen
     * @return boolean true if that person is in this network
     */
    public boolean hasDistantBuddySub(Person that, ILoBuddy seen) {
        if (seen.inList(this.first)) {
            return this.rest.hasDistantBuddySub(that, seen);
        }        
        if (this.first.equals(that)) {
            return true;
        }
        else {
            seen = new ConsLoBuddy(this.first, seen);
            return this.first.buddies.hasDistantBuddySub(that, seen) ||
                    this.rest.hasDistantBuddySub(that, seen);
        }
    }
}





