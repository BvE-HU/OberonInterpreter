package com.github.bveijkelenburg.oberon0.interpreter.ast.declarations;

import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.ast.types.IOberonTypeNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class VarDeclarationNode implements IDeclarationNode {
	private List<String> identList;
	private IOberonTypeNode type;
	
	public VarDeclarationNode(List<String> identList, IOberonTypeNode type) {
		this.identList = identList;
		this.type = type;
	}
	
	@Override
	public void declare(Environment env) {
		OberonValue t = (OberonValue)type.initializeNew(env);
		
		for (String ident : identList) {
			env.addVariable(ident, t.clone());
		}
	}
}
