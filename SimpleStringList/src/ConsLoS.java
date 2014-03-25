/*
TEMPLATE
FIELDS:
...this.first...  - String
...this.rest...   - ILoS

METHODS
...this.combine()...                - String
...this.compareAlph(String that)... - boolean
...this.firstList()...              - String
...this.restList()...               - ILoS
...this.isSorted()...               - boolean

METHODS FOR FIELDS
...this.first.concat(String) ...       - String
...this.first.compareTo(String) ...    - int
...this.rest.combine() ...             - String
...this.first.toLowerCase()...         - String
...this.rest.isSorted()...             - boolean
...this.rest.firstList()...            - String

 */
/** to represent a nonempty list of Strings that extends ILoS
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
class ConsLoS implements ILoS {
    String first;
    ILoS rest;

    ConsLoS(String first, ILoS rest) {
        this.first = first;
        this.rest = rest;  
    }

    /** combine all Strings in this list into one
     * 
     * @return String the combined string of all strings in this list
     */
    public String combine() {
        return this.first.concat(this.rest.combine());
    }  

    /** compares two items to see if they are in alphabetical order
     * 
     * @param that the other string to compare with this
     * @return boolean if this string comes before that string
     */
    public boolean compareAlph(String that) {
        if (that.equals("")) {
            return true;
        }
        else {
            return (this.first.toLowerCase().compareTo(that.toLowerCase()) 
                    <= 0);
        }
    }

    /** tells what the first of the list is
     * 
     * @return String the first string in this list
     */
    public String firstList() {
        return this.first;
    }

    /** tells what the rest of the list is
     * 
     * @return ILoS the rest of the list
     */
    public ILoS restList() {
        return this.rest;
    }

    /** tells if the list is sorted
     * 
     * @return boolean true if the list is sorted
     */
    public boolean isSorted() {
        if (this.compareAlph(this.rest.firstList())) {
            return (this.rest.isSorted());
        }
        else {
            return false;
        }
    }



}