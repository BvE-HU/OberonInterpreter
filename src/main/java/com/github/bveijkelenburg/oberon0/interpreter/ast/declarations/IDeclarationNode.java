package com.github.bveijkelenburg.oberon0.interpreter.ast.declarations;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;

public interface IDeclarationNode {
	public void declare(Environment env);
}
