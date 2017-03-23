package com.github.bveijkelenburg.oberon0.interpreter.env.procedures.builtins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.github.bveijkelenburg.oberon0.interpreter.ast.types.IntTypeNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.procedures.Procedure;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.IntValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;
import com.github.bveijkelenburg.oberon0.interpreter.shared.TypedParameterList;
import com.github.bveijkelenburg.oberon0.interpreter.shared.TypedReferenceParameterList;

public class Read extends Procedure {
	private final String REF_VAR_STORE = "var_storage";
	
	@Override
	public List<TypedParameterList> getFormalParameters() {
		ArrayList<TypedParameterList> parameters = new ArrayList<TypedParameterList>();
		parameters.add(new TypedReferenceParameterList(Arrays.asList(new String[] {REF_VAR_STORE}), new IntTypeNode()));
		
		return parameters;
	}
	
	@SuppressWarnings("resource")
	@Override
	public void execute(Environment env) {
		Scanner s = new Scanner(System.in);
		OberonValue variable = env.getVariable(REF_VAR_STORE);
		variable.setValue(new IntValue(s.nextInt()));
	}
}
