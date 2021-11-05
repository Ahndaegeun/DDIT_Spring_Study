package kr.or.ddit;

import net.openhft.compiler.CompilerUtils;

public class TestCompile {
	public static void main(String[] args) {
		// dynamically you can call
		String className = "mypackage.MyClass";
		
		StringBuilder code = new StringBuilder();
		code.append("package mypackage;");
		code.append("public class MyClass implements Runnable {");
		code.append("    public void run() {");
		code.append("		MemberVO vo = new MemberVO();");
		code.append("		System.out.println(\"vo.id\")");
		code.append("        System.out.println(\\\"Hello World\\\");");
		code.append("    }");
		code.append("}");
		code.append("class MemberVO {");
		code.append("public String id = \"a001\"");
		code.append("}");
		
		Runnable runner = null;
		try {
			Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, code.toString());
			runner = (Runnable) aClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		runner.run();
	}
}
