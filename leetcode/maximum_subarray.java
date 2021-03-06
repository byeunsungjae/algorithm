package leetcode;
/*
 * dp사용
 * dp[i-1]+nums[i] < nums[i] 일경우 현재 부터 시작하는게 더큼으로 dp[i]=nums[i]
 * 반대의 경우 더한것이 더 큼으로 dp[i]=dp[i-1]+nums[i]
 * 각 계산시 max값과 비교하여 더큰 값을 저장
 * O(N)
*/
import java.util.*;
public class maximum_subarray {
	static int nums[]= {-2,1,-3,4,-1,2,1,-5,4};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dp[]=new int[nums.length];
		int max=nums[0];
		dp[0]=nums[0];
		
		for(int i=1;i<nums.length;i++) {
			if(dp[i-1]+nums[i]<nums[i]) {
				dp[i]=nums[i];
			}else {
				dp[i]=dp[i-1]+nums[i];
			}
			if(max<dp[i])max=dp[i];
		}
		System.out.println(max);
	}

}
