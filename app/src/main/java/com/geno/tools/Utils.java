package com.geno.tools;

import java.io.DataOutputStream;

public class Utils
{
	public static void exec(String cmd) throws Exception
	{
		Runtime.getRuntime().exec(cmd);
	}

	public static void execSu(String cmd) throws Exception
	{
		Process p = Runtime.getRuntime().exec("su");
		DataOutputStream o = new DataOutputStream(p.getOutputStream());
		o.writeBytes(cmd);
		o.flush();
	}
}
