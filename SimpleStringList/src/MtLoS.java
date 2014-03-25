/* Template
Methods:
...this.combine()...                - String
...this.compareAlph(String that)... - boolean
...this.firstList()...              - String
...this.restList()...               - ILoS
...this.isSorted()...               - boolean
 */
/** to represent an empty list of Strings that extends ILoS
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
class MtLoS implements ILoS {
    MtLoS() { // no items in constructor since this is an empty list 
    }


    /** combine all Strings in this list into one
     * 
     * @return String the combined strings
     */
    public String combine() {
        return "";
    }  

    /** compares two items to see if they are in alphabetical order
     * 
     * @param that the string to compare to
     * @return boolean true if this string comes before that
     */
    public boolean compareAlph(String that) {
        return true;
    }

    /** return the first of the list
     * 
     * @return String the first string in the list
     */
    public String firstList() {
        return "";
    }

    /** return the rest of the list
     * 
     * @return ILoS the rest of the list
     */
    public ILoS restList() {
        return this;
    }

    /** tells if the list is sorted
     * 
     * @return boolean true if the list is sorted alphabetically
     */
    public boolean isSorted() {
        return true;
    }

}