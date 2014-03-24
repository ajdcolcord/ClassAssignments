//CLASS DIAGRAM
/*

               +-------+
               | World |
               +-------+
                   ^
                   |
      +-------------------------+
      |       FieldWorld        |-------+
      +-------------------------+       |
 +----| Player           player |       |
 | +--| Ball             ball   |       |
 | |  | int              score  |       |
 | |  +-------------------------+       |
 | |  | WorldImage   makeImage()|       |
 | |  | boolean     caughtBall()|       |
 | |  | FieldWorld      onTick()|       |
 | |  | FieldWorld  onKeyEvent()|       |
 | |  | WorldEnd     worldEnds()|       |
 | |  +-------------------------+       |      +-------------------+
 | |                                    +----->|    FWConstants    |
 | |                                    |      +-------------------+
 | |                                    |
 | |  +---------------------------+     |
 | +->|           Ball            |-----+
 |    +---------------------------+     |
 |    | Posn                 posn |     |
 |    +---------------------------+     |
 |    | WorldImage    ballImage() |     |
 |    | Ball           moveDown() |     |
 |    | boolean     reachedGoal() |     |
 |    | Ball           moveBall() |     |
 |    +---------------------------+     |
 |                                      |
 |    +---------------------------+     |
 +--->|         Player            |-----+
      +---------------------------+
      | Posn                 posn |
      +---------------------------+
      | WorldImage  playerImage() |
      | Player       onKeyEvent() |
      +---------------------------+


*/


/** represents the constants that are used in the FieldWorld
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public interface FWConstants {

	/** width of the field */
    public int width = 300;

    /** height of the field */
    public int height = 500;

    /** color of the field */
    public IColor fieldColor = new Green();

    /** random number generator */
    public Random rand = new Random();

    /** background image of the field */
    public WorldImage field = 
            new RectangleImage(
                    new Posn(width / 2, height / 2), width, height, fieldColor);
    
}
