import java.util.Scanner;

public class Main {
	
	static int[] cnt;	// i = N 에 횟수를 저장하는 배열 생성
	
	public static void main(String[] args) {
		/* 구글링 했습니다..ㅎ
		 * < 출처 >
		 * https://smartpro.tistory.com/24
		 * ------------------------------------------------
		 * i   : 1~10 사이의 수
		 * d[] : 연산 횟수를 저장하는 배열
		 * 
		 * 1부터 10까지 올라가는 연산
		 * 
		 * 1) i = 1
		 * d[1]은 1이기 때문에 연산 횟수 0
		 * => d[1] = 0
		 *
		 * 2) i = 2
		 * 가능한 연산은 1빼기 or 2나누기
		 * - 1 빼기(i-1)	 : d[2] = d[1] + 1 = 1
		 * - 2 나누기(i/2) : d[2] = d[1] + 1 = 1
		 * => d[2] = 1
		 * 
		 * 3) i = 3
		 * 가능한 연산은 1빼기 or 3나누기
		 * - i-1 : d[3] = d[2] + 1 = 2 (2에서 1 더하면 3이므로 2+1=3)
		 * - i/3 : d[3] = d[1] + 1 = 1 (1에서 3 곱하면 3이므로 1*3=3)
		 * => d[3] = 1
		 * 
		 * 4) i = 4
		 * 가능한 연산은 1빼기 or 2나누기
		 * - i-1 : d[4] = d[3] + 1 = 2 (3 + 1 = 4)
		 * - i/2 : d[4] = d[2] + 1 = 2 (2 * 2 = 4)
		 * 
		 * 5) i = 5
		 * 1빼기 뿐
		 * - i-1 : d[5] = d[4] + 1 = 3 (4+1 = 5)
		 * 
		 * 6) i = 6
		 * 1빼기 or 2나누기 or 3나누기
		 * - i-1 : d[6] = d[5] + 1 = 4 (5+1 = 6)
		 * - i/2 : d[6] = d[3] + 1 = 2 (3*2 = 6)
		 * - i/3 : d[6] = d[2] + 1 = 2 (2*3 = 5)
		 * ------------------------------------------------
		 * < 규칙 >
		 * 1을 뺄 때  : d[i] = d[i-1] + 1
		 * 2를 나눌 때	: d[i] = d[i/2] + 1
		 * 3을 나눌 때	: d[i] = d[i/3] + 1
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		cnt = new int[N+1];	// 1일 때 index 1부터 사용할 것이므로 배열 크기는 N+1
		
		cnt[1] = 0;		// 1일땐 무조건 0
		for(int i = 2; i < N+1; i++) {
			cnt[i] = cnt[i-1] + 1;
			if (i % 2 == 0 && cnt[i] > cnt[i/2] + 1) { // 2로 나눌 수 있고 2로나눈 카운트가 -1한 카운트보다 작다면
				cnt[i] = cnt[i/2] + 1;
			}					   // 3으로 나눌 수 있고
			if (i % 3 == 0 && cnt[i] > cnt[i/3] + 1) { // 3로나눈 카운트가 -1한 카운트 or 2로 나눈 카운트보다 작다면 
				cnt[i] = cnt[i/3] + 1;				   
			}
		}
		
		System.out.println(cnt[N]);
	}
	
	
			
}
