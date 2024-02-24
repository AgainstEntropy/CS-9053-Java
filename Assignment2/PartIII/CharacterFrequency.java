import java.util.HashMap;

public class CharacterFrequency {

	public static char charFrequency(String s) {

		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
		int max_freq = 0;
		char max_char = 'a';
		
		// reverse the string to ensure that we update `max_char` to the character that comes first
		String s_rev = new StringBuilder(s).reverse().toString();
		for (int i = 0; i < s.length(); i++) {
			char c = s_rev.charAt(i);
			freq.put(c, freq.getOrDefault(c, 0) + 1);
			int c_freq = freq.get(c);
			if (c_freq >= max_freq) {
				max_freq = c_freq;
				max_char = c;
			}
		}
		
		System.out.println("The string is: " + s);
		for (Character i : freq.keySet()) {
            System.out.printf("%c: %d\n", i, freq.get(i));
        }
		
		
		return max_char;
	}
	
	public static String randomStringGenerator(int chars) {
		char[] charArray = new char[chars];
		for (int i=0;i<charArray.length;i++) {
			char c = (char)((int)(Math.random()*26) + 'a');
			charArray[i] = c;
		}
		return new String(charArray);
	}
	
	public static void main(String[] args) {
		String s = "abbbbcdeapapqarrpp";
		// String s = randomStringGenerator(20);
		char result = charFrequency(s);
		System.out.printf("The most frequent character is %c\n", result);
	}
}
