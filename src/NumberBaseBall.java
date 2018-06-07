import java.util.Scanner;

public class NumberBaseBall {
    public static void main(String arg[]){
        // 순서
        // 1. 컴퓨터 숫자 만들기
        // 2. 사용자 입력값 확인
        // 3. 값 확인

        /*
        * 처리하지 못한 부분
        * 가. compareNumber 메소드 부분에 이중포문 사용하지 않고 indent depth 를 줄이기 위해 isStrike 메소드를 포함, 다른방법을 생각해보았지만 해결 X
        * 나. 메인함수의 while 부분 코드라인 더 줄이기 못함
        * 다. 사용자가 중복숫자 & 문자입력 했을 경우의 처리를 하지 못함
        * */

        // 1
        int[] comNumber = randomNumber();
        System.out.println(comNumber[0] + "" + comNumber[1] + "" + comNumber[2]);

        // 2
        Scanner sc = new Scanner(System.in);
        Boolean finish = false;
        while (!finish){
            int[] userNumber = new int[3];
            System.out.print("숫자를 입력해주세요 ex)123 : ");

            String input = sc.nextLine();
            for(int i = 0; i < input.length(); i++){
                userNumber[i] = input.charAt(i) - '0'; // char to int : 아스키코드값 알 필요없이 int 변환 가능
            }

            // 3
            if(compareNumber(comNumber, userNumber)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                finish = true;
            }
        }
    }

    public static boolean compareNumber(int[] comNumber, int[] userNumber){
        Boolean result = false; // 초기값은 false (즉, 계속 실행)
        int strike = 0;
        int ball = 0;

        for(int i=0; i < comNumber.length; i++){
            for(int j=0; j < userNumber.length; j++){
                if(comNumber[i] == userNumber[j]){
                    if(i == j){
                        strike +=  1;
                    }else{
                        ball += 1;
                    }
                }
            }
        }

        result = checkCount(strike, ball);

        return result;
    }

    // 사용 X
    public static boolean isStrike(int i, int j){
        Boolean result = false;
        if(i == j){
            result = true;
        }
        return result;
    }

    public static boolean checkCount(int strike, int ball){
        Boolean result = false;
        if(strike > 0 && ball == 0){
            System.out.println(strike + " 스트라이크");
        }else if(strike == 0 && ball > 0){
            System.out.println(ball + "볼");
        }else if(strike > 0 && ball > 0){
            System.out.println(strike + " 스트라이크 " + ball + "볼");
        }else{
            System.out.println("포볼");
        }

        if(strike == 3) {
            result = true;
        }
        return result;
    }


    public static int[] randomNumber(){
        int number[] = new int[3];
        for(int i = 0; i < number.length; i++){
            int n = (int) (Math.random() * 9) + 1; // 1~9 숫자생성
            number[i] = n; // 숫자추가
            if(duplicateCheck(number, i)){ // 중복체크
                i--;
            }
        }
        return number;
    }

    public static boolean duplicateCheck(int[] number, int i){
        Boolean result = false;
        for(int j = 0; j < i; j++){
            if(number[j] == number[i]){
                result = true;
            }
        }
        return result;
    }

}
