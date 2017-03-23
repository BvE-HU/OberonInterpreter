package com.github.bveijkelenburg.oberon0.interpreter.env.procedures;

import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.ast.IExecutableNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.shared.TypedParameterList;

public class ApplicationProcedure extends Procedure {
	private String name;
	private List<TypedParameterList> formalParametersList;
	private IExecutableNode body;	
	
	public ApplicationProcedure(String name, List<TypedParameterList> fpList, IExecutableNode body) {
		this.name = name;
		this.formalParametersList = fpList;
		this.body = body;
	}
	
	@Override
	public List<TypedParameterList> getFormalParameters() {
		return formalParametersList;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void execute(Environment env) {
		body.execute(env);
	}
}