public class TestPostFix {

	public static void main(String[] args) {
		PostfixEvaluator evaluate = new PostfixEvaluator();
		
		String a = "20 2 +";
		int result = evaluate.evaluate(a);
		System.out.printf("The expression %s is equals to %d \n",a,result);
		evaluate.clear();
		
		String d = "5 2 ^";
		result = evaluate.evaluate(d);
		System.out.printf("The expression %s is equals to %d \n",d,result);
		evaluate.clear();
		
		String f = "10 -700 +";
		result = evaluate.evaluate(f);
		System.out.printf("The expression %s is equals to %d \n",f,result);
		evaluate.clear();
		
		String g = "4 9 *";
		result = evaluate.evaluate(g);
		System.out.printf("The expression %s is equals to %d \n",g,result);
		evaluate.clear();
		
		String b = "12 2 5 + - 4 * 2 /";
		result = evaluate.evaluate(b);
		System.out.printf("The expression %s is equals to %d \n",b,result);
		evaluate.clear();
		
		String e = "12 2 5 + - 4 * 2 / 2 ^";
		result = evaluate.evaluate(e);
		System.out.printf("The expression %s is equals to %d \n",e,result);
		evaluate.clear();
		
		String h = "20 0 /";
		result = evaluate.evaluate(h);
		System.out.printf("The expression %s is equals to %d \n",h,result);
		evaluate.clear();
		
		String c = "12 + 1";
		result = evaluate.evaluate(c);
		System.out.printf("The expression %s is equals to %d \n",c,result);
		evaluate.clear();
		
		
	}
}
