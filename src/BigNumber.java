import java.util.*;

public class BigNumber {
	/**
	 * List of Integers. BigNumber
	 */
	ArrayList<Integer> BigNumbers = new ArrayList<Integer>();
	
	/**
	 * Constructor that initializes a BigNumber to 0.
	 */
	public BigNumber() {
		BigNumbers.add(0);
	}
	
	/**
	 * Add method that adds BigNumbers to a BigNumber.
	 * @param otherBigNumber the BigNumber that is being 
	 * added to the BigNumber.
	 * @return the BigNumber object. 
	 */
	public BigNumber add(BigNumber otherBigNumber) {
		ArrayList<Integer> otherList = new ArrayList<Integer>();
		Deque<Integer> tempList = new ArrayDeque<Integer>();
		otherList = otherBigNumber.BigNumbers;
		
		int i = 0;
		int j = 0;
		int x = 0;
		int y = 0;
		int carryOver = 0;
		int sum = 0;
		
		while (i < this.BigNumbers.size() && j < otherList.size()) {
			x = this.BigNumbers.get(i++);
			y = otherList.get(j++);
			sum = addInts(x,y,carryOver);
			tempList.addFirst(sum % 10);
			carryOver = sum / 10;
		}
		if (i==j && carryOver > 0) {
			tempList.addFirst(carryOver);
		}
		
		if(i<j) {
			while(i < this.BigNumbers.size()) {
				x = this.BigNumbers.get(i++);
				sum = addInts(x,0,carryOver);
				tempList.addFirst(sum % 10);
				carryOver = sum / 10;
			}
		}
		else {
			while(j < otherList.size()) {
				y = otherList.get(j++);
				sum = addInts(0,y,carryOver);
				tempList.addFirst(sum % 10);
				carryOver = sum / 10;
			}
		}
		BigNumbers.clear();
		while(!tempList.isEmpty())
			BigNumbers.add(tempList.pollLast());
		return this;
	}
	
	/**
	 * add method that adds three integers.
	 * @param x integer element of one of the lists
	 * @param y integer element of one of the lists
	 * @param c integer which is the carryOver
	 * @return the sum of the three integers.
	 */
	private Integer addInts(int x, int y, int c) {
		return x + y + c;
	}
	
	/**
	 * Add method that adds integers to the BigNumber.
	 * @param i the int that is being added to the BigNumber.
	 * @return the BigNumber after the add has been done.
	 */
	public BigNumber add(int other){
		int subSum = 0;
		int sum = 0;
		int carryOver = 0;
		int i = 0;
		
		while (carryOver + other > 0) {
			subSum = (other % 10) + carryOver;
			try {
				sum = BigNumbers.get(i) + subSum;
			}
			catch (IndexOutOfBoundsException e) {
				BigNumbers.add(0);
				sum = subSum;
			}
			finally {
				BigNumbers.set(i++, sum % 10);
				carryOver = sum / 10;
				other = other / 10;
			}
		}
		BigNumbers.trimToSize();;
		return this;
	}
	

	/**
	 * toString representation of the BigNumber.
	 * @return the string. 
	 */
	@Override
	public String toString (){
		StringBuilder s = new StringBuilder();
		for(int i = BigNumbers.size() - 1; i >= 0; i--)
			s.append(BigNumbers.get(i));
		return s.toString();
	}
}