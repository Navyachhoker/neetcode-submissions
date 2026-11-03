class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean alive = true;

            while (alive &&
                   asteroid < 0 &&
                   !stack.isEmpty() &&
                   stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    // Top asteroid explodes
                    stack.pop();
                }
                else if (stack.peek() == -asteroid) {
                    // Both explode
                    stack.pop();
                    alive = false;
                }
                else {
                    // Current asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        int[] ans = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}