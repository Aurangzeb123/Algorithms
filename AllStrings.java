/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class AllStrings
{
    static int count = 0;
    
     static void permuteHelper(StringBuffer s, StringBuffer chosen)
    {
        if(s.length() == 0)
        {
            System.out.println(chosen);
            
        }
        else
        {
            int size = s.length();
            for(int i = 0; i < size; i++)
            {
                char c = s.charAt(i);
                chosen.append(c);
                permuteHelper(s.replace(i, i+1, ""), chosen);
                s.insert(i,c);
                chosen.deleteCharAt(chosen.length() - 1);
            }
        }
    }
    
    public static void permute(String s)
    {
        StringBuffer chosen = new StringBuffer();
        
        permuteHelper(new StringBuffer(s), chosen);
    }
    
    
    
    static void generate(String s, String sb)
    {
        count ++;
        if(s.length()==0)
        {
            if(sb.length()!=0) permute(sb);
        }
        else
        {
            generate(s.substring(1), sb);
            generate(s.substring(1), sb + s.charAt(0));
        }
    }
    
    static void generateSubsequence(String s)
    {
        String sb = new String();
        generate(s, sb);
    }
    
	public static void main(String[] args) {
		generateSubsequence("abc");
		System.out.println(count);
	}
}
