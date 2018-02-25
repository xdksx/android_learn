package com.bt.jni;
public class SimpleJni{
	static {
		System.out.println("[java] static code block,start load shared library...");
		System.loadLibrary("SimpleJni");
		System.out.println("[java]load library end...");
	}
	static native int add(int a,int b);
	public static void main(String args[])
	{
		System.out.println("[java] in main...");
		System.out.println("[java] 3+4="+SimpleJni.add(3,4));
		System.out.println("end...");
	}
}
