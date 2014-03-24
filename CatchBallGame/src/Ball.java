/* Template
Fields:
...this.posn... - Posn
Methods:
...this.ballImage()...   - WorldImage
...this.moveDown()...    - Ball
...this.reachedGoal()... - boolean
...this.moveBall()...    - Ball
 */
/** represents the blal that will be caught by the player
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class Ball implements FWConstants {
	Posn posn;

	Ball(Posn posn) {
		this.posn = posn;
	}

	

	/** produce the image for the ball
	 * 
	 * @return WorldImage the image of the ball
	 */
	public WorldImage ballImage() {
		return new DiskImage(this.posn, 5, new White());
	}

	/** moveDown will move the ball down the screen
	 * 
	 * @return Ball the new ball that is moved
	 */
	public Ball moveDown() {
		return new Ball(new Posn(this.posn.x, this.posn.y + 5));
	}

	/** reachedGoal will tell if the ball has reached the goal
	 * (the bottom of the screen)
     * 
	 * @return boolean true if the ball has reached the bottom
	 */
	public boolean reachedGoal() {
		return this.posn.y >= FWConstants.height;
	}

	/** moveBall will move the ball down the screen, unless it has
	 * reached the goal, which will then start a new ball at the top
	 * 
	 * @return Ball the new ball that is moved 
	 */
	public Ball moveBall() {
		if (this.reachedGoal()) {
			return new Ball(
					new Posn(
							new Random().nextInt(
									FWConstants.width - 20) + 20, -10));
		}
		else {
			return this.moveDown();
		}
	}
}
