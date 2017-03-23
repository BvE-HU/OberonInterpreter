package com.github.bveijkelenburg.oberon0.interpreter.env.values;


/**
 * This class is one of the two backbonen of all the OberonTypes other
 * than Int ant Boolean. It contains an int value that can be changed 
 * using the setValue method. Likewise, it can be accessed using the 
 * getValue method.
 * 
 * @author Bart v. Eijkelenburg
 *
 */
public class IntValue extends OberonValue {
	private int value;
	
	public IntValue(int value) {
		this.value = value;
	}
	
	@Override
	public Integer getValue() {
		return value;
	}
	
	@Override
	public void setValue(OberonValue value) {
		if (! this.typeEquals(value)) {
			throw new RuntimeException("Can not assign\n" +value+ " to \n" +this+ "!");
		}
		this.value = ((IntValue)value).value;
	}
	
	@Override
	public boolean typeEquals(OberonValue obj) {
		return (obj != null && obj instanceof IntValue);
	}
	
	@Override
	public IntValue clone() {
		return new IntValue(value);
	}
}