package com.company;

public class Main {

        //public static final String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦШЩЪЫЬЭЮЯ";
        public static final String[] alphabet = {"А", "Б", "В","Г","Д","Е","Ё","Ж","З","И","К","Л","М","Н",
            "О","П","Р","С","Т","У","Ф","Х","Ц","Ш","Щ","Ъ","Ы","Ь","Э","Ю","Я"};
        public static final char[] alphabetChar = new char[]{
                'А', 'Б', 'В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н',
                'О','П','Р','С','Т','У','Ф','Х','Ц', 'Ч', 'Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я',};
        public static final String punctuation = ".,”’:-!? ";

    public static void main(String[] args) {

        String textInput = "я слышу пушек гром!";
        //String textInput = "абв";

        System.out.println("Входной текст:");
        System.out.println(textInput);
        System.out.println("Зашифрованный текст:");
        System.out.println(shifrCezar(textInput, 0));

    }

    public static String shifrCezar(String inputText, int move){

        String cryptText = "";
        char[] inputChar = inputText.toCharArray();

//        for (int i = 0; i < inputChar.length; i++) {
//            for (int j = 0; j < alphabet.length; j++) {
//                if(alphabet[j].equals((String) inputChar[i])){
//                    cryptText = cryptText + alphabetChar[i + move];
//                }
//            }
//        }

        // функция для подсчета индекса символов пунктуации
        // функция для поставки индекса символов пунктуации в текст
        // функция для удаления символов пунктуации из текста


        for (int i = 0; i < inputChar.length; i++) {
            for (int j = 0; j < alphabetChar.length; j++) {
                if(inputChar[i] == Character.toLowerCase(alphabetChar[j])){
                    if(j == 32){
                        cryptText = cryptText + alphabetChar[0];
                    }else{
                        cryptText = cryptText + alphabetChar[j + move];
                    }
                }
            }
        }

        return cryptText;
    }



}
