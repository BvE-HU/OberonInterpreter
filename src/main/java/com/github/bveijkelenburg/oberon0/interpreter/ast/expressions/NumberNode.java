package com.github.bveijkelenburg.oberon0.interpreter.ast.expressions;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.IntValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class NumberNode implements IExpressionNode {
	private int value;
	
	public NumberNode(Integer value) {
		this.value = value;
	}
	
	@Override
	public OberonValue eval(Environment env) {
		return new IntValue(value);
	}
}
