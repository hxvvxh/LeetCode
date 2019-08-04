package Other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 * 
 * @author Administrator
 *
 */
public class isValid {
	public static void main(String[] args) {
		isValid is = new isValid();
		boolean s = is.test("{{)}");
		System.out.println(s);
	}

public boolean test(String s) {
	char[] charS=s.toCharArray();
	int r=charS.length%2;
	if(r!=0) {
		return false;
	}
	Map map=new HashMap();
	map.put('(', ')');
	map.put('(', ')');
	map.put('[', ']');
	map.put('{', '}');
	
	boolean result1=true;
	boolean result2 = true;
	int index=charS.length/2;
	for(int i=0;i<charS.length;i=i+2) {
		try {
	   if(map.get(charS[i]).equals(charS[i+1])) {
		   continue;
	   }else {
		   result1=false;
	   }
		}catch(Exception e) {
			result1=false;
		}

	}
	for(int i=0;i<index;i++) {
		try {
		if(map.get(charS[i]).equals(charS[charS.length-i-1])) {
			continue;
		}else {
			result2=false;
		}
		}catch(Exception e) {
			result2=false;
		}
	}
	
	return result1||result2;
}
public static boolean isValid(String s) {
    Stack<Character> stack = new Stack();
    char[] chars = s.toCharArray();
    for (char c : chars) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if(stack.isEmpty())
                return false;
            if (c == ')' && stack.pop() != '(')
                return false;
            if (c == '}' && stack.pop() != '{')
                return false;
            if (c == ']' && stack.pop() != '[')
                return false;
        }
    }
    //最终符合有效字符的情况是：stack应该为空！
    return stack.isEmpty();
}
}
