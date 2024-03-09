import java.util.*;

class Calculator {

    /**
     * Evaluates the given mathematical expression and returns the result.
     *
     * @param expression The mathematical expression to evaluate.
     * @return The result of the evaluation.
     * @throws IllegalArgumentException if the expression contains non-digit characters or operators.
     */
    public double evaluate(String expression) {
        List<String> tokens = tokenize(expression);

        // Perform multiplication operations first
        for (int i = 1; i < tokens.size(); i += 2) {
            if (tokens.get(i).equals("*")) {
                double prevNumeral = Double.parseDouble(tokens.get(i - 1));
                double nextNumeral = Double.parseDouble(tokens.get(i + 1));
                double multiplicationResult = prevNumeral * nextNumeral;
                // Remove numerals and * operator, replace with result
                tokens.remove(i - 1);
                tokens.remove(i - 1);
                tokens.set(i - 1, String.valueOf(multiplicationResult));
                // Adjust loop counter to account for removed tokens
                i -= 2;
            }
        }
        // Evaluate the remaining expression
        return getResult(tokens);
    }

    /**
     * Computes the result of a List of tokens passed to it.
     *
     * @param tokens The tokens representing the expression.
     * @return The result of the evaluation.
     * @throws IllegalArgumentException if the expression contains invalid operators.
     */
    private static double getResult(List<String> tokens) {
        double result = Double.parseDouble(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            String operator = tokens.get(i);
            double operand = Double.parseDouble(tokens.get(i + 1));
            // Perform addition or subtraction based on the operator
            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }
        return result;
    }

    /**
     * Tokenizes a given expression into a list of numbers and operators.
     *
     * @param expression The expression to tokenize.
     * @return A list of "tokens" of numbers and operators.
     * @throws IllegalArgumentException if the expression contains non-numeral/operator characters.
     */
    private List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                currentToken.append(c);
            } else if (isOperator(c)) {
                if (currentToken.length() != 0) {
                    tokens.add(currentToken.toString());
                    currentToken = new StringBuilder();
                }
                tokens.add(String.valueOf(c));
            } else {
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
        }
        // Add the last token if any
        if (!currentToken.isEmpty()) {
            tokens.add(currentToken.toString());
        }
        return tokens;
    }

    /**
     * Checks if the given character is a valid operator.
     *
     * @param c The character to be checked.
     * @return True if the character is a valid operator, false otherwise.
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
