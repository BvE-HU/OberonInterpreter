package com.github.bveijkelenburg.oberon0.interpreter.ast.statements;

import com.github.bveijkelenburg.oberon0.interpreter.ast.IExecutableNode;
import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.BooleanValue;

public class ElseIfNode implements IStatementNode {
	private IExpressionNode condition;
	private IExecutableNode body;
	private IStatementNode nextElse;
	
	public ElseIfNode(IExpressionNode condition, IExecutableNode body, IStatementNode nextElse) {
		this.condition = condition;
		this.body = body;
		this.nextElse = nextElse;
	}
	
	@Override
	public void execute(Environment env) {
		BooleanValue val = (BooleanValue)condition.eval(env);
		
		if ( val.getValue() ) {
			body.execute(env);
		} else if (nextElse != null) {
			nextElse.execute(env);
		}
	}
}
