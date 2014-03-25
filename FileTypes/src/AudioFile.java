/* Template
Fields:
...this.speed...  - int
...this.length... - int
Methods:
...this.size()... - int
 */
/** to represent an audio file that extends AFile
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
class AudioFile extends AFile {
    int speed;   // in bytes per second
    int length;  // in seconds of recording time

    AudioFile(String name, String owner, int speed, int length) {
        super(name, owner);
        this.speed = speed;
        this.length = length;
    }

    /** computes the size of this file
     * 
     * @return int the size of the file
     */
    public int size() {
        return this.speed * this.length;
    }  
}