import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text){

        if( isBlank(text)) {
            return 0;
        }

        return sum(toIns(split(text)));
    }

    private boolean isBlank(String text){
        return text == null || text.isEmpty();
    }

    private String[] split(String text){
        /*
         * 정규화 표현식 설명
         * 소괄호 안의 문자를 하나의 문자로 인식 -> ()
         * 임의의 한 문자 (문자의 종류 가리지 않음) 단, \ 는 넣을 수 없음  -> .
         * 앞 문자가 없을 수도 무한정 많을 수도 있음 -> *
         */
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }

        return text.split(",|:");
    }

    private int[] toIns(String[] values) {
        int[] numbers = new int[values.length];
        for(int i =0; i < values.length; i++){
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if( number < 0 ){
            throw new RuntimeException();
        }
        return number;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

}
