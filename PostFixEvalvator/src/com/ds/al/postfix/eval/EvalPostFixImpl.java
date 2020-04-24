package com.ds.al.postfix.eval;

import java.util.Stack;

import com.ds.al.postfix.constants.Constants;

public class EvalPostFixImpl implements EvalPostFix {

	@Override
	public int GetResult(String expr) {
		// TODO Auto-generated method stub
		char exprarr[] = expr.toCharArray();
		Stack<Integer> cal = new Stack<Integer>();
		int a = 1, b = 1, result = 0, num=0;
		for (int i = 0; i < exprarr.length; i++) {
			if (Compare(exprarr[i])) {
				if (!cal.empty()) {
					a = cal.pop();
					b = cal.pop();
					switch (exprarr[i]) {
					case '*':
						result = a * b;
						break;
					case '+':
						result = a + b;
						break;
					case '-':
						result = b - a;
						break;
					case '/':
						result = b / a;

					}
				cal.push(result);
				}

			} else {
				num=Character.getNumericValue(exprarr[i]);
				cal.push(num);
			}

		}
	
		return result;
	}

	public boolean Compare(char c) {
		boolean status = Boolean.FALSE;
		if (c == Constants.SUMOPERATOR || c == Constants.DIFFERENCEOPERATOR || c == Constants.DIVISIONOPERATOR
				|| c == Constants.MULTIPLICATIONOPERATOR) {
			status = Boolean.TRUE;
		}

		return status;
	}

}
