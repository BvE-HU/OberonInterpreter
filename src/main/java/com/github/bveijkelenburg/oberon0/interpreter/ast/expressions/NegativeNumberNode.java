package com.github.bveijkelenburg.oberon0.interpreter.ast.expressions;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.IntValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class NegativeNumberNode implements IExpressionNode {
	private IExpressionNode expression;
	
	public NegativeNumberNode(IExpressionNode expression) {
		this.expression = expression;
	}
	
	@Override
	public OberonValue eval(Environment env) {
		IntValue val = (IntValue)expression.eval(env);
		val.setValue(new IntValue(val.getValue() * -1));
		
		return val;
	}
}
