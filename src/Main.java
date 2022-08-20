public class Main {

    public static void main(String[] args) {
        NumberInWords numberInWords = new NumberInWords();

        System.out.println("1768 = " + numberInWords.convert(1768));
        System.out.println("176845 = " + numberInWords.convert(176845));
        System.out.println("1691753 = " + numberInWords.convert(1691753));
        System.out.println("48563249 = " + numberInWords.convert(48563249));
        System.out.println("0 = " + numberInWords.convert(0));
        System.out.println("3 = " + numberInWords.convert(3));
        System.out.println("220 = " + numberInWords.convert(220));
    }
}
