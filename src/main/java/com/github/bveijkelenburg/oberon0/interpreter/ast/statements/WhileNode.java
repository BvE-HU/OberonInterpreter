package com.github.bveijkelenburg.oberon0.interpreter.ast.statements;

import com.github.bveijkelenburg.oberon0.interpreter.ast.IExecutableNode;
import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.BooleanValue;

public class WhileNode implements IStatementNode {
	private IExpressionNode condition;
	private IExecutableNode body;
	
	public WhileNode(IExpressionNode condition, IExecutableNode body) {
		this.condition = condition;
		this.body = body;
	}
	
	@Override
	public void execute(Environment env) {
		while ( ((BooleanValue)condition.eval(env)).getValue()) {
			body.execute(env);
		}
	}
}
