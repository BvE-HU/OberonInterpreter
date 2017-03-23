package com.github.bveijkelenburg.oberon0.interpreter.env.procedures.builtins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.ast.types.IntTypeNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.procedures.Procedure;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.IntValue;
import com.github.bveijkelenburg.oberon0.interpreter.shared.TypedParameterList;
import com.github.bveijkelenburg.oberon0.interpreter.shared.TypedValueParameterList;

public class Write extends Procedure {
	private final String VAL_VAR_STORE = "var_read";
	
	@Override
	public List<TypedParameterList> getFormalParameters() {
		ArrayList<TypedParameterList> parameters = new ArrayList<TypedParameterList>();
		parameters.add(new TypedValueParameterList(Arrays.asList(new String[] {VAL_VAR_STORE}), new IntTypeNode()));
		
		return parameters;
	}
	
	@Override
	public void execute(Environment env) {
		IntValue variable = (IntValue)env.getVariable(VAL_VAR_STORE);
		System.out.print(variable.getValue());
		System.out.flush();
	}
}
