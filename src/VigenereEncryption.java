public class VigenereEncryption {
    private static int[] getShifts(char[] keyArray) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //char[] keyArray = key.toCharArray();
        int[] shifts = new int[keyArray.length];
        for (int i = 0; i < keyArray.length; i++) {
            shifts[i] = alphabet.indexOf(keyArray[i]) + 1;
        }
        return shifts;
    }

    private static int[] getShifts2(char[] key){
        int[] shifts = new int[key.length];
        for(int i=0; i<key.length; i++){
            shifts[i]= key[i] - 65;    // may include if statement to differentiate upper/lowercase
        }
        return shifts;
    }

    private static char[] vigEncrypt(String text, String key) {

        System.out.println("Text: " + text + " (" + text.length() + ")");
        System.out.println("Key: " + key + " (" + key.length() + ")");

        //Changing Key to match length of text
        if (text.length() < key.length()) {
            key = key.substring(0, text.length());
            System.out.println("Key cut to: " + key + " (" + key.length() + ")\n");

        } else if (text.length() > key.length()) {
            String keyTemp = key; //store key otherwise key would double every iteration (key -> keykey -> keykeykeykey)
            do {
                key = key.concat(keyTemp); //concatenates key with itself until it´s long enough
            } while (text.length() > key.length());
            if (key.length() > text.length()) { //cut down again if necessary
                key = key.substring(0, key.length() - (key.length() - text.length())); //well...
            }
            System.out.println("Key extended to: " + key + " (" + key.length() + ")\n");
        }

        //converts Strings to Arrays since its more convenient
        char[] txt = text.toCharArray();
        char[] ky = key.toCharArray();
        int[] shifts = getShifts2(ky);

        //Prints everything
        printArray(txt,"Text:       ");
        printArray(ky,"Key:        ");
        printArray(shifts,"Shifts:     ");
        System.out.println();


        //actual encryption
        char[] cipher = new char[txt.length];
        for (int i = 0; i < txt.length; i++) {
            if ((txt[i] + shifts[i]) > 90) { //65-90
                cipher[i] = (char) (64 + (txt[i] + shifts[i]) - 90); //
            } else {
                cipher[i] = (char) (txt[i] + shifts[i]);
            }
        }
        printArray(cipher,"Ciphertext: ");
        return cipher;

    }

    private static void printArray(char[] c) {
        for (char temp : c) {
            System.out.print(temp + "   ");
        }
        System.out.println();
    }
    private static void printArray(char[] c, String s){
        System.out.print(s);
        printArray(c);
    }

    private static void printArray(int[] i) {
        for (int temp : i) {
            if (temp > 9) {
                System.out.print(temp + "  ");
            } else {
                System.out.print(temp + "   ");
            }
        }
        System.out.println();
    }
    private static void printArray(int[] i, String s){
        System.out.print(s);
        printArray(i);
    }

    public static void main(String[] args) {

        char[] str = vigEncrypt("FRANKFURT", "UAS");
        //System.out.println("Ciphertext: "+ );


    }

}
