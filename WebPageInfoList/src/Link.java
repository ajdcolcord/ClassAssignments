/*
Template Link
Fields:
... this.name...       - String
... this.page...       - WP

Methods:
...this.totalImageSize()...   - int
...this.textLength()...  - int
...this.images()...      - String
...this.isimage()...     - boolean

Methods for Fields
...this.page.totalImageSize()...  - WP
...this.page.images()...          - WP
...this.name.length()...          - String
 */

/** represents a Link, which contains its name, and
 * a WebPage that it directs to
 * 
 * @author Austin Colcord - ajdcolcord
 */
class Link implements Item {
    String name;
    WebPage page;
    
    Link(String name, WebPage page) {
        this.name = name;
        this.page = page;
    }
    
    /** finds the total image size of the ILoItem
     * 
     * @return int the image size
     */
    public int totalImageSize() {
        return this.page.totalImageSize();
    }
    
    /** finds the total length of the web page name
     * 
     * @return int the lenght of the name
     */
    public int textLength() {
        return this.name.length() + this.page.textLength();
    }
    
    /** produces one String that contains names of all images
     * in contained in the page
     * 
     * @return String the name of all images contained
     */
    public String images() {
        return this.page.images();
    }
    
   /** tells if this is an image
    * 
    * @return boolean true if this is an image
    */
    public boolean isimage() {
        return false;
    }
}