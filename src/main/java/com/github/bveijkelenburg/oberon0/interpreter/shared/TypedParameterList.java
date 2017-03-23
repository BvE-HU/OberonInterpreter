package com.github.bveijkelenburg.oberon0.interpreter.shared;

import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.ast.types.IOberonTypeNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public abstract class TypedParameterList {
	private List<String> parameterList;
	private IOberonTypeNode type;
	
	public TypedParameterList(List<String> parameterList, IOberonTypeNode type) {
		this.parameterList = parameterList;
		this.type = type;
	}
	
	public List<String> getParametersList() {
		return parameterList;
	}
	
	public IOberonTypeNode getType() {
		return type;
	}
	
	public abstract OberonValue processValue(String parameter, OberonValue value, Environment env);
}