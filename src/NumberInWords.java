
public class NumberInWords {

    private static final String[] trillionNames = {
            "",
            " триллион",
            " триллиона",
            " триллионов"
    };

    private static final String[] billionNames = {
            "",
            " миллиард",
            " миллиарда",
            " миллиардов"
    };

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

    private static String maleConvertLessThanOneThousand(long number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = maleNumNames[Math.toIntExact(number % 100)];
            number /= 100;

            soFar = hundredNames[Math.toIntExact(number % 10)] + soFar;
        } else {
            soFar = maleNumNames[Math.toIntExact(number % 10)];
            number /= 10;

            soFar = tensNames[Math.toIntExact(number % 10)] + soFar;
            number /= 10;

            soFar = hundredNames[Math.toIntExact(number % 10)] + soFar;
        }
        return soFar;
    }

    private static String femaleConvertLessThanOneThousand(long number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = femaleNumNames[Math.toIntExact(number % 100)];
            number /= 100;

            soFar = hundredNames[Math.toIntExact(number % 10)] + soFar;
        } else {
            soFar = femaleNumNames[Math.toIntExact(number % 10)];
            number /= 10;

            soFar = tensNames[Math.toIntExact(number % 10)] + soFar;
            number /= 10;

            soFar = hundredNames[Math.toIntExact(number % 10)] + soFar;
        }
        return soFar;
    }

    public static String convert (long number) {
        if (number == 0) {
            return "ноль";
        }

        long numberOfTrillions = number / 1_000_000_000_000L;
        long numberOfBillions = (number - (numberOfTrillions * 1_000_000_000_000L)) / 1_000_000_000L;
        long numberOfMillions = (number - ((numberOfTrillions * 1_000_000_000_000L)
                + (numberOfBillions * 1_000_000_000L)))/ 1_000_000L;
        long numberOfThousands = (number - ((numberOfTrillions * 1_000_000_000_000L)
                + (numberOfBillions * 1_000_000_000L) + (numberOfMillions * 1_000_000L))) / 1000L;
        long numberOfNum = number % 1000;

        String result;
        StringBuilder stringBuilder = new StringBuilder();

        if (number < 1_000L) {
            stringBuilder.append(maleConvertLessThanOneThousand(number));
        } else if (number > 1_000L && number < 1_000_000L) {
            stringBuilder.append(femaleConvertLessThanOneThousand(numberOfThousands)
                    + thousandWordReturner(Math.toIntExact(number)) + maleConvertLessThanOneThousand(numberOfNum));
        } else if (number >= 1_000_000L && number < 1_000_000_000L) {
            stringBuilder.append(maleConvertLessThanOneThousand(numberOfMillions) + millionWordReturner(number)
                    + femaleConvertLessThanOneThousand(numberOfThousands) + thousandWordReturner(number)
                    + maleConvertLessThanOneThousand(numberOfNum));
        } else if (number >= 1_000_000_000L && number < 1_000_000_000_000L) {
            stringBuilder.append(maleConvertLessThanOneThousand(numberOfBillions) + billionWordReturner(number)
                    + maleConvertLessThanOneThousand(numberOfMillions) + millionWordReturner(number)
                    + femaleConvertLessThanOneThousand(numberOfThousands) + thousandWordReturner(number)
                    + maleConvertLessThanOneThousand(numberOfNum));
        } else if (number >= 1_000_000_000_000L) {
            stringBuilder.append(maleConvertLessThanOneThousand(numberOfTrillions) + trillionWordReturner(number)
                    + maleConvertLessThanOneThousand(numberOfBillions) + billionWordReturner(number)
                    + maleConvertLessThanOneThousand(numberOfMillions) + millionWordReturner(number)
                    + femaleConvertLessThanOneThousand(numberOfThousands) + thousandWordReturner(number)
                    + maleConvertLessThanOneThousand(numberOfNum));
        }
        result = stringBuilder.toString();
       return result;
    }

    public static String trillionWordReturner(long number) {
        long numberOfTrillions = number / 1_000_000_000_000L;
        String trillionWord = null;
        if (numberOfTrillions % 100 < 20) {
            if (numberOfTrillions == 1) {
                return trillionNames[1];
            } else if (numberOfTrillions <= 4) {
                return trillionNames[2];
            } else if (numberOfTrillions >= 5) {
                return trillionNames[3];
            }
        } else {
            if (numberOfTrillions % 10 == 0) {
                return trillionNames[3];
            }else if (numberOfTrillions % 10 == 1) {
                return trillionNames[1];
            } else if (numberOfTrillions % 10 <= 4) {
                return trillionNames[2];
            } else if (numberOfTrillions % 10 >= 5) {
                return trillionNames[3];
            }
        }
        return trillionWord;
    }

    public static String billionWordReturner(long number) {
        long numberOfTrillions = number / 1_000_000_000_000L;
        long numberOfBillions = (number - (numberOfTrillions * 1_000_000_000_000L)) / 1_000_000_000L;
        String billionWord = null;
        if (numberOfBillions % 100 < 20) {
            if (numberOfBillions == 1) {
                return billionNames[1];
            } else if (numberOfBillions <= 4) {
                return billionNames[2];
            } else if (numberOfBillions >= 5) {
                return billionNames[3];
            }
        } else {
            if (numberOfBillions % 10 == 0) {
                return billionNames[3];
            } else if (numberOfBillions % 10 == 1) {
                return billionNames[1];
            } else if (numberOfBillions % 10 <= 4) {
                return billionNames[2];
            } else if (numberOfBillions % 10 >= 5) {
                return billionNames[3];
            }
        }
        return billionWord;
    }

    public static String millionWordReturner(long number) {
        long numberOfTrillions = number / 1_000_000_000_000L;
        long numberOfBillions = (number - (numberOfTrillions * 1_000_000_000_000L)) / 1_000_000_000L;
        long numberOfMillions = (number - ((numberOfTrillions * 1_000_000_000_000L)
                + (numberOfBillions * 1_000_000_000L)))/ 1_000_000L;
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
            if (numberOfMillions % 10 == 0) {
                return millionNames[3];
            } else if (numberOfMillions % 10 == 1) {
                return millionNames[1];
            } else if (numberOfMillions % 10 <= 4) {
                return millionNames[2];
            } else if (numberOfMillions % 10 >= 5) {
                return millionNames[3];
            }
        }
        return millionWord;
    }

    public static String thousandWordReturner(long number) {
        long numberOfTrillions = number / 1_000_000_000_000L;
        long numberOfBillions = (number - (numberOfTrillions * 1_000_000_000_000L)) / 1_000_000_000L;
        long numberOfMillions = (number - ((numberOfTrillions * 1_000_000_000_000L)
                + (numberOfBillions * 1_000_000_000L)))/ 1_000_000L;
        long numberOfThousands = (number - ((numberOfTrillions * 1_000_000_000_000L)
                + (numberOfBillions * 1_000_000_000L) + (numberOfMillions * 1_000_000L))) / 1000L;
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
            if (numberOfThousands % 10 == 0) {
                return thousandNames[3];
            }else if (numberOfThousands % 10 == 1) {
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
