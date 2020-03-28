package coding;

import org.testng.annotations.Test;

import java.util.Arrays;

public class CodeTest {
    @Test
    public void test(){
        int []a = {1,2,4,5,16,13,0};
        // highest number
//        int big = a[0];
//        for(int i=0;i<a.length;i++){
//            if(big <a[i])
//            {
//                big = a[i];
//            }
//        }
//        System.out.println("Highest value is :"+big);
        // second highest number
        // sort array
//        Arrays.sort(a);
//        for(int i=0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
//        System.out.println("Second highest number is:"+a[a.length-2]);
//
//        int highest =Integer.MIN_VALUE;;
//        int secondHIghest = Integer.MIN_VALUE;;
//        for(int i=0;i<a.length;i++)
//        {
//            if(highest<a[i]){
//                secondHIghest = highest;
//                highest = a[i];
//            }
//            if(highest>a[i] && secondHIghest<a[i])
//            {
//                secondHIghest = a[i];
//            }
//        }
//        System.out.println("Default value :"+highest+secondHIghest);
      // print duplicate elements from array
//        int num =6;
//        int fact = 1;
//        if(num>1)
//        {
//            while (num > 0) {
//                fact = fact * num--;
//            }
//        }
//        System.out.println(fact);

        // fabocini sequence
//        int a1 = 0,b =1;
//        int res =0;
//        int limit = 10;
//        System.out.print(a1+"\t"+b);
//        while(res <= limit){
//            res = a1+b;
//            System.out.print("\t"+res);
//            a1 =b; b =res;

        // palindrome number
//        int original = 121;
//        int dummy = original;
//        int num=0,r=0;
//        while(dummy>0)
//        {
//            r = dummy%10;
//              num =       num*10+r;
//              dummy/=10;
//        }
//        System.out.print("value "+num);
    }
}
