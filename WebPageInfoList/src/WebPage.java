//////////////////////////////////////////////////////////////////////////////
//CLASS DIAGRAM
/*
                    +----------------------+
                    |          WP          |<-------------------+
                    +----------------------+                    |
                    | String      url      |                    |
                    | String      title    |                    |
                 +--| IloI        itmes    |<---------+         |
                 |  +----------------------+          |         |
                 |  | int      textlength()|          |         |
                 |  | int  totalImageSize()|          |         |
                 |  | String       images()|          |         |
                    | boolean     isimage()|          |         |
                 |  +----------------------+          |         |
                 |                                    |         |
                 v                                    |         |
           +---------------------+                    |         |
           |      ILOItem        |                    |         |
           +---------------------+                    |         |
           +---------------------+                    |         |
           |int  totalImageSize()|                    |         |
           |int      textLength()|                    |         |
           |String       images()|                    |         |
           |boolean  isMtLoItem()|                    |         |
           |boolean     isimage()|                    |         |
           +---------------------+                    |         |
                 |                                    |         |
                 +------------------+                 |         |
                 v                  v                 |         |
  +---------------------+    +---------------------+  |         |
  |      ConsLoI        |    |       MtLoI         |  |         |
  +---------------------+    +---------------------+  |         |
+-| Item    item        |    +---------------------+  |         |
| | IloI    iloi        |-+  | int     textlength()|  |         |
| +---------------------+ |  | int totalImageSize()|  |         |
| | int  textlength()   | |  | String      images()|  |         |
| | int totalImageSize()| |  | boolean    isimage()|  |         |
| | String   images()   | |  | boolean isMtLoItem()|  |         |
| | boolean isimage()   | |  +---------------------+  |         |
| | boolean isMtLoItem()| |                           |         |
| +---------------------+ |                           |         |
|                         +---------------------------+         |
+------------+                                                  |
             |                                                  |
             v                                                  |
  +-----------------------+                                     |
  |        Item           |                                     |
  +-----------------------+                                     |
  |-----------------------+                                     |
  |int    totalImageSize()|                                     |
  |int        textLength()|                                     |
  |String         images()|                                     |
  |boolean       isimage()|                                     |
  +-----------------------|                                     |
             |                                                  |
             |                                                  |
          +-+------------------+--------------------+            |
          v                    v                    v             |
+---------------------+ +------------------+ +------------------+ |
|       text          | |      image       | |       link       | |
+---------------------+ +------------------+ +------------------+ |
| String  contents    | | String  filename | | string  name     | |
+---------------------+ | int     size     | | WP      page     |-+
| int  textlength()   | | String  filetype | +------------------+
| int totalImageSize()| +------------------+ | int  textlength()|
| String   images()   | | int  textlength()| | int   imageSize()|
| boolean isimage()   | | int   imageSize()| | String   images()|
+---------------------+ | String   images()| | boolean isimage()|
                        | boolean isimage()| +------------------+
                        +------------------+
 */
//////////////////////////////////////////////////////////////////////////////
//WEBPAGE
/*
TEMPLATE
Fields:
... this.url...     - String
... this.title...   - String
... this.items...   - ILoItem

Methods:
...this.totalImageSize()...   - int
...this.textLength()...       - int
...this.images()...           - String
...this.isimage()...          - boolean
Methods for Fields
...this.items.totalImageSize()... - ILoItem
...this.items.textLength()...     - ILoItem
...this.items.images()...         - ILoItem
 */
/** represents the definition for WebPage
 *  that contains a url, title, and a list of items
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class WebPage {
    String url;
    String title;
    ILoItem items;
    
    WebPage(String url, String title, ILoItem items) {
        this.url = url;
        this.title = title;
        this.items = items;
    }
    
    /**textLength() computes the total length of all text in this WebPage
     * 
     * @return int the lenght of the text
     */
    public int textLength() {
        return  this.title.length() +
                this.items.textLength();
    }
    
    /** totalImageSize() computes total size of all images
     * in this WebPage
     * @return int the total size of the images
     */
    public int totalImageSize() {
        return this.items.totalImageSize();
    }
    
    /** images() makes a string of all of the names of all
     * of the images in the WebPage
     * 
     * @return String the string of all the names
     */
    public String images() {
        return this.items.images();
    }
    
    /** isimage() tells if there are images in the WebPage
     * 
     * @return boolean true if there are images in this WebPage
     */
    boolean isimage() {
        return this.items.isimage();
    }
}