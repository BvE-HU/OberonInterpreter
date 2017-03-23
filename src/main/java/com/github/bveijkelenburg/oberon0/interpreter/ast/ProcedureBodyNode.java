package com.github.bveijkelenburg.oberon0.interpreter.ast;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;

public class ProcedureBodyNode implements IExecutableNode {
	private IExecutableNode declarations;
	private IExecutableNode body;
	
	public ProcedureBodyNode(IExecutableNode declarations, IExecutableNode body) {
		this.declarations = declarations;
		this.body = body;
	}
	
	@Override
	public void execute(Environment env) {
		declarations.execute(env);
		body.execute(env);		
	}
}
