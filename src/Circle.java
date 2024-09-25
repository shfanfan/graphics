/*
    Circle class
	Version 2.0
    Copyright 2004-5 by Mordechai (Moti) Ben-Ari and Michael Kolling.
     
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
public class Circle {
    private double radius;               // Radius of the circle
    private double xCenter, yCenter;     // The x,y coordinates of the center  
    private String color;    		  // The color of the circle

    // Create a new circle 
    public Circle(int xCenter, int yCenter, int radius, String color) {
        this.radius  = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.color     = color;
        draw();
    }

	// Move the circle to a new position.
    public void moveTo(int newX, int newY) {
		erase();
        xCenter = newX;
        yCenter = newY;
		draw();
    }

    // Move the circle by an amount.
    public void move(int deltaX, int deltaY) {
		erase();
        xCenter = xCenter + deltaX;
        yCenter = yCenter + deltaY;
		draw();
    }

    // Change the radius.
    public void changeRadius(int newRadius) {
		erase();
        radius = newRadius;
		draw();
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    public void changeColor(String newColor) {
		erase();
        color = newColor;
		draw();
    }

    // Draw the circle with current specifications on screen.
    private void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        canvas.fill(new java.awt.geom.Ellipse2D.Double(
            xCenter - radius, yCenter - radius, 2*radius, 2*radius));
    }

    // Erase the circle on screen.
    private void erase() {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(new java.awt.geom.Ellipse2D.Double(
            xCenter - radius, yCenter - radius, 2*radius, 2*radius));
    }
}
