/* Template
Fields:
...this.posn... - Posn
Methods:
...this.playerImage()...         - WorldImage
...this.onKeyEvent(String ke)... - Player
*/
/** represents the player that is controlled that will catch the balls
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class Player {
    Posn posn;

    Player(Posn posn) {
        this.posn = posn;
    }



    /** produce the image for the player
     * 
     * @return WorldImage the image of the player
     */
    public WorldImage playerImage() {
        return new RectangleImage(this.posn, 30, 15, new Black());
    }

    /** move the player on the key event (left or right)
     * 
     * @param ke the key event in which direction the player will move
     * @return Player the new player with the changed direction
     */
    public Player onKeyEvent(String ke) {
        if (ke.equals("left")) {
            if (this.posn.x >= 15) {
                return new Player(
                        new Posn((this.posn.x - 10), this.posn.y));
            }
            else {
                return this;
            }
        }
        else if (ke.equals("right")) {
            if (this.posn.x <= (FWConstants.width - 15)) {
                return new Player(
                        new Posn((this.posn.x + 10), this.posn.y));
            }
            else {
                return this;
            }
        }
        else {
            return this;
        }
    }
}


