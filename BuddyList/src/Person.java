/*
Template
Fields:
... this.username ... - String
... this.buddies ...  - ILoBuddy
Methods:
... this.addBuddy() ...           - void
... this.equalsPerson() ...       - boolean
... this.hasDirectBuddy() ...     - boolean
... this.countCommonBuddies() ... - int
... this.hasDistantBuddy() ...    - boolean
... this.partyCount() ...         - int
Methods for Fields:
... this.buddies.directBuddy() ...   - boolean
... this.buddies.commonBuddies() ... - int
... this.buddies.isInNetwork() ...   - boolean
... this.buddies.buddyCount() ...    - int
 */
/** represents a Person with a user name and a list of buddies
 * 
 * @author Austin Colcord - ajdcolcord
 * @author Greg Dorshimer
 *
 */
class Person {
    String username;
    ILoBuddy buddies;

    Person(String username) {
        this.username = username;
        this.buddies = new MtLoBuddy();
    }

    /** addBuddy adds the given person to this list of buddies
     * EFFECT: adds given buddy to this persons list of buddies
     * 
     * @param buddy the buddy to add to this list
     */
    public void addBuddy(Person buddy) {
        this.buddies = new ConsLoBuddy(buddy, this.buddies);        
    }

    /** returns true if this Person has that as a direct buddy
     * 
     * @param that the person to check
     * @return true if that person is in this buddy list
     */
    public boolean hasDirectBuddy(Person that) {
        return this.buddies.inList(that);
    }

    /** returns the number of people that are direct buddies 
     * of both this and that person
     * 
     * @param that the person to count against this
     * @return int the number of people in common in the lists
     */
    public int countCommonBuddies(Person that) {
        return this.buddies.overlap(that.buddies).length();
    }

    /** will the given person be invited to a party
     * organized by this person?
     * 
     * This is a helper method for hasDistantBuddy
     * 
     * @param that the person to check through the network
     * @param seen the accumulation list of buddies that have been seen
     * @return boolean returns true if that person is in this network
     */
    public boolean hasDistantBuddySub(Person that, ILoBuddy seen) {
        return this.buddies.hasDistantBuddySub(that, seen);
    }

    /** will the given person be invited to a party 
     * organized by this person? (wrapper method)
     * 
     * @param that the person to check for in this network
     * @return true if that person is in this network
     */
    boolean hasDistantBuddy(Person that) {
        return this.hasDistantBuddySub(that,
                new ConsLoBuddy(this, new MtLoBuddy()));
    }
    
    /** has this person been seen in that list already
     * 
     * @param that the list of buddies to keep track of
     * @return ILoBuddy the list of buddies that have been seen
     */
    public ILoBuddy hasBeenSeen(ILoBuddy that) {
        if (that.inList(this)) {
            return that;
        }
        else {
            return new ConsLoBuddy(this, that);
        }
    }
    
    /** has this person been seen in that list already
     * 
     * @param that the
     * @return
     */
    public int countHasBeenSeen(ILoBuddy that) {
        if (that.inList(this)) {
            return that.length();
        }
        else {
            return 1 + that.length();
        }
    }
}