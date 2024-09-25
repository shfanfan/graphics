/*
    Square class
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
public class Square {
    private int side;        // The side of the square
    private int xPosition;   // The x,y coordinates of its top left corner
    private int yPosition;
    private String color;    // The color of the square

    // Create a new square 
    public Square(int xPosition, int yPosition, int size, String color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.side	   = size;
        this.color	   = color;
        draw();
    }

    // Move the square to a new position.
    public void moveTo(int newX, int newY) {
		erase();
        xPosition = newX;
        yPosition = newY;
		draw();
    }

    // Move the square by an amount.
    public void move(int deltaX, int deltaY) {
		erase();
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
		draw();
    }

    // Change the side to the new side.
    public void changeSide(int newSide) {
		erase();
        side = newSide;
		draw();
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    public void changeColor(String newColor) {
		erase();
        color = newColor;
		draw();
    }

    // Draw the square with current specifications on screen.
    private void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        canvas.fill(new java.awt.Rectangle(xPosition, yPosition, side, side));
    }

    // Erase the square on screen.
    private void erase() {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(new java.awt.Rectangle(xPosition, yPosition, side, side));
    }
}