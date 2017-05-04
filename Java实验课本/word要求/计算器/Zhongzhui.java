
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zhongzhui {

    public static String getResult(String data) {
            try {
                List<Object> list = trans(data);
                Stack<Double> result = new Stack<>();
                return Double.toString( f(list,result) );
            } catch (Exception e) {
                return "输入有误";
            }
    }

    //计算后缀表达式的值
    private static double f(List<Object> list, Stack<Double> result) {
        for (Object item : list) {
            String m = item.toString();
            if (m.equals("+") || m.equals("-") || m.equals("*") || m.equals("/") || m.equals("%") || m.equals("^")) {
                double b = result.pop();
                double a = result.pop();
                double v = g(a, b, m);
                result.push(v);
            } else {
                result.push(Double.valueOf(m));
            }
        }
        return(result.pop());
    }

    //运算方法
    private static double g(double a, double b, String m) {
        double v=0;
        System.out.println(a +" " + m + " "+b);
        switch (m) {
            case "+":
                v=a+b;
                break;
            case "-":
                v=a-b;
                break;
            case "*":
                v=a*b;
                break;
            case "/":
                v=a/b;
                break;
            case "^":
                v= Math.pow(a,b);
                break;
            case "%":
                v=a%b;
                break;
        }
        return v;
    }

    //中缀表达式转化为后缀表达式，可处理括号，浮点正则表达式匹配double小数
    private static List<Object> trans(String s) {
        Stack<Character> op=new Stack<>();

        ArrayList<Object> list=new ArrayList<>();
        Pattern P=Pattern.compile("[0-9]+(\\.[0-9]+)?");   //正则表达式来处理带小数点的数字
        int i=0;

        while(i<s.length()){
            char c=s.charAt(i);
            if (c>='0'&&c<='9') {
                String s1=s.substring(i);
                Matcher m =P.matcher(s1);
                if (m.find()) {    //取匹配到的第一个数字
                    s1=m.group();
                    list.add(s1);
                }
                i=i+s1.length();
                continue;
            }else if (c=='(') {
                op.push(c);
            }else if (c==')') {
                char p=op.pop();
                while(p!='('){
                    list.add(p);
                    p=op.pop();
                }
            }else if (c=='+'||c=='-') {
                while(!op.isEmpty()&&(op.peek()=='+'||op.peek()=='-'||op.peek()=='*'||op.peek()=='/'||op.peek()=='%'||op.peek()=='^'))
                    list.add(op.pop());                               //弹出栈中所有比手上运算符优先级高或相等的运算符
                op.push(c);
            }else if (c=='*'||c=='/'||c=='%') {
                while(!op.isEmpty()&&(op.peek()=='*'||op.peek()=='/'||op.peek()=='%'||op.peek()=='^'))
                    list.add(op.pop());                               //对于 */% 弹出栈中所有比手上运算符优先级高或相等的运算符
                op.push(c);
            } else if(c=='^'){
                while(!op.isEmpty()&&op.peek()=='^')
                    list.add(op.pop());                               //对于 ^ 弹出栈中所有比手上运算符优先级高或相等的运算符
                op.push(c);
            }
            i++;
        }
        while(!op.isEmpty()){
            list.add(op.pop());
        }
        return list;
    }

}