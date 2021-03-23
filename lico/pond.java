class pond {
    public int maxArea(int[] height) {
        int max=0;int i=0;int j=height.length-1;int one=0;
        while(0<=i&&i<j&&j<=height.length-1)
        {
            if(height[i]<height[j])
            {
            one=height[i]*(j-i);
            i++;
            }
            else
            {
            one=height[j]*(j-i);
            j--;
            }
            if(max<one)
        max=one;
        }
        return max;
    }
}