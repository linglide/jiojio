class Disub {
    private static int[][]x=new int[1001][1001];
    public int numDistinct(String s, String t) {
        for(int i=0;i<=s.length();i++)
		x[0][i]=1;
		for(int i=1;i<=t.length();i++)
		x[i][0]=0;
		for(int i=1;i<=t.length();i++)
			for(int j=1;j<=s.length();j++)
			{
				if(t.charAt(i-1)==s.charAt(j-1))
					x[i][j]=x[i-1][j-1]+x[i][j-1];
				else
					x[i][j]=x[i][j-1];
			}
		return x[t.length()][s.length()];
    }
}