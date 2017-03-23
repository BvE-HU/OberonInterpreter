package com.github.bveijkelenburg.oberon0.interpreter.ast.statements;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;

public class AssignmentNode implements IStatementNode {
	private IExpressionNode lhn;
	private IExpressionNode rhn;
	
	public AssignmentNode(IExpressionNode lhn, IExpressionNode rhn) {
		this.lhn = lhn;
		this.rhn = rhn;
	}
	
	@Override
	public void execute(Environment env) {
		lhn.eval(env).setValue(rhn.eval(env));
	}
}
