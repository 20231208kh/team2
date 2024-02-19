import java.util.Scanner;

public class asdf {
	public static void main(String args[]) {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("번호를 입력");
		int number=scan.nextInt();
		System.out.println("내용 입력");
		scan.nextLine();
		String content=scan.nextLine();
		System.out.println("문자 입력");
		String con=scan.next();
		
		
		System.out.println("번호 : "+ number);
		System.out.println("내용 : "+content);
		System.out.println("문자 : "+ con);
	}

}
