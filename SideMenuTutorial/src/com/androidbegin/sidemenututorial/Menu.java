package com.androidbegin.sidemenututorial;

import java.util.Iterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class Menu extends Activity
{
	@SuppressWarnings("rawtypes")
	@Override
	 public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	    ScrollView scroll = new ScrollView(this);
	    RelativeLayout myLayout = new RelativeLayout(this); 
	    myLayout.setBackground(getResources().getDrawable(R.drawable.back_a));
	    Button bogus = null;
	    Button[] Buttons = new Button[10];
	    Buttons[0] = addButtonToLayout(0,"FirstButton", myLayout, bogus);
	    int i = 0;
	    for (Iterator it = Common.users.iterator(); it.hasNext();) 
	    {
	    	i++;
            Users p = (Users) it.next();
            System.out.println("P: "  + p.getRestaurant());
            Buttons[i] = addButtonToLayout(i, p.getRestaurant(), myLayout, Buttons[i-1]);
        }
	    scroll.addView(myLayout);
	    setContentView(scroll);
	}	
	
	public Button addButtonToLayout(int id, String text, ViewGroup layout, Button previous)
	{
		Button myButton = new Button(this);
	    myButton.setId(id);
	    myButton.setText(text);
		myButton.setBackground(getResources().getDrawable(R.drawable.login_clicked));
		myButton.setWidth(250);
		myButton.setHeight(100);
		myButton.setClickable(true);
		myButton.setOnClickListener(new Button.OnClickListener() 
		{
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
			}
	    });
        RelativeLayout.LayoutParams buttonParam = 
                new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, 
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
        if( id == 0)
        {
            buttonParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
            buttonParam.addRule(RelativeLayout.CENTER_VERTICAL);
        }
        else
        {
            buttonParam.addRule(RelativeLayout.BELOW, previous.getId());
            buttonParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
            buttonParam.setMargins(0, 80, 0, 40);
        	layout.addView(myButton, buttonParam);
        }
        return myButton;
	}
	
}