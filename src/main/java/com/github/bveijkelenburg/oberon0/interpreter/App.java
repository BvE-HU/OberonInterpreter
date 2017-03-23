package com.github.bveijkelenburg.oberon0.interpreter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.github.bveijkelenburg.oberon0.interpreter.ast.IExecutableNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.parser.Oberon0Lexer;
import com.github.bveijkelenburg.oberon0.interpreter.parser.Oberon0Parser;

public class App {
	private static final String LOCATION_TESTAPPS = "oberon0_samples";

	public static InputStream chooseFile() {
		List<String> oberonApps = new ArrayList<String>();
		
		try {
			File root = new File(App.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			if (root.getName().endsWith(".jar")) { /* Program runs within JAR" */
				try (JarFile jf = new JarFile(root)) {
					for (Enumeration<JarEntry> entries = jf.entries(); entries.hasMoreElements();) {
						JarEntry entry = entries.nextElement();
						if (entry.getName().startsWith(LOCATION_TESTAPPS) && entry.getName().endsWith(".oberon0")) {
							oberonApps.add("/" +entry.getName());
						}
					}
				}
			} else { /* Program runs in directory */ 
			    File testFilesDir = new File(App.class.getClassLoader().getResource(LOCATION_TESTAPPS).getFile());
			    
			    for (File f : testFilesDir.listFiles(file -> file.getAbsolutePath().endsWith(".oberon0"))) { 
			    	oberonApps.add("/" + LOCATION_TESTAPPS + "/" + f.getName());
			    }
			}
		} catch (Exception e) { e.printStackTrace(); }
		
		
		for(int i=0; i < oberonApps.size(); i++) {
			System.out.println("[" +i+ "]: " +oberonApps.get(i));
		}
		
		System.out.print("Uw keuze: ");
		System.out.flush();
		
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		s.close();

		return App.class.getResourceAsStream(oberonApps.get(choice));
	}
	
	public static void main(String[] args) throws Exception {
		InputStream appToExecute;
		
		if (args.length > 0) {
			appToExecute = new FileInputStream(args[0]);
		} else {
			appToExecute = chooseFile();
		}
		
		// read from quicksort.oberon0 file
		ANTLRInputStream input = new ANTLRInputStream(appToExecute);
		// Create an ExprLexer that feeds from that stream
		Oberon0Lexer lexer = new Oberon0Lexer(input);
		// Create a stream of tokens fed by the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Create a parser that feeds off the token stream
		Oberon0Parser parser = new Oberon0Parser(tokens);
		
		try {
			// Begin parsing at rule prog
			IExecutableNode startNode = parser.module();
			
			if ((lexer.getNumberOfSyntaxErrors() == 0) && (parser.getNumberOfSyntaxErrors() == 0)) {
				startNode.execute(new Environment());
			} else {
				System.out.println("lexer errors:  " +lexer.getNumberOfSyntaxErrors());
				System.out.println("parser errors: " +parser.getNumberOfSyntaxErrors());
				System.out.println("There are parse- and/or lexer-errors!");
			}
		} catch (RecognitionException re) {
			re.printStackTrace();
		}
	}
}
