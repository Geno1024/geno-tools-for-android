package com.geno.tools;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class Unicoder extends Activity
{
	public boolean isU2C = true;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l = new LinearLayout(this);
		l.setOrientation(LinearLayout.VERTICAL);
		setContentView(l);
		final EditText unicode = new EditText(this), chara = new EditText(this);
		unicode.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
		chara.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
		l.addView(unicode);
		l.addView(chara);
		unicode.addTextChangedListener(new TextWatcher()
		{
			@Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override public void onTextChanged(CharSequence s, int start, int before, int count)
			{
				if (isU2C)
					try {chara.setText(new String(Character.toChars(Integer.parseInt(unicode.getText().toString().isEmpty() ? "0" : unicode.getText().toString(), 16))));}
					catch (Exception e) {chara.setText("Illegal input: " + e.getMessage());}
			}
			@Override public void afterTextChanged(Editable s) {}
		});
		chara.addTextChangedListener(new TextWatcher()
		{
			@Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override public void onTextChanged(CharSequence s, int start, int before, int count)
			{
				if (!isU2C)
					try {unicode.setText(Integer.toHexString(Character.codePointAt(chara.getText().toString(), 0)));}
					catch (Exception e) {unicode.setText(e.getMessage() == null ? "" : "Illegal input: " + e.getMessage());}
			}
			@Override public void afterTextChanged(Editable s) {}
		});
		ToggleButton s = new ToggleButton(this);
		s.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
		s.setTextOn("Unicode 2 Char");
		s.setTextOff("Char 2 Unicode");
		s.setChecked(isU2C);
		s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {@Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {isU2C = isChecked;}});
		l.addView(s);
	}
}
