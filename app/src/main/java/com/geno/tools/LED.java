package com.geno.tools;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class LED extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l = new LinearLayout(this);
		setContentView(l);
		l.setOrientation(LinearLayout.VERTICAL);
		SeekBar.OnSeekBarChangeListener s = new SeekBar.OnSeekBarChangeListener()
		{
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				String toE = "";
				switch (seekBar.getId())
				{
					case 0: toE = "red"; break;
					case 1: toE = "green"; break;
					case 2: toE = "blue"; break;
					case 3: toE = "lcd-backlight"; if (progress == 0) seekBar.setProgress(1); break;
					case 4: toE = "flashlight"; break;
				}
				try {Utils.execSu("echo " + progress + "> /sys/class/leds/" + toE + "/brightness");}
				catch (Exception e) {e.printStackTrace();}
			}
			@Override public void onStartTrackingTouch(SeekBar seekBar) {}
			@Override public void onStopTrackingTouch(SeekBar seekBar) {}
		};
		SeekBar b[] = new SeekBar[5];
		for (int i = 0; i < b.length; i++)
		{
			b[i] = new SeekBar(this);
			b[i].setId(i);
			b[i].setMax(255);
			b[i].setOnSeekBarChangeListener(s);
			l.addView(b[i], new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 60));
		}
	}
}
