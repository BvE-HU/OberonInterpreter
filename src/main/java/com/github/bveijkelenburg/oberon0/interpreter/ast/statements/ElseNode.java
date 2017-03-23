package com.github.bveijkelenburg.oberon0.interpreter.ast.statements;

import com.github.bveijkelenburg.oberon0.interpreter.ast.IExecutableNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;

public class ElseNode implements IStatementNode {
	private IExecutableNode body;
	
	public ElseNode(IExecutableNode body) {
		this.body = body;
	}
	
	@Override
	public void execute(Environment env) {
		body.execute(env);
	}
}
