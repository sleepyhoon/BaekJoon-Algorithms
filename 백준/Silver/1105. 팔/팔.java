import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
    1 10 = 8 -> 1
    10 100 = 18 28 ... 78, 80, 88, 98 -> 10
    100 -> 1000 = 10 + 10 + ... + 10 + (800 ~ 899) + 10
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(getAnswer(start, end));
    }

    private static int getAnswer(int start, int end) {
        int count1 = getEightCount(start);
        int count2 = getEightCount(end);

        if (count1 == 0 || count2 == 0) {
            return 0;
        }

        int length1 = (int) Math.log10(start);
        int length2 = (int) Math.log10(end);

        if (length1 < length2) {
            return 0;
        }
        int count = 0;

        while(length1 >= 0 && length2 >= 0) {
            int pow1 = (int) Math.pow(10, length1);
            int pow2 = (int) Math.pow(10, length2);
            if(start / pow1 == end / pow2) {
                if(start / pow1 == 8) {
                    count++;
                }
                start %= pow1;
                end %= pow2;
                length1--;
                length2--;
            }
            else {
                break;
            }
        }
        return count;
    }

    private static int getEightCount(int value) {
        int tmp = value;
        int count = 0;
        while (tmp != 0) {
            int rest = tmp % 10;
            if (rest == 8) {
                count++;
            }
            tmp /= 10;
        }
        return count;
    }
}
