//
//import sun.security.util.Length;
import tc.TC;

public class Palindromes{

	public static boolean estPalindrome(String mot){
		return estPalindrome(mot, 0, mot.length());
	}

	public static boolean estPalindrome(String mot, int g, int d){
		if(mot.length()==1)
			return true;
		else if(d-g==0)
			return true;
		else if((d-g==1)&&(mot.charAt(d)==mot.charAt(g-1)))
			return true;
		else
			if(mot.charAt(g)==mot.charAt(d-1))
				return estPalindrome(mot,g+1,d-1);
		return false;
		
		
	}

	public static void testPalindrome(String mot){
		if(estPalindrome(mot)){
			TC.println(mot + " est un palindrome");
		}
		else{
			TC.println(mot + " n'est pas un palindrome");
		}
	}

	public static void main(String[] args){
		testPalindrome("AB");
		testPalindrome("BAOBAB");
		testPalindrome("KAYAK");
		testPalindrome("ABBA");
		testPalindrome("BOBAR");
		testPalindrome("ESOPERESTEICIETSEREPOSE");
	}

}
