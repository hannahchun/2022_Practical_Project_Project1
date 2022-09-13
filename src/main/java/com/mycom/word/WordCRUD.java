package com.mycom.word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;
    final String fname = "Dictionary.txt";

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

    public void listAll(int level) {
        int j=0;
        System.out.println("\n--------------------------------");
        for(int i = 0 ; i<list.size(); i++) {
            int ilevel = list.get(i).getLevel();
            if(ilevel != level) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            j++;
        }
        System.out.println("--------------------------------");
        System.out.println();

        if(j == 0) {
            System.out.println("해당하는 단어가 없습니다.\n");
        }
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

        if(j == 0) {
            System.out.println("해당하는 단어가 없습니다.\n");
        }

        return idList;
    }

    /* => 원하는 메뉴는? 2
	   => 원하는 레벨은? (1~3) 2
	   ----------------------------------
	   1 *			transfer	옮기다, 이동하다
       2 *			scatter		흩뿌리다, 살포하다
	 */

    @Override
    public void searchLevel() {
        // TODO Auto-generated method stub
        System.out.print("=> 원하는 레벨은? (1: 초급, 2: 중급, 3: 고급) ");
        int level = s.nextInt();
        listAll(level);
    }

    /* => 원하는 메뉴는? 2
	   => 검색할 단어는? er
	   ----------------------------------
	   1 *			transfer	옮기다, 이동하다
       2 *			scatter		흩뿌리다, 살포하다
	 */

    @Override
    public void searchWord() {
        // TODO Auto-generated method stub
        System.out.print("=> 검색할 단어는? ");
        String keyword = s.next();
        listAll(keyword);
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

        if (idlist.size() != 0) {
            System.out.print("=> 수정할 번호 선택 : ");
            int id = s.nextInt();
            s.nextLine();
            System.out.print("=> 뜻 입력 : ");
            String meaning = s.nextLine();
            Word word = list.get(idlist.get(id - 1));
            word.setMeaning(meaning);
            System.out.println("\n단어가 수정되었습니다. ");
            System.out.println();
        }
    }

    /* => 원하는 메뉴는? 6
       => 삭제할 단어 검색 : er

       ----------------------------------
       1 *          transfer	옮기다, 이동하다
       2 *			scatter		흩뿌리다, 살포하다

       => 삭제할 번호 선택 : 1
       => 정말로 삭제하실래요?(Y/n) Y

       단어가 삭제되었습니다.
    */

    @Override
    public void delete() {
        System.out.print("=> 삭제할 단어 검색: ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        if (idlist.size() != 0) {
            System.out.print("=> 삭제할 번호 선택 : ");
            int id = s.nextInt();
            s.nextLine();
            System.out.print("=> 정말로 삭제하실래요?(Y/n) : ");
            String ans = s.next();
            if (ans.equalsIgnoreCase("y")) {
                list.remove((int) idlist.get(id - 1)); // 해당 인덱스의 객체 삭
                // java.util.ArrayList.remove(Object o)는 객체 혹은, 정수로 어떤 인덱스의 객체를 삭제할지 지정해야
                System.out.println("\n단어가 삭제되었습니다. ");
            } else
                System.out.println("\n취소되었습니다. ");
            System.out.println();
        }
    }

    public void loadFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;
            while(true) {
                line = br.readLine();
                if(line==null) break;

                String data[]=line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0, level, word, meaning));
                count++;
            }
            br.close();
            System.out.println(count + "개 로딩 완료!!!\n");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void saveFile() {
        // TODO Auto-generated method stub
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("Dictionary.txt"));
            for(Word one : list) {
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("\n데이터 저장 완료 !!!\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
