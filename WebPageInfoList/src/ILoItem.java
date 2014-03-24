/** represents the interface for a list of items
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public interface ILoItem {

	/** calculates the total image size of the item
	 * 
	 * @return int the total image size
	 */
	public int totalImageSize();
	
	/** returns the length of the text contained in the item
	 * 
	 * @return int the length of the text
	 */
    public int textLength();
    
    /** return the titles of the images 
     * 
     * @return String the image titles
     */
    public String images();
    
    /** tell if the list is an empty list of items
     * 
     * @return boolean if an MtLoItem
     */
    public boolean isMtLoItem();
    
    /** tell if the item is an image
     * 
     * @return true if the item is an image
     */
    public boolean isimage();
}
