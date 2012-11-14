package util;

public class Etc {
	
	public static String getFirstChar(String s) {
		String[] tmp = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(String k : tmp){
			sb.append(k.charAt(0));
			sb.append(" ");
		}
		return sb.toString().trim();
	}
}
