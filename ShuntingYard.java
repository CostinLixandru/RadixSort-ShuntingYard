import java.util.Deque;
import java.util.LinkedList;

public class ShuntingYard {
	public static boolean compare(char x, char y) {
		if(x=='^' && (y=='+' || y=='-' || y=='*' || y=='/')) {
			return true;
		}
		else if((x=='*' || x=='/') && (y=='+' || y=='-' || y=='*' || y=='/') ) {
			return true;
		}else if((x=='+' || x=='-') && (y=='+' || y=='-' )) {
			return true;
		}
		return false;
	}
	public static String ShntingYard(String sS) {
		char[] asd = sS.toCharArray();
		StringBuilder sc = new StringBuilder();
		Deque<Character> listaOp1 = new LinkedList<Character>();
		for(int i=0; i<asd.length; i++) {
			if(Character.isDigit(asd[i])) {
				sc.append(asd[i]);
			}else if(asd[i]=='+' || asd[i]=='-' || asd[i] == '/' || asd[i]=='*' || asd[i]=='^') {
				while(listaOp1.size()>0 && listaOp1.peek()!='(' && (compare(listaOp1.peek(), asd[i]) || listaOp1.peek()==asd[i] && 
						(listaOp1.peek()!='^') )) {
					sc.append(listaOp1.pop());
				}
				listaOp1.push(asd[i]);
			}else if(asd[i]=='(') {
				listaOp1.push(asd[i]);
			}else if(asd[i]==')') {
				while(listaOp1.peek()!='(') {
					sc.append(listaOp1.pop());
				}if(listaOp1.size()==0) {
					System.out.println("Eroare, parantezele nu sunt puse corect");
				}
				listaOp1.pop();

			}

		}
		while(listaOp1.size()>0) {			
			if(listaOp1.peek()=='(') {
				System.out.println("Eroare, parantezele nu sunt puse corect");
				break;
			}
			sc.append(listaOp1.pop());
		}
		return sc.toString();
	}
	public static int calculateShntingYard(String sS) {
		char[] asd = sS.toCharArray();
		Deque<Integer> listaOp = new LinkedList<Integer>();
		for(int i=0; i<asd.length;i++) {
			if(Character.isDigit(asd[i])) {
				listaOp.push(Character.getNumericValue(asd[i]));
				System.out.println(Character.getNumericValue(asd[i]));
			}else {
				if(listaOp.peek()==null) {
					System.out.println("expresia postfixata este gresita");
					return asd[-1];
				}
				int Op1 = listaOp.pop();
				if(listaOp.peek()==null) {
					System.out.println("expresia postfixata este gresita");
					return asd[-1];
				}
				int Op2 = listaOp.pop();
				switch(asd[i]) {
					case '+':
						listaOp.push(Op2+Op1);
						break;
					case '-':
						listaOp.push(Op2-Op1);
						break;
					case '*':
						listaOp.push(Op2*Op1);
						break;
					case '/':
						listaOp.push(Op2/Op1);
						break;
					case '^':
						int a = (int)Math.pow(Op2, Op1);    
						listaOp.push(a);
						break;
					default:
						System.out.println("expresia postfixata este gresita");
						break;
				}
			}
		}
		int rezultat = listaOp.pop();
		if(!listaOp.isEmpty()) {
			System.out.println("expresia postfixata este gresita");
			return asd[-1];
		}
		return rezultat;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3+(2+1)*2^3^2-8/(5-1*2/2)";		
		System.out.println(ShntingYard(s));
		System.out.println();
		System.out.println(calculateShntingYard(ShntingYard(s)));
		System.out.println();
		int a = 3+(2+1)*(int)(Math.pow(2, 3))-8/(5-1*2/2);
		System.out.println(a);
	}

}
