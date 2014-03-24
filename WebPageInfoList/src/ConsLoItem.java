/*
Template Image
Fields:
... this.item...   - Item
... this.iloi...   - ILoItem

Methods:
...this.totalImageSize()...   - int
...this.textLength()...  - int
...this.isMtLoItem()...  - boolean
...this.images()...      - String
...this.isimage()...     - boolean

Methods for Fields
...this.item.textlength()...  - Image
...this.item.totalImageSize()...   - Image
...this.iloi.textlength()...  - ILoItem
...this.iloi.totalImageSize()...   - ILoItem
...this.item.isMtLoItem()...  - ILoItem
 */
/** represents the non-empty list of items
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class ConsLoItem implements ILoItem {
    Item item;
    ILoItem iloi;
    
    ConsLoItem(Item item, ILoItem iloi) {
        this.item = item;
        this.iloi = iloi;
    }
    
    /** return the total size of the images contained in this list
     * 
     * @return int the total image sizes
     */
    public int totalImageSize() {
        return this.item.totalImageSize() + this.iloi.totalImageSize();
    }
    
    /** return the lenght of all of the text in this list
     * 
     * @return int the text length contained in this list
     */
    public int textLength() {
        return this.item.textLength() + this.iloi.textLength();
    }
    
    /** return the titles of all of the images in this list
     * 
     * @return String all of the image titles
     */
    public String images() {
        if (this.iloi.isMtLoItem()) {
            return this.item.images();
        } 
        else if (!(this.item.isimage())) { 
            return this.iloi.images();
        }
        else {
            return this.item.images() + ", " + this.iloi.images();
        }
    }
    
    
    /** tell if this is an empty list of items
     * 
     * @return boolean true if this is an empty list of items
     */
    public boolean isMtLoItem() {
        return false;
    }
    
    /** tell if there is an image contained in this list
     * 
     * @return boolean if there is an image in this list
     */
    public boolean isimage() {
        return this.item.isimage() || this.iloi.isimage();
    }
}