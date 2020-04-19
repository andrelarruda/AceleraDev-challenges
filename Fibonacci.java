
public class Fibonacci {

	// gets the nth term of the sequence in a recursive way
	public static int fib(int term){
		if (term == 1){
			return 0;
		} else if(term == 2){
			return 1;
		} else{
			return fib(term - 1) + fib(term - 2);
		}
	}

	public static ArrayList<Integer> getSequence(){
		ArrayList<Integer> result = new ArrayList<>(20);
		int number = 0;
		for (int i = 1; number <= 350; i++){
			number = fib(i);
			result.add(number);
		}
		return result;
	}

	public static List<Integer> fibonacci() {
		return getSequence();
	}
	
	public static Boolean isFibonacci(Integer a) {
		List<Integer> fibSequence = fibonacci();
		return fibSequence.contains(a);
	}

}
