/*File Name: Triangles.java
*	Author: Dustin Horvath
*   KUID: 2729265
*	Email Address: dustinmhorvath@ku.edu 
*	Lab Assignment: lab9 
*	Description: A simple android java app that displays a pyramid made of triangles, where the user can specify
*	the number of triangles that define its base. 
*	Last Changed: 4/8/14 
* 
*   Base Code created by Justin Dawson (JDawson@ku.edu)
*/
package edu.ku.eecs168.triangles;


import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;


public class Triangles extends AbsTriangles {

    private int numTriangles = 10; 
    private Random ranGen;
    private int colorType;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ranGen = new Random();
	}
	
	// This method spawns an input dialog, and stores the return value as 'numTriangles'
	@Override
	public void onDialogReturned(int num) {
		numTriangles = num;
		repaint();
	}
	

    @Override
    public void colorRows() {
        colorType = 1;
        repaint();
    }

    @Override
    public void colorRandom() {
        colorType = 2;
        repaint();
    }

    @Override
    public void colorGradient() {
        colorType = 3;
        repaint();
    }
	
	// The setColor method of the Graphics class expects color to be specified as a single int.
	// This routine converts RGBalpha values into a single int that setColor can understand.
	// Specify the red, green, blue and alpha values as integers between 0 and 255.
	// Alpha is a transparency component - an alpha of 255 is fully opaque, 
	//   while an alpha of 0 is transparent.
	// The output of rgbToColor is an integer that is in the format expected by setColor,
	// which is specified by a hexidecimal value of the format 0xAARRGGBB
	public int rgbToColor(int red, int green, int blue, int alpha) {
		int color = 0;
		color += blue;
		color += 256*green;
		color += 256*256*red;
		color += 256*256*256*alpha;
		return color;
	}
		
	
	@Override
	public void paint(Graphics canvas) {
		//clear the screen before we draw
		canvas.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		// Defines random 8-bit value for Red, Blue, and Green
		int red = ranGen.nextInt(255);
		int green = ranGen.nextInt(255);
		int blue = ranGen.nextInt(255);
		
		// Defines 'color' using the random rgb values for Blue, Red, and Green defined above.
		int color = rgbToColor(red, green, blue, 255);
		// Sets the drawing color to 'color'
		canvas.setColor(color);
		
		// Defines the width and height of triangles to be percentages of the the screen width and height.
		int triangleWidth = canvas.getWidth()/numTriangles;
		int triangleHeight = canvas.getHeight()/numTriangles;
		
		// Loop for each row
		for(int j = 0; j < numTriangles; j++){
			
			//Loop to print each triangle in a row.
			for(int i = 0;i < numTriangles - j; i++){
			canvas.drawIsoTriangle(i * triangleWidth, canvas.getHeight() - (triangleHeight*j), triangleWidth, triangleHeight);
			}
		}
		//TODO Within the nested for loops, create if-statements for the colorType (EECS 169 only) DELETE this comment when completed
		// I might do this part later for some practice.
	}
}
