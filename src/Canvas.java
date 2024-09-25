/*
    Canvas class
	Version 2.0
    Copyright 2004-5 by Mordechai (Moti) Ben-Ari and Michael Kolling and Bruce Quig
     
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
import javax.swing.*;
import java.awt.*;
public class Canvas {
    private static int width = 600;
    private static int height = 400;
    private static Canvas canvasSingleton;
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColour;
    private Image canvasImage;

	// Create canvas singleton object.
	static Canvas getCanvas() {
		if(canvasSingleton == null)
			canvasSingleton = 
				new Canvas("Graphics V2.0. (C) 2005 M. Ben-Ari & M. Kolling", 
					width, height, Color.white);
		canvasSingleton.setVisible(true);
		return canvasSingleton;
	}

    public static void changeSize(int w, int h) {
        width = w;
        height = h;
        getCanvas().canvas.setPreferredSize(new Dimension(width, height));
    }
    
    public static void changeLocation(int x, int y) {
        getCanvas().frame.setLocation(x, y);
    }
    
    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background colour of the canvas
     */
    private Canvas(String title, int width, int height, Color bgColour) {
        backgroundColour = bgColour;
        canvas = new CanvasPane();
        canvas.setPreferredSize(new Dimension(width, height));
        frame = new JFrame();
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null); 
        frame.pack();
        frame.toFront();
    }

    /**
     * Sets the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    private void setVisible(boolean visible) {
        if(graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background colour
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
            graphic.setColor(backgroundColour);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

	/**
     * Fills the internal dimensions of a given shape with the current 
     * foreground colour of the canvas.
     * @param  shape  the shape object to be filled 
     */
    void fill(Shape shape) {
        graphic.fill(shape);
        canvas.repaint();
    }

    /**
     * Erases a given shape's interior on the screen.
     * @param  shape  the shape object to be erased 
     */
    void erase(Shape shape) {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        graphic.fill(shape);              // erase by filling background colour
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Draws a String on the Canvas.
     * @param  text   the String to be displayed 
     * @param  x      x co-ordinate for text placement 
     * @param  y      y co-ordinate for text placement
     */
    void drawString(String text, int x, int y) {
        graphic.drawString(text, x, y);   
        canvas.repaint();
    }

    /**
     * Erases a String on the Canvas.
     * @param  text     the String to be displayed 
     * @param  x        x co-ordinate for text placement 
     * @param  y        y co-ordinate for text placement
     */
    void eraseString(String text, int x, int y) {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Draws a line on the Canvas.
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    void drawLine(int x1, int y1, int x2, int y2) {
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
    }

    /**
     * Erases a line on the Canvas.
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    void eraseLine(int x1, int y1, int x2, int y2) {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
	}

    /**
     * Sets the foreground colour of the Canvas.
     * @param  newColour   the new colour for the foreground of the Canvas 
     */
    void setForegroundColour(String colour) {
		String c = colour.toLowerCase();
		if(c.equals("red"))
			graphic.setColor(Color.red);
		else if(c.equals("black"))
			graphic.setColor(Color.black);
		else if(c.equals("blue"))
			graphic.setColor(Color.blue);
		else if(c.equals("yellow"))
			graphic.setColor(Color.yellow);
		else if(c.equals("green"))
			graphic.setColor(Color.green);
		else if(c.equals("magenta"))
			graphic.setColor(Color.magenta);
		else if(c.equals("white"))
			graphic.setColor(Color.white);
		else
			graphic.setColor(Color.black);
    }

    public static void wait(int milliseconds) {
        try { Thread.sleep(milliseconds); } 
        catch (Exception e) { }
    }

    private class CanvasPane extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}
