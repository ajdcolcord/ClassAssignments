/* Template
Fields:
...this.length... - int
Methods:
...this.size()... - int
 */
/** to represent a text file that extends AFile
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
class TextFile extends AFile {
    int length;   // in bytes

    TextFile(String name, String owner, int length) {
        super(name, owner);
        this.length = length;
    }

    /** computes the size of this file
     * 
     * @return int the size of this file
     */
    public int size() {
        return this.length;
    }  
}