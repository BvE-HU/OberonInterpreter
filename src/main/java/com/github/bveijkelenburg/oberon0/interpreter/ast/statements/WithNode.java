package com.github.bveijkelenburg.oberon0.interpreter.ast.statements;

import com.github.bveijkelenburg.oberon0.interpreter.ast.IExecutableNode;
import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;
import com.github.bveijkelenburg.oberon0.interpreter.shared.SelectorValue;

public class WithNode implements IStatementNode {
	private IExpressionNode expression;
	private IExecutableNode body;
	
	public WithNode(IExpressionNode expr,IExecutableNode body) {
		this.expression = expr;
		this.body = body;
	}
	
	@Override
	public void execute(Environment env) {
		final OberonValue type = expression.eval(env);
		final Environment superSpace = env;
		
		// created an extended Environment for use only in the with-statement
		// it first looks in the specified record for this with-statement,
		// if there is no field available, then the normal environment is used
		Environment withEnv = new Environment(env) {
			@Override
			public OberonValue getVariable(String varId) {
				try {
					SelectorValue sv = new SelectorValue(varId);
					return type.evaluateSelector(sv);
				} catch (RuntimeException re) {
					return superSpace.getVariable(varId);
				}
			}
		};
	
		body.execute(withEnv);
	}
}