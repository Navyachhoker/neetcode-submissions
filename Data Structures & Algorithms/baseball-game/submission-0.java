class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("+")) {

                int first = stack.pop();
                int second = stack.peek();

                int sum = first + second;

                stack.push(first);
                stack.push(sum);

            }
            else if (op.equals("D")) {

                stack.push(stack.peek() * 2);

            }
            else if (op.equals("C")) {

                stack.pop();

            }
            else {

                stack.push(Integer.parseInt(op));
            }
        }

        int total = 0;

        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }
}