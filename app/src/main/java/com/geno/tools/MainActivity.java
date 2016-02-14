package com.geno.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l = new LinearLayout(this);
		l.setOrientation(LinearLayout.VERTICAL);
		setContentView(l);

		Button adb_wifi = new Button(this);
		adb_wifi.setText("ADB Wifi");
		adb_wifi.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
		adb_wifi.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {startActivity(new Intent(MainActivity.this, ADB_Wifi.class));}});
		l.addView(adb_wifi);

		Button unicoder = new Button(this);
		unicoder.setText("Unicoder");
		unicoder.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
		unicoder.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {startActivity(new Intent(MainActivity.this, Unicoder.class));}});
		l.addView(unicoder);
	}
}

