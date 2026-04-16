class Solution:
    def trap(self, height: List[int]) -> int:
        if not height: return 0

        i,j = 0,len(height)-1
        lmax,rmax = height[i],height[j]
        res=0
        while(i<j):
            if lmax<=rmax :
                i+=1
                lmax = max(lmax,height[i])
                # if (lmax-height[i])>0:
                res+=lmax-height[i]
            else :
                j-=1
                rmax = max(rmax,height[j])
                # if (rmax-height[j])>0:
                res+=rmax-height[j]
        return res