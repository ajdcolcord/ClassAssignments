/** represents examples for the fields that contain the game
 * 
 * t.checkExpect is a check that is given in the tester library
 * that was provided to us in class. It has the ability to check
 * images as well as the other checks that can be used in standard
 * JUnit testing
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
class ExamplesFields implements FWConstants {
    Player p1 = new Player(new Posn(150, 450));
    Player p2 = new Player(new Posn(20, 10));
    Player p3 = new Player(new Posn(5, 100));
    Player p4 = new Player(new Posn(295, 100));
    
    Ball b1 = new Ball(new Posn(20, 20));
    Ball b2 = new Ball(new Posn(50, 500));
    Ball b3 = new Ball(new Posn(150, 100));
    Ball b4 = new Ball(new Posn(20, 10));
    Ball b5 = new Ball(new Posn(20, 11));
    Ball b6 = new Ball(new Posn(20, 18));
    Ball b7 = new Ball(new Posn(40, 510));
    
    FieldWorld f1 = new FieldWorld(this.p1, this.b1, 0);
    FieldWorld f2 = new FieldWorld(this.p2, this.b3, 0);
    FieldWorld f3 = new FieldWorld(this.p2, this.b4, 0);
    FieldWorld f4 = new FieldWorld(this.p1, this.b2, 0);
    FieldWorld f5 = new FieldWorld(this.p1, this.b1, 10);
    FieldWorld f6 = new FieldWorld(this.p1, this.b1, 11);
    FieldWorld f7 = new FieldWorld(this.p1, this.b7, 0);
    
    
    /////////////////////////////////////////////////////////////////
    //METHODS EXAMPLES

    // ballImage test
    boolean testBallImage(Tester t) {
        return t.checkExpect(this.b1.ballImage(),
                new DiskImage(this.b1.posn, 5, new White()));
    }

    // playerImage test
    boolean testPlayerImage(Tester t) {
        return t.checkExpect(this.p1.playerImage(),
                new RectangleImage(this.p1.posn, 30, 15, new Black()));
    }

    // makeImage test
    boolean testMakeImage(Tester t) {
        return t.checkExpect(this.f1.makeImage(), 
                new OverlayImages(FWConstants.field,
                        new OverlayImages(this.b1.ballImage(),
                                this.p1.playerImage())));
    }

    // moveDown test
    boolean testMoveDown(Tester t) {
        return  t.checkExpect(this.b1.moveDown(), new Ball(new Posn(20, 25))) &&
                t.checkExpect(this.b2.moveDown(), new Ball(new Posn(50, 505)));
    }
    
    // onKeyEvent test
    boolean testOnKeyEvent(Tester t) {
        return t.checkExpect(this.p1.onKeyEvent("left"),
                new Player(new Posn(140, 450))) &&
               t.checkExpect(this.p1.onKeyEvent("right"),
                new Player(new Posn(160, 450))) &&
               t.checkExpect(this.p3.onKeyEvent("left"), this.p3) &&
               t.checkExpect(this.p4.onKeyEvent("right"), this.p4) &&
               t.checkExpect(this.p3.onKeyEvent("up"), this.p3) &&
               t.checkExpect(this.f1.onKeyEvent("up"), this.f1) &&
               t.checkExpect(this.f1.onKeyEvent("left"),
                       new FieldWorld(
                               new Player(new Posn(140, 450)),
                               this.b1, 0));
    }
    
    // reachedGoal test
    boolean testReachedGoal(Tester t) {
        return  t.checkExpect(this.b1.reachedGoal(), false) &&
                t.checkExpect(this.b2.reachedGoal(), true) &&
                t.checkExpect(this.b7.reachedGoal(), true);
    }
    
    // moveBall test
    boolean testMoveBall(Tester t) {
        return  t.checkExpect(this.b1.moveBall(), 
                new Ball(new Posn(20, 25))) &&
                t.checkRange(this.b7.moveBall().posn.x, 0, 500) &&
                t.checkExpect(this.b7.moveBall().posn.y, -10);
        ////////////TEST FOR RANDOM POSN X////////////////
                
    }
    
    // caughtBall test
    boolean testCaughtBall(Tester t) {
        return  t.checkExpect(this.f3.caughtBall(), true) &&
                t.checkExpect(this.f1.caughtBall(), false) &&
                t.checkExpect(this.f2.caughtBall(), false) &&
                t.checkExpect(this.f4.caughtBall(), false);
    }
   
    //onTick test
    boolean testOnTick(Tester t) {
        return t.checkExpect(this.f1.onTick(),
                new FieldWorld(this.f1.player,
                        new Ball(new Posn(this.f1.ball.posn.x, 25)),
                        0)) &&
               t.checkRange(this.f7.onTick().ball.posn.x, 0, 500) &&
               t.checkExpect(this.f7.onTick().ball.posn.y, -10) &&
               t.checkExpect(this.f7.onTick().player, this.f7.player);
    }

    // worldEnds test
    boolean testWorldEnds(Tester t) {
        return t.checkExpect(this.f5.worldEnds(), 
                new WorldEnd(
                        true, new TextImage(
                                new Posn(
                                        FWConstants.width / 2, 
                                        FWConstants.height / 2), 
                                        "Game Over!!!", 30, 3, new Red()))) &&
               t.checkExpect(this.f1.worldEnds(),
                       new WorldEnd(false, this.f1.makeImage())) &&
               t.checkExpect(this.f6.worldEnds(),
                new WorldEnd(
                        true, new TextImage(
                                new Posn(
                                        FWConstants.width / 2, 
                                        FWConstants.height / 2), 
                                        "Game Over!!!", 30, 3, new Red())));

    }

    
    /////////////////////////////////////////////////////////////////
    //RUN ANIMATION
    /** runs the game, requires the bigBang library from Northeastern*/
    boolean runAnimation = this.f1.bigBang(300, 500, 0.03);
}