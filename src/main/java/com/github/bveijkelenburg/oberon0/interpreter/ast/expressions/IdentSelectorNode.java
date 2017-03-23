package com.github.bveijkelenburg.oberon0.interpreter.ast.expressions;

import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.ast.selectors.ISelectorNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;


public class IdentSelectorNode implements IExpressionNode {
	private String name;
	private List<ISelectorNode> selectors;
	
	public IdentSelectorNode(String name, List<ISelectorNode> selectors) {
		this.name = name;
		this.selectors = selectors;
	}
	
	@Override
	public OberonValue eval(Environment env) {
		OberonValue type = env.getVariable(name);
		
		if (selectors != null) {
			for (ISelectorNode s : selectors) {
				type = type.evaluateSelector(s.evaluate(env));
			}
		}
		
		return type;
	}
}
