/*
TEMPLATE
Fields:
... this.filename...   - String
... this.size...       - int
... this.filetype...   - String

Methods:
...this.totalImageSize()...   - int
...this.textLength()...  - int
...this.images()...      - String
...this.isimage()...     - boolean

Methods for Fields
...this.filename.length()...    - Image
...this.filetype.length()...    - Image
 */
/** represents an Image, which contains a file-name,
 * size, and file-type that is contained in a WebPage
 */
class Image implements Item {
    String filename;
    int size;
    String filetype;
    
    Image(String filename, int size, String filetype) {
        this.filename = filename;
        this.size = size;
        this.filetype = filetype;
    }
    
    /** finds the total image size of the ILoItem
     * 
     * @return int the total size 
     */
    public int totalImageSize() {
        return this.size;
    }
    
    /** finds the total length of the filename and filetype
     * 
     * @return int the length of the text
     */
    public int textLength() {
        return this.filename.length() + this.filetype.length();
    }
    
    /** finds the filename of the image
     * 
     * @return String the filename + filetype
     */
    public String images() {
        return this.filename + "." + this.filetype;
    }
    
    /** tells that this is an image or not
     * 
     * @return boolean true if this is an image
     */
    public boolean isimage() {
        return true;
    }
}