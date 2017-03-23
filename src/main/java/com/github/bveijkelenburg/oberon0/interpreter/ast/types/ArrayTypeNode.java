package com.github.bveijkelenburg.oberon0.interpreter.ast.types;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.ArrayValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.IntValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class ArrayTypeNode implements IOberonTypeNode {
	private IExpressionNode expression;
	private IOberonTypeNode arrayType;
	
	public ArrayTypeNode(IExpressionNode expression, IOberonTypeNode arrayType) {
		this.expression = expression;
		this.arrayType = arrayType;
	}
	
	@Override
	public OberonValue initializeNew(Environment env) {
		OberonValue size = expression.eval(env);
		OberonValue type = arrayType.initializeNew(env);
		
		return new ArrayValue(type, ((IntValue)size).getValue());
	}
}
