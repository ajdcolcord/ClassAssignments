/* Template
Fields:
...this.width...  - int
...this.height... - int
Methods:
...this.size()... - int
 */
/** to represent an image file that extends AFile
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
class ImageFile extends AFile {
    int width;   // in pixels
    int height;  // in pixels

    ImageFile(String name, String owner, int width, int height) {
        super(name, owner);
        this.width = width;
        this.height = height;
    }

    /** computes the size of this file
     * 
     * @return int the size of the file
     */
    public int size() {
        return this.width * this.height;
    }
}