CatchBallGame
=================

This is a very simple game in which the user attempts to catch the ball before it hits the bottom of the screen. 

This uses a tester library that was provided to us in class, while also using a WorldImages class that contains simple images such as circles, disks, squares, triangles, etc. Both the tester library and WorldImages files have not been included.


HOW TO PLAY THE GAME
-----------------

The game is simple. You control the black rectangle 
(the goalie) on the bottom of the screen. You can
move either left or right using the arrow keys (you
can hold down the keys), but you cannot move up or 
down. There is a white ball (soccer ball) starting
at the top of the Field, and it will steadily move
toward the bottom of the Field (the goal).

The point of the game is to block the balls from
going into the goal (or hitting the bottom edge of
the field), by moving right and left to ÔcatchÕ
the balls one at a time. If you miss a ball, there
is no penalty, however, the only way to win the
game is to catch 10 individual balls. 

After you have caught ten balls, the screen will
display ÒGame Over!!!Ó, and the game will be finished.



RESPONSIBILITIES OF EACH CLASS
-----------------

Ball
-----------------
The Ball class has the responsibility of not only holding the 
coordinates for each ball in the game, but also holding methods 
that apply specifically to the ball itself. 

	-ballImage is a method that is used to give the image for 
	the balls in the game
	
	-moveDown is a method that will move the ball down the 
	screen at 5 pixels per every tick of the game, but leaving 
	the x constant (since the ball does not move right or left)
	
	-reachedGoal is a method that tells if the ball has reached
	the bottom of the field, or the ÔGoalÕ, returning true or false.
	
	-moveBall is the method that incorporates both of the moveDown and
	reachedGoal methods, deciding that if the ball has reached the 
	bottom of the field, start a new ball at the top of the field at
	a random x position (to create variety in where the balls are 
	coming from). If it hasnÕt reached the goal yet, it will continue
	to move the ball down.



Player
-----------------
The Player class has the responsibility of not only holding the
coordinates for the player in the game, but also holding the methods
that apply specifically to the player itself.

	-playerImage is a method that is used to give the image for 
	the player in the game
	
	-onKeyEvent is a method that is used to recognize if a ÔleftÕ
	or ÔrightÕ key is pressed. If a left key is pressed, it says 
	to make a new player at a new position to the left, where if 
	a right key is pressed, it will do the opposite.



FieldWorld
-----------------
The FieldWorld class holds the keys that make the game function. 
It contains the player and the current ball, and also a score 
counter. FieldWorld extends the abstract class World, so that all
of the methods created by World can be used in this game. Not only
does it do this, but it also holds the methods that are used by the game.
	
	-makeImage makes the image for this world, so that no matter 
	what position the player or the ball is at, it will make the 
	image for those accordingly.
	
	-caughtBall is a method that determines if the current ball 
	in the world is caught by the player in the world.
	
	-onTick is a method that is used to decide what happens on 
	every tick that the world goes on. In this method, it decides 
	that if a ball is caught by a player, it produces a new ball 
	in the world at the top of the screen at a random x position, 
	and also adds 1 point to the score of the FieldWorld.
	
	-onKeyEvent is the method that calls the actions that are 
	used by the onKeyEvent method in the Player class, passing 
	itÕs actions to the current world.
	
	-worldEnds is the method that decides if the game has ended 
	or not. It asks if the score is at least 10 points (giving
	possibility to be greater than 10 for testing purposes), and 
	if it has, it returns the message ÒGame Over!!!Ó on the canvas.




FWConstants (FieldWorldConstants)
-----------------
	The FWConstants interface holds all of the constants that are used 
	throughout the game. Since the height, width, field color, random
	number, and the image of the field itself are constant throughout
	the game, I decided to implement these all into one interface, 
	that could be used for various methods in the rest of the game. 
	This interface isnÕt necessarily needed, but it does make the code 
	cleaner throughout the game.



