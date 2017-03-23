package com.github.bveijkelenburg.oberon0.interpreter.ast.selectors;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.IExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.shared.SelectorValue;

public class ElementSelectorNode implements ISelectorNode {
	private IExpressionNode expression;
	
	public ElementSelectorNode(IExpressionNode expression) {
		this.expression = expression;
	}
	
	@Override
	public SelectorValue evaluate(Environment env) {
		return new SelectorValue(expression.eval(env));
	}
}
