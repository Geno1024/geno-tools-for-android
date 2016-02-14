package com.geno.tools;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class ADB_Wifi extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
		int ip = wm.getConnectionInfo().getIpAddress();
		TextView ipOut = new TextView(this);
		ipOut.setText((ip & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 24) & 0xFF));
		setContentView(ipOut);
		try
		{
			Utils.execSu("setprop service.adb.tcp.port 5555");
			Utils.execSu("stop adbd");
			Utils.execSu("start adbd");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}