package com.github.bveijkelenburg.oberon0.interpreter.ast.types;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.IntValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class IntTypeNode implements IOberonTypeNode {
	@Override
	public OberonValue initializeNew(Environment env) {
		return new IntValue(0);
	}
}
