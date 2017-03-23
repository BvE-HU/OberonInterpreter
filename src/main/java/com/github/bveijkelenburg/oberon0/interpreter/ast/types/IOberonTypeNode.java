package com.github.bveijkelenburg.oberon0.interpreter.ast.types;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public interface IOberonTypeNode {
	public OberonValue initializeNew(Environment env);
}
