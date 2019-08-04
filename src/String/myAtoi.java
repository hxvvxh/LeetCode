package String;
/**
 * 实现 atoi，将字符串转为整数
 * 该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。
 * 如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。
 * 如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数
 * 
 * @author Administrator
 *
 */
public class myAtoi {
public static void main(String[] args) {
	myAtoi m=new myAtoi();
	String s="-4193 +with words";
	int result=m.myAtoi1(s);
	System.out.println(result);
}
public int myAtoi1(String s) {
	double result=0;
	s=s.trim();
	int first=0;
	int end;
	if(s.charAt(0)<'z'&&s.charAt(0)>'a') {
		return 0;
	}else if(s.charAt(0) == '-'||('0'<=s.charAt(0)&&'9'>s.charAt(0))){
		first=0;
	}
//	s=s.replaceAll("[^0-9]", "");
	int end1=0;
	char[] charS= s.toCharArray();
	for(int i=0;i<charS.length;i++) {
		if(('a'<=charS[i]&&'z'<=charS[i])||('A'<=charS[i]&&'Z'<=charS[i])) {
			end1=s.indexOf(charS[i]);
			break;
		}
	}
	int end2=s.indexOf(" ");
	if(end1>end2) {
		end=end2;
	}else {
		end=end1;
	}
	String resultString=s.substring(first, end);
	result=Double.parseDouble(resultString);
	if(result<Integer.MIN_VALUE) {
		result=Integer.MIN_VALUE;
	}else if(result>Integer.MAX_VALUE){
		result=Integer.MAX_VALUE;
	}
	
	return new Double(result).intValue();
}
/**
 * 网上解答
 * @param str
 * @return
 */
public int myAtoi(String str) {
    if (str.length() < 1){
        return 0;
    }

    //过滤字符串开头空格
    int pos = 0;
    while (pos < str.length() && str.charAt(pos) == ' '){
        pos++;
    }
    str = str.substring(pos, str.length());

    //过滤空串
    if ("".equals(str)) {
        return 0;
    }

    //数据为正或负 true为正
    boolean operator = true;

    String numString;

    //字符串开头非数字情况
    if (str.charAt(0) < '0' || str.charAt(0) > '9') {
        //非+或者-不合法返回0
        if (str.charAt(0) != '+' && str.charAt(0) != '-') {
            return 0;
        }
        //数字为负数
        if (str.charAt(0) == '-') {
            operator = false;
        }
        //获取数值
        numString = getNumStr(str.substring(1, str.length()));
    } else {
        numString = getNumStr(str);
    }


    //过滤数据部分为空串的情况
    if ("".equals(numString)) {
        return 0;
    }

    //过滤掉数据超出long的情况
    if (numString.length() > 10) {
        if (operator) {
            return Integer.MAX_VALUE;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    //转化数值
    long num = Long.parseLong(numString);
    if (!operator) {
        num = -num;
    }

    //根据结果范围返回数值
    if (num < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
    }
    if (num > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
    }

    return (int) num;

}

/**
 * 截取字符串的开头数值
 *
 * @param s 字符串
 * @return 数值字符串
 */
private String getNumStr(String s) {
    StringBuilder num = new StringBuilder();
    boolean isStart = true;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (isStart && s.charAt(i) == '0') {
                continue;
            }
            isStart = false;
            num.append(s.charAt(i));
        } else {
            break;
        }
    }

    return num.toString();
}
/**
 * leecode 最快的方法
 * @param str
 * @return
 */
public int myAtoileecode(String str) {
    int len = str.length();
    if (len == 0) {
        return 0;
    }
    char[] cs = str.toCharArray();
    int i = 0;
    while (i < len && cs[i++] == ' ') {

    }
    i--;
    char c1 = cs[i];
    int sig = 1;
    if ((c1 > '9' || c1 < '0')) {
        if (c1 == '-') {
            sig = -1;
            i++;
        } else if (c1 == '+') {
            i++;
        } else {
            return 0;
        }
    }
    long v = 0;
    for (; i < len; i++) {
        char c = cs[i];
        if (c < '0' || c > '9') {
            break;
        }
        /**
         * c - '0'  ASK码的写法  得到是整形的数据
         */
        v = v * 10 + (c - '0');
        if (v * sig > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (v * sig < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
    }
    return (int) (v * sig);
}
}
