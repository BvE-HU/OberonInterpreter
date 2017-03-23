package com.github.bveijkelenburg.oberon0.interpreter.ast.expressions;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public interface IExpressionNode {
	public OberonValue eval(Environment env);
}
