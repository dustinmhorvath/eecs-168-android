package edu.ku.eecs168.SmileyFace;

import android.graphics.Color;
import edu.ku.swingemu.AndroidJApplet;

public class SmileyFace extends AndroidJApplet {
	//The value of counter has been initialized to help keep track of current frame
	public int counter=0;

	
	public void paint(Graphics canvas) {

		//this line clears the screen every time the screen is refreshed
		canvas.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        /* This if-else loop is clever (not by me). it uses the int 'counter', and each condition 
         * sets counter as its opposite, causing it to alternate
         * 
         */
		if(counter==0){
			//Draws the yellow background
			canvas.setColor(Color.YELLOW);
			canvas.fillOval(100, 50, 200, 200);		
			
			//Draws the outline
			canvas.setColor(Color.BLACK);
            canvas.drawOval(100, 50, 200, 200);
            
            //Draws the eyes
			canvas.fillOval(155, 100, 10, 20);
			canvas.fillOval(230, 100, 10, 20);
			
			//Draws the smile
			canvas.drawArc(150, 160, 100, 50, 180, 180);
            
			counter = 1;
			
		}else{ //Here we do it all again, but displaced 500 pixels to the right
			
			//Draws background
			canvas.setColor(Color.YELLOW);
			canvas.fillOval(600, 50, 300, 300);	
			
			//Draws outline
			canvas.setColor(Color.BLACK);
            canvas.drawOval(600, 50, 300, 300);
            
            //Draws eyes
			canvas.fillOval(690, 120, 15, 30);
			canvas.fillOval(793, 120, 15, 30);
			
			//Draws smile, except upside-down this time
			canvas.drawArc(678, 225, 150, 75, 180, -180);
			
			counter=0;
		}
	}

}
