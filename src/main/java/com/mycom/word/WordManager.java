package com.mycom.word;

import java.util.Scanner;

public class WordManager {

    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;

    WordManager() {
        wordCRUD = new WordCRUD(s);
    }

    public void start() {
        // 파일에서 데이터를 읽어와서 리스트를 만들어놓고 시작
        wordCRUD.loadFile();

        while(true) {
            int menu = selectMenu();
            if(menu == 0) {
                System.out.println("\n프로그램 종료!\n");
                break;
            }

            else if(menu == 1) { // list
                wordCRUD.listAll();
            }
            else if(menu == 2) { // search by level
                wordCRUD.searchLevel();
            }
            else if(menu == 3) { // search a specific word
                wordCRUD.searchWord();
            }
            else if(menu == 4) { // create
                wordCRUD.add();
            }
            else if(menu == 5) { // update
                wordCRUD.update();
            }
            else if(menu == 6) { // delete
                wordCRUD.delete();
            }
            else if(menu == 7) { // save data in file
                wordCRUD.saveFile();
            }
        }
    }

	/*
	 *** 영단어 마스터 ***
	 ********************
	 1. 모든 단어 보기
	 2. 수준별 단어 보기
	 3. 단어 검색
	 4. 단어 추가
	 5. 단어 수정
	 6. 단어 삭제
	 7. 파일 저장
	 0. 나가기
	 ********************
	 => 원하는 메뉴는?
	 */

    public int selectMenu() {
        System.out.print("*** 영단어 마스터 ***\n" + "********************\n" + ""
                + "1. 모든 단어 보기\n"
                + "2. 수준별 단어 보기\n"
                + "3. 단어 검색\n"
                + "4. 단어 추가\n"
                + "5. 단어 수정\n"
                + "6. 단어 삭제\n"
                + "7. 파일 저장\n"
                + "0. 나가기\n"
                + "********************\n"
                + "=> 원하는 메뉴는? ");
        return s.nextInt();
    }
}
