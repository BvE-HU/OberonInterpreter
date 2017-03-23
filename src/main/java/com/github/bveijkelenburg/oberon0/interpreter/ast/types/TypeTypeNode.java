package com.github.bveijkelenburg.oberon0.interpreter.ast.types;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class TypeTypeNode implements IOberonTypeNode {
	private String name;
	
	public TypeTypeNode(String name) {
		this.name = name;
	}
	
	@Override
	public OberonValue initializeNew(Environment env) {
		return env.createApplicationType(name);
	}
}
