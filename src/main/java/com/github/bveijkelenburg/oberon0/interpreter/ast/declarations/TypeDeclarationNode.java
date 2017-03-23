package com.github.bveijkelenburg.oberon0.interpreter.ast.declarations;

import com.github.bveijkelenburg.oberon0.interpreter.ast.types.IOberonTypeNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.TypeValue;

public class TypeDeclarationNode implements IDeclarationNode {
	private String ident;
	private IOberonTypeNode type;
	
	public TypeDeclarationNode(String ident, IOberonTypeNode type) {
		this.ident = ident;
		this.type = type;
	}
	
	@Override
	public void declare(Environment env) {
		OberonValue t = type.initializeNew(env);
		TypeValue appType = new TypeValue(ident, t);
		env.addUserType(ident, appType);
	}
}
