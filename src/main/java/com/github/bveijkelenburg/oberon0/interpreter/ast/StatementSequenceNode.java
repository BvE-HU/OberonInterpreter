package com.github.bveijkelenburg.oberon0.interpreter.ast;

import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.ast.statements.IStatementNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;

public class StatementSequenceNode implements IExecutableNode {
	private List<IStatementNode> sequence;
	
	public StatementSequenceNode(List<IStatementNode> sequence) {
		this.sequence = sequence;
	}
	
	@Override
	public void execute(Environment env) {
		for (IStatementNode statement : sequence) {
			statement.execute(env);
		}
	}
}