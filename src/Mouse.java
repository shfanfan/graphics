/*
    Mouse class
	Version 2
    Copyright 2004-5 by Mordechai (Moti) Ben-Ari.
     
    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public License
    as published by the Free Software Foundation; either version 2
    of the License, or (at your option) any later version.
    This program is distributed in the hope that it will be useful
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
    02111-1307, USA.
*/
class Mouse
{
	// The feaetures of the mouse
    Circle   face;
    Triangle ear1;
    Triangle ear2;
    Line     whisker1;
    Line     whisker2;
    Text     name;

    // Construct a mouse object
    Mouse()
    {
        face = new Circle(  120, 120,  20,      "black");
        ear1 = new Triangle(100,  90,  10,  20, "black");
        ear2 = new Triangle(140,  90,  10,  20, "black");
        whisker1 = new Line(80, 120,  100, 120, "black");
        whisker2 = new Line(140, 120, 160, 120, "black");
        name = new Text(200, 20, "Mickey Mouse", "red");
    }

    // Change color of mouse to newColor
    void changeColor(String newColor)
    {
        face.changeColor(newColor);
        ear1.changeColor(newColor);
        ear2.changeColor(newColor);
        whisker1.changeColor(newColor);
        whisker2.changeColor(newColor);
    }

    // Move mouse by an amount (dx, dy)
    void move(int dx, int dy)
    {
        face.move(dx, dy);
        ear1.move(dx, dy);
        ear2.move(dx, dy);
        whisker1.move(dx, dy);
        whisker2.move(dx, dy);
    }
    
    // Move mouse to a new position
    void moveTo(int x, int y){
    	face.moveTo(x, y);
    	ear1.moveTo(x, y);
    	ear2.moveTo(x, y);
    	whisker1.moveTo(x, y);
    	whisker2.moveTo(x, y);
    }

    // Move mouse n times by an amount (dx, dy)
    void run(int dx, int dy, int n)
    {
        for (int i = 1; i <= n; i = i + 1)
        {
            move(dx, dy);
            Canvas.wait(250);
        }
    }

    // Move mouse 50 pixels right n times
    void runRight50(int n)
    {
        run(50, 0, n);
        Canvas.wait(250);
    }

    // Move mouse 50 pixels left n times
    void runLeft50(int n)
    {
        run(-50, 0, n);
        Canvas.wait(250);
    }

    // Move mouse 50 pixels right
    void moveRight50()
    {
        move(50, 0);
        Canvas.wait(250);
    }

    // Move mouse 50 pixels left
    void moveLeft50()
    {
        move(-50, 0);
        Canvas.wait(250);
    }

    // Main program for testing
    public static void main(String[] args) {
        Canvas.changeSize(800, 500);
        Canvas.changeLocation(10, 10);
        Mouse mickey = new Mouse();
        mickey.run(25, 15, 6);
        mickey.changeColor("red");
        mickey.name.changeColor("black");
    }
}
