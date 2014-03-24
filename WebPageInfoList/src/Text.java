/*
TEMPLATE
Fields:
... this.contents... - String
Methods:
...this.totalimageSize()...        - int
...this.textLength()...       - int
...this.images()...           - String
...this.isimage()...          - boolean
Methods for Fields
...this.contents.length()...     - Text
 */

/** definition for Text, which contains its contents that implements
 * the methods contained in Item
 * @author Austin Colcord - ajdcolcord
 *
 */
public class Text implements Item {
    String contents;
    
    Text(String contents) {
        this.contents = contents;
    }
    
    /** finds the total image size of the ILoItem
     * 
     * @return int the total image size
     */
    public int totalImageSize() {
        return 0;
    }
    
    /** compute the length of the text
	 * 
	 * @return int the length of the text
	 */
    public int textLength() {
        return this.contents.length();
    }
    
    /** return the filename and filetype of the image
     * 
     * @return String the filename + filetype
     */
    public String images() {
        return "";
    }
    
    /** check to see if the item is an image
     * 
     * @return boolean true if it is an image
     */
    public boolean isimage() {
        return false;
    }
}