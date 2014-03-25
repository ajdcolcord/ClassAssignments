import junit.framework.TestCase;

/** represents the JUnit tests for the File classes and methods
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class FileTests extends TestCase {
    AFile text1 = new TextFile("English paper", "Maria", 1234);
    AFile picture = new ImageFile("Beach", "Maria", 400, 200);
    AFile song = new AudioFile("Help", "Pat", 200, 120);
    
    AFile text2 = new TextFile("Homework 3", "Billy", 1555);
    AFile picture2 = new ImageFile("Ocean", "Robert", 1000, 800);
    AFile song2 = new AudioFile("Working", "Mark", 400, 100);

    /** test the method size for the classes that represent files */
    public void testSize() {
          assertEquals(this.text1.size(), 1234);
          assertEquals(this.picture.size(), 80000);
          assertEquals(this.song.size(), 24000);
                
          assertEquals(this.text2.size(), 1555);
          assertEquals(this.picture2.size(), 800000);
          assertEquals(this.song2.size(), 40000);
    }
    
    /** test downloadTime */
    public void testDownloadTime() {
        assertEquals(this.text1.downloadTime(10), 123);
        assertEquals(this.picture.downloadTime(10), 8000);
        assertEquals(this.song.downloadTime(10), 2400);
    }
    
    /** test thisOwner */
    public void testThisOwner() {
        assertEquals(this.text2.thisOwner(), "Billy");
        assertEquals(this.picture2.thisOwner(), "Robert");
        assertEquals(this.song2.thisOwner(), "Mark");
    }
    
    /** test sameOwner */
    public void testSameOwner() {
        assertEquals(this.text1.sameOwner(this.picture), true);
        assertEquals(this.picture2.sameOwner(this.song2), false);
        assertEquals(this.song.sameOwner(this.song2), false);
    } 
}
