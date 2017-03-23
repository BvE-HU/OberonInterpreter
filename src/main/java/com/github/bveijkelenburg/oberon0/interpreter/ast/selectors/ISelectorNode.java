package com.github.bveijkelenburg.oberon0.interpreter.ast.selectors;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.shared.SelectorValue;

public interface ISelectorNode {
	public SelectorValue evaluate(Environment env);
}