

class PalindromoEmJava{

	
	public static String isPalindromo(String s,int i,int j){
	String resp="SIM";
		if(i < s.length()){
			if(s.charAt(i) != s.charAt(j)){
				resp="NAO";
			}
		
		else 
		resp= "SIM" && palindromo(s,i+1,j-1);
		}
		return true;



	public static boolean isFim(String s){
		return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}


	
	public static void main (String[] args){
	
		String[] entries = new String[1000];
		int numEntries = 0;

	
		do{
			entries[numEntries] = MyIO.readLine();
		} while(!(isFim(entries[numEntries++])));
		numEntries--; 

		
		for(int i = 0; i < numEntries; i++){
			MyIO.println(isPalindromo(entries[i]));
		}
	}	

}