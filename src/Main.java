public class Main {

    public static void main(String[] args) {
        NumberInWords numberInWords = new NumberInWords();

        System.out.println("1_768 = " + numberInWords.convert(1_768L));
        System.out.println("176_845 = " + numberInWords.convert(176_845L));
        System.out.println("1_691_753 = " + numberInWords.convert(1_691_753L));
        System.out.println("48_563_249 = " + numberInWords.convert(48_563_249L));
        System.out.println("0 = " + numberInWords.convert(0L));
        System.out.println("3 = " + numberInWords.convert(3L));
        System.out.println("220 = " + numberInWords.convert(220L));
        System.out.println("20_000 = " + numberInWords.convert(20_000L));
        System.out.println("12_654_875_112_986 = " + numberInWords.convert(12_654_875_112_986L));
        System.out.println("54_835_112_122 = " + numberInWords.convert(54_835_112_122L));
        System.out.println("456_777_815_112_900 = " + numberInWords.convert(456_777_815_112_900L));
        System.out.println("830_110_300 = " + numberInWords.convert(830_110_300L));
    }
}
