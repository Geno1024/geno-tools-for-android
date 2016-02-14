package com.geno.tools;

import java.io.DataOutputStream;

public class Utils
{
	public static void execSu(String cmd) throws Exception
	{
		Process p = Runtime.getRuntime().exec("su");
		DataOutputStream o = new DataOutputStream(p.getOutputStream());
		o.writeBytes(cmd + "\nexit\n");
		o.flush();
	}
}
