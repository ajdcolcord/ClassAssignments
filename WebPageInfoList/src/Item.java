/** represents the interface for an Item of any time that will be
 * contained in a WebPage
 * @author Austin Colcord - ajdcolcord
 *
 */
public interface Item {
	
	/** compute the total size of the image
	 * 
	 * @return int the size of the image
	 */
	public int totalImageSize();
	
	/** compute the length of the text
	 * 
	 * @return int the length of the text
	 */
	public int textLength();
    
    /** return the filename and filetype of the image
     * 
     * @return String the filename + filetype
     */
	public String images();
    
    /** check to see if the item is an image
     * 
     * @return boolean true if it is an image
     */
	public boolean isimage();
}
