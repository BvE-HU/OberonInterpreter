package com.github.bveijkelenburg.oberon0.interpreter.shared;

import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;

public final class SelectorValue {
	private final String stringVal;
	private final OberonValue oberonVal;

	public SelectorValue(String val) {
		if (val == null) {
			throw new IllegalArgumentException("Cannot instantiate SelectorValue with " + val);
		}
		this.stringVal = val;
		oberonVal = null;
	}

	public SelectorValue(OberonValue val) {
		if (val == null) {
			throw new IllegalArgumentException("Cannot instantiate SelectorValue with " + val);
		}
		oberonVal = val;
		stringVal = null;
	}

	public String getField() {
		if (stringVal != null) {
			return stringVal;
		}
		throw new RuntimeException("Cannot get a fieldname for this SelectorValue!");
	}

	public OberonValue getIndex() {
		if (oberonVal != null) {
			return oberonVal;
		}
		throw new RuntimeException("Cannot get an index for this SelectorValue!");
	}
}
