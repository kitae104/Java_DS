package utils.input.regexp;

import java.util.StringTokenizer;

// 정규표현식을 이용한 입력 사용하기 
public class RegExpInput
{

	public static void main(String[] args)
	{
		String regExp = "\\s*[a-zA-Z]+";  // 정규식 
		String regExp2 = "\\s";  // 공백 
		String strTest = "{a(b[c[d]e]f)g}";
		String strTest2 = "36 * ( 2 + 56 / 7)";
		
//		String[] strArr = strTest.split(regExp);
//		for (String str : strArr)
//		{
//			System.out.println(str);
//		}
		
		
		StringTokenizer st = new StringTokenizer(strTest2, "+-*/(){}[]",true); // 공백 고려
		
		int i = 1;
		while(st.hasMoreTokens())
		{
			System.out.println(i++ + "번째 토큰 : " + st.nextToken().trim());
		}
		

	}

}
