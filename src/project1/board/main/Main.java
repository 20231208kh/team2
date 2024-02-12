package project1.board.main;

import java.util.Scanner;

import project1.board.controller.BoardContorller;
import project1.board.controller.MemberContorller;
import project1.board.controller.PostController;
import project1.board.service.PrintService;
import project1.board.service.PrintServiceImp;

public class Main {
	private static BoardContorller boardController;
	private static MemberContorller memberContorller;
	private static PostController postController;
	private static PrintService printService = new PrintServiceImp();
	public static void main(String[] args) {
		int menu;
		Scanner scan = new Scanner(System.in);
		do {
			printService.startMenu();
			menu = scan.nextInt();
		}while(menu !=3);
		
	}

}
