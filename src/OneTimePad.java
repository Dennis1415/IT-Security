public class OneTimePad {

    private static char[] oneTimePadEncrypt(String text, String key){
        System.out.println("Text: " + text + " (" + text.length() + ")");
        System.out.println("Key: " + key + " (" + key.length() + ")");
        char[] textArray = text.toCharArray();
        Integer test = Character.getNumericValue('A');

        return textArray;
    }

    public static void main(String[] args) {

        Integer test = Character.getNumericValue('B');
        String binary = Integer.toBinaryString(test);
        System.out.println(test);
        System.out.println(binary);
        Integer bin = Integer.valueOf(binary);
        System.out.println(bin);

    }

}
