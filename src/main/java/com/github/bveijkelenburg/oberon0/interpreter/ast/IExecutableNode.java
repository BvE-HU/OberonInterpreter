package com.github.bveijkelenburg.oberon0.interpreter.ast;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;

public interface IExecutableNode {
	public void execute(Environment env);
}
