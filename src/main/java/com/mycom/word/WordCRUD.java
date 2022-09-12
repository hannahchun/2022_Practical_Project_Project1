package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;

    WordCRUD (Scanner s) {
        list = new ArrayList<Word>();
        this.s = s;
    }

    /*
        => 원하는 메뉴는? 1
            --------------------------------
            1 *** 		superintendent   관리자, 감독관
            2 * 			  electric	 전기의, 전기를 생산하는
            3 ** 		     equipment	 장비, 용품
            4 * 		          pole 	 기둥, 장대
            --------------------------------
    */

    public void listAll() {
        System.out.println("\n--------------------------------");
        for(int i = 0 ; i<list.size(); i++) {
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
        System.out.println();
    }

    /*
     * => 난이도(1,2,3) & 새 단어 입력 : 1 driveway
     * 뜻 입력: 차고 진입로
     * 새 단어가 단어장에 추가되었습니다.
     */

    @Override
    public void add() {
        System.out.print("\n=> 난이도(1,2,3) 입력 : ");
        int level = s.nextInt();
        s.nextLine();
        System.out.print("=> 새 단어 입력 : ");
        String word = s.nextLine();
        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        System.out.println();

        Word one = new Word(0, level, word, meaning);
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다.");
        System.out.println();
    }

    public ArrayList<Integer> listAll(String keyword) {
        ArrayList<Integer> idList = new ArrayList<>();
        int j=0;
        System.out.println("\n--------------------------------");
        for(int i = 0 ; i<list.size(); i++) {
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idList.add(i);
            j++;
        }
        System.out.println("--------------------------------");
        System.out.println();
        return idList;
    }

    /*
       => 원하는 메뉴는? 5
       => 수정할 단어 검색 : er

       ----------------------------------
       1 *			transfer	옮기다, 이동하다
       2 *			scatter		흩뿌리다, 살포하다

       => 수정할 번호 선택 : 1
       => 뜻 입력 : 옮기다, 이동하다, 이동, 전송

       단어가 수정되었습니다.
     */

    @Override
    public void update() {
        System.out.print("=> 수정할 단어 검색: ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("\n단어가 수정되었습니다. ");
        System.out.println();
    }

}
