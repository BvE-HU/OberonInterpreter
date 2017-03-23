package com.github.bveijkelenburg.oberon0.interpreter.ast.declarations;

import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.ast.IExecutableNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.procedures.ApplicationProcedure;
import com.github.bveijkelenburg.oberon0.interpreter.shared.TypedParameterList;

public class ProcedureDeclarationNode implements IDeclarationNode {
	private String ident;
	private List<TypedParameterList> formalParameters;
	private IExecutableNode body;
	
	public ProcedureDeclarationNode(String name1, String name2, List<TypedParameterList> fp, IExecutableNode body) {
		if (! name1.equals(name2)) {
			throw new RuntimeException("Procedure START-identifier and END-identifier aren't equals: " +name1+ " <> " +name2);
		}
		
		this.ident = name1;
		this.formalParameters = fp;
		this.body = body;
	}
	
	@Override
	public void declare(Environment env) {
		env.addProcedure(ident, new ApplicationProcedure(ident, formalParameters, body));
	}
}
