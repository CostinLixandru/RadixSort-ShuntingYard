import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class RadixSort {
	public static Deque<String> zeros(int[] asd, int nrMaxLength) {
		Deque<String> list = new LinkedList<String>();
		for(int i=0; i<asd.length;i++) {
			switch(nrMaxLength) {
				case 1:
					list.add(String.format("%01d", asd[i]));
					break;
				case 2:
					list.add(String.format("%02d", asd[i]));
					break;
				case 3:
					list.add(String.format("%03d", asd[i]));
					break;
				case 4:
					list.add(String.format("%04d", asd[i]));
					break;
				case 5:
					list.add(String.format("%05d", asd[i]));
					break;
				case 6:
					list.add(String.format("%06d", asd[i]));
					break;
				case 7:
					list.add(String.format("%07d", asd[i]));
					break;
				default:
					break;
			}
		}
		return list;
	}
	public static Deque<String> RadixC(Deque<String> list, int nrMaxLength) {	
		Deque<String>[] asd = new Deque[10];		
		for(int i=0; i<10; i++) {
			asd[i]= new LinkedList<String>();
		}
		for(int i=nrMaxLength-1; i>=0;i--) {
			for(int j=0; j<list.size();) {
				switch(list.peek().charAt(i)) {
					case '0':
						asd[0].offer(list.poll());
						break;
					case '1':
						asd[1].offer(list.poll());
						break;
					case '2':
						asd[2].offer(list.poll());
						break;
					case '3':
						asd[3].offer(list.poll());
						break;
					case '4':
						asd[4].offer(list.poll());
						break;
					case '5':
						asd[5].offer(list.poll());
						break;
					case '6':
						asd[6].offer(list.poll());
						break;
					case '7':
						asd[7].offer(list.poll());
						break;
					case '8':
						asd[8].offer(list.poll());
						break;
					case '9':
						asd[9].offer(list.poll());
						break;
					default:
						break;
				}
			}
			for(int k=0; k<asd.length;k++) {
				while(asd[k].size()>0) {
				list.offer(asd[k].poll());
				}
			}
		}
		return list;
	}
	public static Deque<String> RadixDc(Deque<String> list, int nrMaxLength) {	
		Deque<String>[] asd = new Deque[10];		
		for(int i=0; i<10; i++) {
			asd[i]= new LinkedList<String>();
		}
		for(int i=nrMaxLength-1; i>=0;i--) {
			for(int j=0; j<list.size();) {
				switch(list.peek().charAt(i)) {
					case '0':
						asd[0].offer(list.poll());
						break;
					case '1':
						asd[1].offer(list.poll());
						break;
					case '2':
						asd[2].offer(list.poll());
						break;
					case '3':
						asd[3].offer(list.poll());
						break;
					case '4':
						asd[4].offer(list.poll());
						break;
					case '5':
						asd[5].offer(list.poll());
						break;
					case '6':
						asd[6].offer(list.poll());
						break;
					case '7':
						asd[7].offer(list.poll());
						break;
					case '8':
						asd[8].offer(list.poll());
						break;
					case '9':
						asd[9].offer(list.poll());
						break;
					default:
						break;
				}
			}
			for(int k=asd.length-1; k>=0;k--) {
				while(asd[k].size()>0) {
				list.offer(asd[k].poll());
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nr = {98, 12, 11, 202, 9001, 11023, 107,67, 90,101,1007,98,76};
		
		System.out.println(RadixC(zeros(nr,5),5));
		System.out.println(RadixDc(zeros(nr,5),5));
	}

}
