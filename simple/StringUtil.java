public class StringUtil {

    public static void main(String[] args) {
        StringUtil util = new StringUtil();
        System.out.println(util.reverseString("Hello"));
        System.out.println(util.reverseWords("Hello World"));
    }

    private String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] words = s.split(" ");
        for (String string : words) {
         builder.append(new StringBuilder(string).reverse());   
        }
        return builder.toString();
    }
    
}
