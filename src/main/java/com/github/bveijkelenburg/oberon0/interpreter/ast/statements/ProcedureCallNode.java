package com.github.bveijkelenburg.oberon0.interpreter.ast.statements;

import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.procedures.Procedure;

public class ProcedureCallNode implements IStatementNode {
	private String ident;
	private List<IExpressionNode> actuals;
	
	public ProcedureCallNode(String ident, List<IExpressionNode> actuals) {
		this.ident = ident;
		this.actuals = actuals;
	}
	
	@Override
	public void execute(Environment env) {
		Procedure p = env.getProcedure(ident);
		
		assert p != null : "No procedure found, Environment returned null!";
		
		p.callProcedure(env, actuals);
	}
}
