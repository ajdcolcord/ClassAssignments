/*
Template Image
Methods:
...this.totalImageSize()...   - int
...this.textLength()...  - int
...this.images()...      - String
...this.isMtLoItem()...  - boolean
...this.isimage()...     - boolean
 */
/** define empty List of Items
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
class MtLoItem implements ILoItem {
	MtLoItem() {
		//since this is an empty list, there is no fields or constructor
	}
	
	/** returns the total image size of this item
	 * 
	 * @return int the total image size
	 */
	public int totalImageSize() {
		return 0;
	}
	
	/** return the length of the text contained in this item
	 * 
	 * @return int the length of the text in this item
	 */
	public int textLength() {
		return 0;
	}
	
	/** return the titles of the images of this item
	 * 
	 * @return String the title of the image in this item
	 */
	public String images() {
		return "";
	}
	
	/** tells if this is an empty list of items (MtLoItem)
	 * 
	 * @return boolean true if this is an MtLoItem
	 */
	public boolean isMtLoItem() {
		return true;
	}
	
	/** tell if this item is an image
	 * 
	 * @return boolean if this item is an image
	 */
	public boolean isimage() {
		return false;
	}
}