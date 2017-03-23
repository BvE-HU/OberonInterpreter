package com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.binary;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.IntValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class ModExprNode extends BinaryExpressionNode {
	public ModExprNode(IExpressionNode lhn, IExpressionNode rhn) {
		super(lhn, rhn);
	}
	
	@Override
	public OberonValue eval(Environment env) {
		IntValue left  = (IntValue)lhn.eval(env);
		IntValue right = (IntValue)rhn.eval(env);
		
		return new IntValue(left.getValue() % right.getValue());
	}
}
