import java.util.*;
public class TestJni
{
	public native void xprint(String content);
	static
	{
		System.loadLibrary("TestJni");
	}
	public native static String native_hello();
}
