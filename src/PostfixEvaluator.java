public class PostfixEvaluator {
	private StackADT<Integer> values;
	private String nextChar;
	private int operandOne;
	private int operandTwo;
	private int result;

	public PostfixEvaluator() {
		values = null;
		nextChar = "";
		operandOne = 0;
		operandTwo = 0;
		result = 0;
	}

	public void clear() {
		values.clear();
	}

	public int evaluate(String input) {

		if (input == null) {
			throw new RuntimeException("Invalid postfix expression");
		}

		values = new ArrayStack<Integer>(input.length());

		for (int i = 0; i < input.length(); i++) {
			// System.out.println(input.charAt(i));
			for (int j = i; j < input.length(); j++) {
				if (!(Character.isWhitespace(input.charAt(j)))
						&& Character.isDigit(input.charAt(j))) {
					nextChar += input.charAt(j);
					i++;
				} else if (input.charAt(i) == '+' || input.charAt(i) == '-'
						|| input.charAt(i) == '/' || input.charAt(i) == '*'
						|| input.charAt(i) == '^') {
					nextChar = Character.toString(input.charAt(j));

					while (i < input.length() - 1 && nextChar.startsWith("-")
							&& !(Character.isWhitespace(input.charAt(i + 1)))
							&& Character.isDigit(input.charAt(i + 1))) {
						nextChar += input.charAt(i + 1);
						i++;
					}
					break;
				} else {
					break;
				}
			}

			switch (nextChar) {
			case "/":
				
				try {
					operandTwo = values.pop();
					operandOne = values.pop();
					result = operandOne / operandTwo;
				} catch (Exception e) {
					throw new RuntimeException("Invalid postfix expression");
				}
				
				values.push(result);
				nextChar = "";
				break;
			case "*":
				try {
					operandTwo = values.pop();
					operandOne = values.pop();
				} catch (Exception e) {
					throw new RuntimeException("Invalid postfix expression");
				}
				result = operandOne * operandTwo;
				values.push(result);
				nextChar = "";
				break;
			case "+":
				try {
					operandTwo = values.pop();
					operandOne = values.pop();
				} catch (Exception e) {
					throw new RuntimeException("Invalid postfix expression");
				}

				result = operandOne + operandTwo;
				values.push(result);
				nextChar = "";
				break;
			case "-":
				try {
					operandTwo = values.pop();
					operandOne = values.pop();
				} catch (Exception e) {
					throw new RuntimeException("Invalid postfix expression");
				}
				result = operandOne - operandTwo;
				values.push(result);
				nextChar = "";
				break;
			case "^":
				try {
					operandTwo = values.pop();
					operandOne = values.pop();
				} catch (Exception e) {
					throw new RuntimeException("Invalid postfix expression");
				}
				result = (int) Math.pow(operandOne, operandTwo);
				values.push(result);
				nextChar = "";
				break;

			default:
				if (!(nextChar.isEmpty())) {
					values.push(Integer.parseInt(nextChar));
					// System.out.println(values.peek());
					nextChar = "";
				}
				break;
			}
		}
		if (values.isEmpty() || values.size()!=1) {
			throw new RuntimeException("Unvalid postfix expression");
		}
		return values.peek();
	}
}
