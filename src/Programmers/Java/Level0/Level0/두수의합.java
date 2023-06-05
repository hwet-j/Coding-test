package src.Programmers.Java.Level0.Level0;


/*
0 이상의 두 정수가 문자열 a, b로 주어질 때,
a + b의 값을 문자열로 return 하는 solution 함수를 작성해 주세요.
*/

import java.util.Arrays;

public class 두수의합 {
	public static void main(String[] args) {
		String a = "18446744073709551615";
		String b = "287346502836570928366";
		String c = "";
		long a_ = 0;
		long b_ = 0;
		int aleng = a.length();
		int bleng = b.length();

		Long[] aArr = new Long[(aleng - 1)/10 + 1];
		Long[] bArr = new Long[(bleng - 1)/10 + 1];

		for (int i=0; i<aArr.length; i++){
			if (aleng - (10) * (i+1) <= 0){
				a_ = Long.parseLong(a.substring(0, aleng - (10) * i));
			} else {
				a_ = Long.parseLong(a.substring(aleng - (10) * (i+1),aleng - (10) * i));
			}
			aArr[i] = a_;
		}

		for (int i=0; i<bArr.length; i++){
			if (bleng - (10) * (i+1) <= 0){
				b_ = Long.parseLong(b.substring(0, bleng - (10) * i));
			} else {
				b_ = Long.parseLong(b.substring(bleng - (10) * (i+1),bleng - (10) * i));
			}
			bArr[i] = b_;
		}

		int leng = aArr.length>=bArr.length ? bArr.length:aArr.length;

		Long[] ansLong = new Long[leng];

		for (int i=0; i<ansLong.length; i++){
			ansLong[i] = aArr[i] + bArr[i];
		}

		System.out.println(Arrays.toString(ansLong));
		Long[] ansLong2 = aArr.length>=bArr.length ? aArr:bArr;
		for (int i=leng;i<ansLong2.length; i++){
			System.out.println(ansLong2[i]);
		}




	}
}


