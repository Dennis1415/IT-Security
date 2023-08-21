public class tempVIgenere {

    public static void main(String[] args) {
        int cryption = 1; //1 encryption, -1 decryption
        String vigKey = "CRYPTO";
        String vigText = "VIGENEREENCRYPTION";
        for(int i=0; i<vigText.length(); i++) {
            //add or substract characters for encryption or decrytion


            char output = (char)( (vigText.charAt(i) + cryption * vigKey.charAt(i%vigKey.length()) )- cryption * 'A');


/*
            System.out.println("Output: " + output);
            System.out.println("cryption: " + cryption);
            System.out.println("vigKey.charAt(i%vigKey.length() "+vigKey.charAt(i%vigKey.length()));
            System.out.println("i: " + i+" vigkeyLength: " +vigKey.length());
            System.out.println("i%vigkey.length() " + (i%vigKey.length()));
            System.out.println("cryptio * A: " + cryption * 'A'+"\n\n");
*/

            //adjustment for overflow
            if(output>'Z') output-=26; //encryption
            if(output<0) output+=26; //decryption
            System.out.print(output);
        }
    }


}
