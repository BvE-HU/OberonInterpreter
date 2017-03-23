package com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.binary;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.BooleanValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class EqualsExprNode extends BinaryExpressionNode {
	public EqualsExprNode(IExpressionNode lhn, IExpressionNode rhn) {
		super(lhn, rhn);
	}
	
	@Override
	public BooleanValue eval(Environment env) {
		OberonValue left  = lhn.eval(env);
		OberonValue right = rhn.eval(env);
		
		return new BooleanValue(left.getValue().equals(right.getValue()));
	}
}
