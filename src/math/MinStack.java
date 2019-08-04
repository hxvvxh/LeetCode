package math;
/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

    push(x) -- 将元素 x 推入栈中。
    pop() -- 删除栈顶的元素。
    top() -- 获取栈顶元素。
    getMin() -- 检索栈中的最小元素。

示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.


 * @author Administrator
 *
 */
public class MinStack {
	public static int minStack = 100;

	public int index = 0;

	public int[] stack;

	public MinStack() {
		this.stack = new int[minStack];

	}

	public void push(int x) {
		if (index == minStack) {
			int[] maxStack = new int[minStack * 2];
			for (int i = 0; i < minStack; i++) {
				maxStack[i] = stack[i];
			}
			stack = maxStack;
		}
		stack[index] = x;
		index++;

	}

	public void pop() {
		if (index > 0) {
			index--;
		}

	}

	public int top() {
		if (index == 0) {
			throw new IndexOutOfBoundsException();
		}
		return stack[index - 1];

	}

	public int getMin() {
		if (index > 0) {
			int min = stack[0];
			for (int i = 1; i < index; i++) {
				if (min > stack[i]) {
					min = stack[i];
				}
			}
			return min;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
}
