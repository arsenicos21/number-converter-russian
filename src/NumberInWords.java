
public class NumberInWords {

    private static final String[] millionNames = {
            "",
            " миллион",
            " миллиона",
            " миллионов"
    };

    private static final String[] thousandNames = {
            "",
            " тысяча",
            " тысячи",
            " тысяч"
    };

    private static final String[] hundredNames = {
            "",
            " сто",
            " двести",
            " триста",
            " четыреста",
            " пятьсот",
            " шестьсот",
            " семьсот",
            " восемьсот",
            " девятьсот"
    };

    private static final String[] tensNames = {
            "",
            " десять",
            " двадцать",
            " тридцать",
            " сорок",
            " пятьдесят",
            " шестьдесят",
            " семьдесят",
            " восемьдесят",
            " девяносто"
    };

    private static final String[] maleNumNames = {
            "",
            " один",
            " два",
            " три",
            " четыре",
            " пять",
            " шесть",
            " семь",
            " восемь",
            " девять",
            " десять",
            " одиннадцать",
            " двенадцать",
            " тринадцать",
            " четырнадцать",
            " пятнадцать",
            " шестнадцать",
            " семнадцать",
            " восемьнадцать",
            " девятнадцать"
    };

    private static final String[] femaleNumNames = {
            "",
            " одна",
            " две",
            " три",
            " четыре",
            " пять",
            " шесть",
            " семь",
            " восемь",
            " девять",
            " десять",
            " одиннадцать",
            " двенадцать",
            " тринадцать",
            " четырнадцать",
            " пятнадцать",
            " шестнадцать",
            " семнадцать",
            " восемьнадцать",
            " девятнадцать"
    };

    public NumberInWords() {
    }

    private static String maleConvertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = maleNumNames[number % 100];
        } else {
            soFar = maleNumNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;

            soFar = hundredNames[number % 10] + soFar;
        }
        return soFar;
    }

    private static String femaleConvertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = femaleNumNames[number % 100];
        } else {
            soFar = femaleNumNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;

            soFar = hundredNames[number % 10] + soFar;
        }
        return soFar;
    }

    public static String convert (int number) {
        if (number == 0) {
            return "ноль";
        }

        int numberOfMillions = number / 1000000;
        int numberOfThousands = (number - (numberOfMillions * 1000000)) / 1000;
        int numberOfNum = number % 1000;

        String result;
        StringBuilder stringBuilder = new StringBuilder();

        if (number < 1000) {
            stringBuilder.append(maleConvertLessThanOneThousand(number));
        } else if (number > 1000 && number < 1000000) {
            stringBuilder.append(femaleConvertLessThanOneThousand(numberOfThousands)
                    + thousandWordReturner(number) + maleConvertLessThanOneThousand(numberOfNum));
        } else if (number >= 1000000) {
            stringBuilder.append(maleConvertLessThanOneThousand(numberOfMillions) + millionWordReturner(number)
                    + femaleConvertLessThanOneThousand(numberOfThousands) + thousandWordReturner(number)
                    + maleConvertLessThanOneThousand(numberOfNum));
        }
        result = stringBuilder.toString();
       return result;
    }

    public static String millionWordReturner(int number) {
        int numberOfMillions = number / 1000000;
        String millionWord = null;
        if (numberOfMillions % 100 < 20) {
            if (numberOfMillions == 1) {
                return millionNames[1];
            } else if (numberOfMillions <= 4) {
                return millionNames[2];
            } else if (numberOfMillions >= 5) {
                return millionNames[3];
            }
        } else {
            if (numberOfMillions % 10 == 1) {
                return millionNames[1];
            } else if (numberOfMillions % 10 <= 4) {
                return millionNames[2];
            } else if (numberOfMillions % 10 >= 5) {
                return millionNames[3];
            }
        }
        return millionWord;
    }

    public static String thousandWordReturner(int number) {
        int numberOfMillions = number / 1000000;
        int numberOfThousands = (number - (numberOfMillions * 1000000)) / 1000;
        String thousandWord = null;
        if (numberOfThousands % 100 < 20) {
            if (numberOfThousands == 1) {
                return thousandNames[1];
            } else if (numberOfThousands <= 4) {
                return thousandNames[2];
            } else if (numberOfThousands >= 5) {
                return thousandNames[3];
            }
        } else {
            if (numberOfThousands % 10 == 1) {
                return thousandNames[1];
            } else if (numberOfThousands % 10 <= 4) {
                return thousandNames[2];
            } else if (numberOfThousands % 10 >= 5) {
                return thousandNames[3];
            }
        }
        return thousandWord;
    }
}
