package com.github.bveijkelenburg.oberon0.interpreter.ast.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.OberonValue;
import com.github.bveijkelenburg.oberon0.interpreter.env.values.RecordValue;

public class RecordTypeNode implements IOberonTypeNode {
	private List<TypedFieldListNode> fieldLists;
	
	public RecordTypeNode(List<TypedFieldListNode> fieldLists) {
		this.fieldLists = fieldLists;
	}
	
	@Override
	public OberonValue initializeNew(Environment env) {
		Map<String, OberonValue> fields = new HashMap<String, OberonValue>();
		
		for (TypedFieldListNode fieldList : fieldLists) {
			Map<String, OberonValue> newFields = fieldList.initializeFieldList(env);
			for (Map.Entry<String, OberonValue> entry : newFields.entrySet()) {
				fields.put(entry.getKey(), entry.getValue());
			}
		}
		
		return new RecordValue(fields);
	}
}
