package com.github.bveijkelenburg.oberon0.interpreter.ast.declarations;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.ConstantValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.IntValue;

public class ConstantDeclarationNode implements IDeclarationNode {
	private String ident;
	private IExpressionNode expression;
	
	public ConstantDeclarationNode(String ident, IExpressionNode expression) {
		this.ident = ident;
		this.expression = expression;
	}
	
	@Override
	public void declare(Environment env) {
		IntValue val = (IntValue)expression.eval(env);
		ConstantValue c = new ConstantValue(val.getValue());
		
		env.addConstant(ident, c);
	}
}
