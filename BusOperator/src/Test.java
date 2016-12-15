
public class Test {
	
	public static void main(String[] args){
		int n = 10;
		for(int i = 0; i < 10000; i++){
			n += 1;
			if(n == 15){
				System.out.println("Loop stopped");
				break;
			}
			System.out.println(n);
		}
	}

}
