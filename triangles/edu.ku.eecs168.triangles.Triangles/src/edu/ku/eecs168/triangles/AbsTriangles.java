package edu.ku.eecs168.triangles;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import edu.ku.eecs168.triangles.R;
import edu.ku.swingemu.AndroidJApplet;

public abstract class AbsTriangles extends AndroidJApplet{

	
	public abstract void onDialogReturned(int num);
	public abstract void colorRows();
	public abstract void colorRandom();
	public abstract void colorGradient();
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	private static final int MENU_ROWS      = Menu.FIRST+1;
	private static final int MENU_RANDOM       = Menu.FIRST+2;
	private static final int MENU_GRADIENT     = Menu.FIRST+3;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//Add options from xml file
		getMenuInflater().inflate(R.menu.menu, menu);
        menu.add(0, MENU_ROWS,       1, "Random Rows").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, MENU_RANDOM,       2, "Random").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, MENU_GRADIENT,       3, "Gradient").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.b1){
			//Add Shapes button has been pressed
			createDialog();
		}
		if (item.getItemId() == MENU_ROWS){
		    colorRows();
		}
		if (item.getItemId() == MENU_RANDOM){
		    colorRandom();
		}
		if (item.getItemId() == MENU_GRADIENT){
		    colorGradient();
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void createDialog() {
		AlertDialog.Builder b = new Builder(this);
		b.setMessage("Enter the number of triangles on the bottom row");
		final EditText input = (EditText)View.inflate(this, R.layout.input, null);
		b.setView(input);
		b.setPositiveButton("Ok", new OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				String text = input.getText().toString();
				dialog.dismiss();
				try{
					onDialogReturned(Integer.valueOf(text));
				}catch(NumberFormatException e){
					Toast.makeText(AbsTriangles.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
				}
			}
		});
		b.show();
	}
}
