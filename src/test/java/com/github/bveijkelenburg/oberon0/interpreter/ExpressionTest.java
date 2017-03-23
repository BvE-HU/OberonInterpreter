package com.github.bveijkelenburg.oberon0.interpreter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.NumberNode;
import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.binary.BinaryExpressionNode;
import com.github.bveijkelenburg.oberon0.interpreter.ast.expressions.binary.MultExprNode;
import com.github.bveijkelenburg.oberon0.interpreter.env.Environment;

public class ExpressionTest {
	@Test
	public void testMultiply() {
		Environment env = new Environment();
		
		NumberNode value1 = new NumberNode(-10);
		NumberNode value2 = new NumberNode(0);
		
		BinaryExpressionNode e1 = new MultExprNode(value1, value2);
		
		assertEquals(new Integer(0), e1.eval(env).getValue());
	}
}
