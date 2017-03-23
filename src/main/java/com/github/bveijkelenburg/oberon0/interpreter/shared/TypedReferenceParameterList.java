package com.github.bveijkelenburg.oberon0.interpreter.shared;

import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.ast.types.IOberonTypeNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public class TypedReferenceParameterList extends TypedParameterList {
	public TypedReferenceParameterList(List<String> paramList, IOberonTypeNode type) {
		super(paramList, type);
	}
	
	@Override
	public OberonValue processValue(String parameter, OberonValue value, Environment env) {
		if (!parameter.contains(parameter)) {
			throw new RuntimeException("Parameter " +parameter+ " is not in the list!");
		}
		
		return value;
	}
}
