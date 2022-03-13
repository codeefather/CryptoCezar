package com.company;

import java.util.*;

public class Main {
        public static final String[] alphabet = {"А", "Б", "В","Г","Д","Е","Ё","Ж","З","И","К","Л","М","Н",
            "О","П","Р","С","Т","У","Ф","Х","Ц","Ш","Щ","Ъ","Ы","Ь","Э","Ю","Я"};
        public static final char[] alphabetChar = new char[]{
                'А', 'Б', 'В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н',
                'О','П','Р','С','Т','У','Ф','Х','Ц', 'Ч', 'Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};
        public static final char[] punctuation = new char[]{'.',',','\"','\'',':',';','-','!','?',' '};
        //public static HashMap<Integer, Character> punctuationMap = new HashMap<>();
        public static TreeMap<Integer, Character> punctuationMap = new TreeMap<>();

    public static void main(String[] args) {

        String textInput = "щука? сидит, на крыльце!";


        System.out.println("Входной текст:");
        System.out.println(textInput);

        System.out.println("Корректировка текста...........");
        System.out.println("Запоминаем пунктуацию....");
        readPunctuation(textInput);
        System.out.println("Удаляем пунктуацию.....");
        String deletedPunctuationText = deletePunctuation(textInput);
        System.out.println(deletedPunctuationText);
        System.out.println("Восстанавливаем пунктуацию");
        System.out.println(writePunctuation(deletedPunctuationText));
        System.out.println("Зашифрованный текст:");
        System.out.println(encryptText(textInput, 9));

    }

    public static String encryptText(String input, int move){
        String cryptText = "";
        readPunctuation(input);
        char[] inputChar = input.toCharArray();

        for (int i = 0; i < inputChar.length; i++) {
            for (int j = 0; j < alphabetChar.length; j++) {
                if(inputChar[i] == Character.toLowerCase(alphabetChar[j])){
                    try {
                        cryptText = cryptText + alphabetChar[j + move];
                    } catch (ArrayIndexOutOfBoundsException e){
                        int indexOutBounds = move - (32-j);
                        cryptText = cryptText + alphabetChar[indexOutBounds - 1];
                    }
                }
            }
        }
        return cryptText;
    }

    // + функция для поставки индекса символов пунктуации в текст
    // функция для удаления символов пунктуации из текста
    // + функция для записи индекса символов пунктуации
    // + Добавить таблицу ключ - значение с:
    //      Индекс - ключ, куда надо подставить символ
    //      значением - символом


    public static void readPunctuation(String input){
        char[] inputChar = input.toCharArray();
        for (int i = 0; i < inputChar.length; i++) {
            for (int j = 0; j < punctuation.length; j++) {
                if(inputChar[i] == punctuation[j]){
                    punctuationMap.put(i, inputChar[i]);
                }
            }
        }
    }


    public static String writePunctuation(String input){
        List<Character> testChar = new ArrayList<>();
        Set<Integer> keys = punctuationMap.keySet();

        for (int i = 0; i < input.length(); i++) {
            if(Character.isAlphabetic(input.charAt(i))) {
                testChar.add(input.charAt(i));
            }
        }


        for (Integer key : keys)
        {
            char value = punctuationMap.get(key);
            testChar.add(key, value);
        }

        return testChar.toString();
    }

    public static String deletePunctuation(String input){

        char[] testArray = input.toCharArray();
        List<Character> testChar = new ArrayList<>();
        List<Integer> indexNeedToDelete = new ArrayList<>();
        String deletedText;

        for (char value : testArray) {
            testChar.add(value);
        }

        for (int i = 0; i < testChar.size(); i++) {
            for (char c : punctuation) {
                if (testChar.get(i).equals(c)) {
                    indexNeedToDelete.add(i);
                }
            }
        }

        for (int i = 0; i < indexNeedToDelete.size(); i++) {
            testChar.remove(indexNeedToDelete.get(i) - i);
        }

        deletedText = testChar.toString();

        return deletedText;
    }



}
