package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;

    /*
     * => 난이도(1,2,3) & 새 단어 입력 : 1 driveway
     * 뜻 입력: 차고 진입로
     * 새 단어가 단어장에 추가되었습니다.
     */

    WordCRUD (Scanner s) {
        list = new ArrayList<Word>();
        this.s = s;
    }

    @Override
    public Object add() {
        System.out.print("\n=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();
        System.out.println();

        return new Word(0, level, word, meaning);
    }

    public void addWord() { // WordManager에서 호출할 함수이기에,
        Word one = (Word) add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다.");
        System.out.println();
    }

    @Override
    public int update(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void selectOne(int id) {
        // TODO Auto-generated method stub

    }

    public void listAll() {
    }
}
