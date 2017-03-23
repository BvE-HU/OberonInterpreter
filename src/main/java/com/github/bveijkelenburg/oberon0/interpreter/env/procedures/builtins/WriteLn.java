package com.github.bveijkelenburg.oberon0.interpreter.env.procedures.builtins;

import java.util.List;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.procedures.Procedure;
import com.github.bveijkelenburg.oberon0.interpreter.shared.TypedParameterList;

public class WriteLn extends Procedure {
	@Override
	public List<TypedParameterList> getFormalParameters() {
		return null;
	}
	
	@Override
	public void execute(Environment env) {
		System.out.println();
	}
}
