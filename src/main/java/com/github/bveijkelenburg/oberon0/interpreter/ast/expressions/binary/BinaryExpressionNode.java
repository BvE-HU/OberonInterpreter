package com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.binary;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;

public abstract class BinaryExpressionNode implements IExpressionNode {
	protected IExpressionNode lhn;
	protected IExpressionNode rhn;
	
	public BinaryExpressionNode(IExpressionNode lhn, IExpressionNode rhn) {
		this.lhn = lhn;
		this.rhn = rhn;
	}
}
