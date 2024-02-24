
public class ReverseSentence {

	public static String reverseSentence(String sentence) {
		String[] words = sentence.split(" ");
		int len = words.length;
		words[0] = Character.toLowerCase(words[0].charAt(0)) + words[0].substring(1);
		words[len-1] = Character.toUpperCase(words[len-1].charAt(0)) + words[len-1].substring(1);

		String result = "";
		for (int i = len - 1; i >= 0; i--) {
			result += words[i] + " ";
		}
		return result;
	}
	
	public static void main(String[] args) {
		String result = reverseSentence("The quick brown fox jumps over the lazy dog");
		System.out.println(result);
	}

}
