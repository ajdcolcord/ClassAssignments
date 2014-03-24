/* Template
Fields:
...this.player... - Player
...this.ball...   - Ball
...this.score... - int
Methods:
...this.makeImage()...           - WorldImage
...this.caughtBall()...          - boolean 
...this.onTick()...              - FieldWorld
...this.onKeyEvent(String ke)... - FieldWorld
...this.worldEnds()...           - WorldEnd
Methods for Fields:
...this.ball.ballImage()...      - WorldImage
...this.player.playerImage()...  - WorldImage
...this.ball.moveBall()...       - Ball
...this.player.onKeyEvent(ke)... - Player
*/
/** represents the world that holds all of the players and balls
 * Extends the World class (provided to us in class)
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
class FieldWorld extends World implements FWConstants {
    Player player;
    Ball ball;
    int score;
    
    FieldWorld(Player player, Ball ball, int score) {
        this.player = player;
        this.ball = ball;
        this.score = score;
    }
    

    
    /** produce the images for the world, including the field, 
     * ball, and player
     * 
     * @return WorldImage the current image of the world
     */
    public WorldImage makeImage() {
        return new OverlayImages(FWConstants.field, 
                new OverlayImages(this.ball.ballImage(), 
                        this.player.playerImage()));
    }   

    /** caughtBall will tell if this ball has been caught by a player
     * 
     * @return boolean if the ball has been caught by the player
     */
    public boolean caughtBall() {
        return (((player.posn.x - 15) <= ball.posn.x) && 
                (ball.posn.x <= (player.posn.x + 15))) &&
                ((player.posn.y - 12.5) <= ball.posn.y) &&
                ((player.posn.y + 7.5) >= ball.posn.y);
    }
    
    /** onTick will move the ball down every tick, and if
     * the ball is caught by the player, the score will increase by
     * 1 point, and a new ball will be set at the top again
     * 
     * @return FieldWorld the new FieldWorld after the tick
     */
    public FieldWorld onTick() {
        if (this.caughtBall()) {
            return new FieldWorld(
                    this.player, 
                    new Ball(new Posn(
                            new Random().nextInt(
                                    FWConstants.width - 20)
                                    + 20, -10)), this.score + 1);
        }
        else {
            return new FieldWorld(
                    this.player, this.ball.moveBall(), this.score);
        }
    }
    
    /** onKeyEvent allows the player to move the player on the ground
     * 
     * @param ke the key event on which the player will be moved
     * @return FieldWorld the new FieldWorld after the player is moved
     */
    public FieldWorld onKeyEvent(String ke) {
        return new FieldWorld(
                this.player.onKeyEvent(ke), this.ball, this.score);
    }
    
    /** produce the worldend, ends the game if the score reaches 10,
     * otherwise, continues the game
     * 
     * @return WorldEnd the worldend state of the game
     */
    public WorldEnd worldEnds() {
        if (this.score >= 10) {
            return new WorldEnd(true, 
                    new TextImage(
                            new Posn(FWConstants.width / 2, 
                                    FWConstants.height / 2), 
                                    "Game Over!!!", 30, 3, new Red()));
        }
        else {
            return new WorldEnd(false, this.makeImage()); 
        }
    }

}