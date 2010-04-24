package util;

public class Parser {

	public String removeHTMLTags(String htmlTags) {
		//String temp = .toString();	
        // Remove HTML tag from java String    
        String noHTMLString = htmlTags.toString().replaceAll("\\<.*?\\>", "");

        // Remove Carriage return from java String
         noHTMLString = noHTMLString.replaceAll("\r", "<br/>");

        // Remove New line from java string and replace html break
        noHTMLString = noHTMLString.replaceAll("\n", " ");
        noHTMLString = noHTMLString.replaceAll("\'", "&#39;");
        noHTMLString = noHTMLString.replaceAll("\"", "&quot;");
        System.out.println(noHTMLString);
        return noHTMLString;
        

		
		
		
	}


}
