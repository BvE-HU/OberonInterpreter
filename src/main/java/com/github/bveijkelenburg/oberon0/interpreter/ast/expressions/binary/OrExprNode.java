package com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.binary;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.BooleanValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class OrExprNode extends BinaryExpressionNode {
	public OrExprNode(IExpressionNode lhn, IExpressionNode rhn) {
		super(lhn, rhn);
	}
	
	@Override
	public OberonValue eval(Environment env) {
		BooleanValue left  = (BooleanValue)lhn.eval(env);
		BooleanValue right = (BooleanValue)rhn.eval(env);
		
		return new BooleanValue(left.getValue() || right.getValue());
	}
}
