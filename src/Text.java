/*
    Text class
	Version 2.0
    Copyright 2005 by Mordechai (Moti) Ben-Ari
     
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
public class Text {
    private int    xPosition;   // The x,y coordinates of its start
    private int    yPosition;
    private String text;        // The text to display
    private String color;       // The color of the line

    // Create a new text string 
    public Text(int xPosition, int yPosition, String text, String color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.text	   = text;
        this.color	   = color;
        draw();
    }

    // Move the text to a new position.
    public void moveTo(int newX, int newY) {
		erase();
        xPosition = newX;
        yPosition = newY;
        draw();
    }

    // Move the line by an amount.
    public void move(int deltaX, int deltaY) {
		erase();
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
        draw();
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    public void changeColor(String newColor) {
		erase();
        color = newColor;
        draw();
    }
    
    // Change the written text.
    public void changeText(String newText){
    	erase();
    	text = newText;
    	draw();
    }

    // Draw the line with current specifications on screen.
    private void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(color);
        canvas.drawString(text, xPosition, yPosition);
    }

    // Erase the line on screen.
    private void erase() {
        Canvas canvas = Canvas.getCanvas();
        canvas.eraseString(text, xPosition, yPosition);
    }
}
