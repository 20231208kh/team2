package prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PracMain {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		// TODO Auto-generated method stub
		List<Prac> mainList = new ArrayList<Prac>(); //list를 가지고 있는 mainList
		List<PracList> list = new ArrayList<PracList>(); //작은 것
		
		PracList pracList4 = new PracList("d","c",456);
		
		Prac prac1 = new Prac("tjrgns","박성훈",123, list);	//아이디,이름,번호,리스트
		Prac prac2 = new Prac("tjrgns1","전태규",456, list);
		Prac prac3 = new Prac("tjrgns2","전성일",789, list);
		
		
		mainList.add(prac1);
		mainList.add(prac2);
		mainList.add(prac3);
		
		PracList pracList1 = new PracList("tjr","박석훈",123); //아이디,이름,번호
		PracList pracList2 = new PracList("gns","김준수",456);
		PracList pracList3 = new PracList("dx","김태원",789);
		
		
		list.add(pracList1);
		list.add(pracList2);
		list.add(pracList3);
		
		
	
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.println( mainList.get(i).getId()+" 큰 리스트 "+mainList.get(i).getList().get(j).getId()+ " 작은 리스트");
			}
			
		}
		
		System.out.println();
		
		System.out.println(mainList.get(0).getList().get(1).getName());
		if(mainList.get(0).getList().get(1).getName()=="김준수")
		{
			mainList.get(0).getList().get(1).setName("김석훈");
			System.out.println("큰 리스트 0번지 작은 리스트 1번지에 있는 사람의 이름은 "+mainList.get(0).getList().get(1).getName());
		}
	
		
		System.out.println("아이디 입력");
		String id=scan.next();
		
		Prac in =new Prac(id);
		
	
		System.out.println(mainList.contains(in)); //mainList에 아이디를 가지고 equals를 통해 있는지 물어봄
		System.out.println(mainList.indexOf(in));	//mailList에 아이디를 가지고 equal를 통해 인덱스 번호 찾기
		
		System.out.println("아이디 입력");
		String ids=scan.next();
		
		PracList out = new PracList(ids);
		
		System.out.println(mainList.get(0).getList().indexOf(out)); //아이디를 입력받고 해당 아이디를 작은 리스트의 번호를 얻어옴
		int index2=mainList.get(0).getList().indexOf(out); // index2에 받아온 것을 넣어주고
		
		System.out.println(mainList.get(0).getList().get(index2).getName()); //변경전: 그리고 해당 작은 리스트에 해당하는 번지에서 이름을 가져옴
		
		mainList.get(0).getList().get(index2).setName("김민주");	//해당 작은 리스트에 해당하는 번지에서 이름을 변경 해줌
		
		System.out.println("수정이 완료됨 "+ mainList.get(0).getList().get(index2).getName()); // 변경 후 : 해당 이름 출력
		System.out.println(mainList.get(0).getList().get(index2).getName());
		
		
		
		
	
		
		//String 형식으로 큰 리스트 0번지에 있는 작은 리스트에서 김준수를-> 김석훈으로 바꿈
		
		
		
		//mainList 안에 있는  list에 "tjr"이 있다면 "qkrtjrgns"으로 수정하기
		
		
		
//		mainList.get(0).getList().get(1).setName("박석훈");             				//mainlist에 있는 prac1에 접근하고 -> list에 접근해서 1번지에 있는 아이디를 박석훈으로 바꾼다
//		System.out.println("이름은 "+ mainList.get(0).getList().get(1).getName()); 		
//																					
//																					
//		System.out.println();
//		
//		Prac prac5 = new Prac("c");
//		
//		System.out.println(mainList.contains(prac5));
//		System.out.println(mainList.indexOf(prac5));			//mainlist에 있는 prac2가 내가 임시로 만든 prac5 id가 "a" 와 같은지 비교
//		
//		
//		PracList pract = new PracList("e");
		
		
		
		
//		System.out.println(mainList.get(0).getList().contains(pract));
//		System.out.println(mainList.get(0).getList().indexOf(pract));
//		
//		int index = mainList.get(0).getList().indexOf(pract);
//		
		

//		System.out.println("list아이디:");
//		String id1 =scan.next();
//		System.out.println("이름:");
//		String name1 =scan.next();
//		System.out.println("번호:");
//		int num1 =scan.nextInt();
//		
//		PracList prc2 = new PracList(id1);
//		
//		list.add(prc2);
		
		//큰 리스트에서 3번지에 접근하고 작은 리스트에 접근해서 모두 출력하기
	
		
		//mainList(아이디,이름 번호 ,list)-> list(아이디,번호,이름)
		
		//입력받은 값으로 1차원리스트 수정 -> contains를 쓰고 indexOf를 사용하여
		
		
			
		//입력받은 값으로 2차원리스트 수정
		
		//멤버변수 다바꾸기
		
		//삭제
		
		
		
		
		
		
		
				
				
		
		

		
		
		
	}
	}


