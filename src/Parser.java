public class Parser {
    public boolean checkParenthesisBalance(String str)
        {
    	int curly=0;
    	int normal=0;
        for(int i = 0;i<str.length();i++)
            {
        	char prev=' ';
        	char now=str.charAt(i);
        	if(i>0)
        	{
        		prev=str.charAt(i-1);
        	}
            if(str.charAt(i)=='(')
            {
            	normal++;
            }
            if(str.charAt(i)=='{')
            {
            	curly++;
            }
            if(str.charAt(i)=='}')
            {
            	curly--;
            }
            if(str.charAt(i)==')')
            {
            	normal--;
            }
            
            if(prev == '{' && now == ')')
            {
            	return false;
            }
            if(prev == '(' && now == '}')
            {
            	return false;
            }	
            if(curly==0 && normal == 0){
            	return true;
            }
            else{
            	return false;
            }
           
        }
        return true;
    }
}