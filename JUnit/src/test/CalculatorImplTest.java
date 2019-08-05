package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Calculator;

public class CalculatorImplTest {

	@Test
	public void testDivide() {
		Calculator calc = new CalculatorImpl();
		int a, b, res;
		a = 5; 
	        b  = 5; 
	        res = a / b;
		if (calc.divide(a, b) != res) {
			fail("a et b positif");
	        }
		a = 0; 
	        b  = 5; 
	        res = a / b;
		if (calc.divide(a, b) != res) {
			fail("a nul");
	        }
		a = -5; 
	        b  = 5; 
	        res = a / b;
		if (calc.divide(a, b) != res) {
			fail("a negatif");
	        }
		a = 5; 
	        b  = -5; 
	        res = a / b;
		if (calc.divide(a, b) != res) {
			fail("b negatif");
	        }
		a = -5; 
	        b  = -5; 
	        res = a / b;
		if (calc.divide(a, b) != res) {
			fail("a et b negatif");
	        }
	}

	@Test (expected = ArithmeticException.class)
	public final void testDivideByZero() {
		Calculator calc = new CalculatorImpl();
		int a, b, res;
		a = 5; 
	        b  = 0; 
	        res = 0;
		assertTrue("b nul", calc.divide(a,b) != res);
		a = 0; 
	        b  = 0; 
	        res = 0;
		assertTrue("a et b nuls", calc.divide(a,b) != res);
	}
	
	@Test
	public void testAdd() {
		Calculator calc = new CalculatorImpl();
		int a, b, res;
		a = 5; 
	        b  = 5; 
	        res = a + b;
		assertTrue("a et b positif", calc.add(a, b) == res);
		a = 0; 
	        b  = 5; 
	        res = a + b;
		assertTrue("a nul", calc.add(a, b) == res);
		a = 5; 
	        b  = 0; 
	        res = a + b;
		assertTrue("b nul", calc.add(a, b) == res);
		a = 0; 
	        b  = 0; 
	        res = a + b;
		assertTrue("a et b nuls", calc.add(a, b) == res);
		a = -5; 
	        b  = 5; 
	        res = a+ b;
		assertTrue("a negatif", calc.add(a, b) == res);
		a = 5; 
	        b  = -5; 
	        res = a + b;
		assertTrue("b negatif", calc.add(a, b) == res);
		a = -5; 
	        b  = -5; 
	        res = a + b;
		assertTrue("a et b negatif", calc.add(a, b) == res);
	}

	@Test
	public void testSubstract() {
		Calculator calc = new CalculatorImpl();
		int a, b, res;
		a = 5; 
	        b  = 5; 
	        res = a + b;
		assertTrue("a et b positif", calc.substract(a, b) != res);
		a = 0; 
	        b  = 5; 
	        res = a + b;
		assertTrue("a nul", calc.substract(a, b) != res);
		a = 5; 
	        b  = 0; 
	        res = a + b;
		assertFalse("b nul", calc.substract(a, b) != res);
		a = 0; 
	        b  = 0; 
	        res = a + b;
		assertFalse("a et b nuls", calc.substract(a, b) != res);
		a = -5; 
	        b  = 5; 
	        res = a+ b;
		assertTrue("a negatif", calc.substract(a, b) != res);
		a = 5; 
	        b  = -5; 
	        res = a + b;
		assertTrue("b negatif", calc.substract(a, b) != res);
		a = -5; 
	        b  = -5; 
	        res = a + b;
		assertTrue("a et b negatif", calc.substract(a, b) != res);
	}

}
