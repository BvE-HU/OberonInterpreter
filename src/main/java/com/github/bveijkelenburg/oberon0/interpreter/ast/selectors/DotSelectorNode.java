package com.github.bveijkelenburg.oberon0.interpreter.ast.selectors;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.shared.SelectorValue;

public class DotSelectorNode implements ISelectorNode {
	private String selector;
	
	public DotSelectorNode(String selector) {
		this.selector = selector;
	}
	
	public SelectorValue evaluate(Environment env) {
		return new SelectorValue(selector);
	}
}