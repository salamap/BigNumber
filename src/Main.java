
public class Main {

	public static void main(String[] args) {
		
		BigNumber bn = new BigNumber();
		bn.add(0);
		
		System.out.println(bn);
		bn = bn.add(1);
		System.out.println(bn);
		
		for(int i = 0; i < 100; i++){
			bn = bn.add(bn);
			System.out.println(bn);
		}
		System.out.println("2^100 = " + bn);

		bn = new BigNumber();
		bn = bn.add(10);
		
		for(int i = 0; i <100; i++){
			BigNumber temp = new BigNumber();
			temp = temp.add(bn);
			for(int j = 0; j < 9; j++){
				bn = bn.add(temp);
			}
			System.out.println(bn);
		}
		System.out.println("10^100 = " + bn);
	}
}
