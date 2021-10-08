import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt())%i + 1;
    }
    public static int getRandomIntFrom2(int i){
        return Math.abs(rn.nextInt())%i + 2;
    }

    int[] genNums(){
        int len = getRandomIntFrom2(1000);
        int[] array = new int[len];
        for(int i=0; i<len; i++){
            array[i] = getRandomInt(1000);
        }

        return array;
    }

    int[] genNumsCustomized(){
        int len = 1000;
        int[] array = new int[len];
        for(int i=0; i<len; i++){
            if (777 == i) {
                array[i] = 999;
            } else {
                array[i] = i;
            }
        }

        return array;
    }

    public void test(){
        int nums[] = genNums();
        String input = arrayToString(nums);

        Solution solution = new Solution();

        boolean expected = canBeIncreasing(nums);
        boolean actual = solution.canBeIncreasing(nums);
        if(expected != actual){
            String msg = "Test Failed\n";
            msg += "Input:" + input + "\n";
            msg += "Expected:" + expected + "\n";
            msg += "Actual:" + actual;
            throw new RuntimeException(msg);
        }
    }

    public void testCustomized(){
        int nums[] = genNumsCustomized();
        String input = arrayToString(nums);

        Solution solution = new Solution();

        boolean expected = canBeIncreasing(nums);
        boolean actual = solution.canBeIncreasing(nums);
        if(expected != actual){
            String msg = "Test Failed\n";
            msg += "Input:" + input + "\n";
            msg += "Expected:" + expected + "\n";
            msg += "Actual:" + actual;
            throw new RuntimeException(msg);
        }
    }

    private String arrayToString(int[] num) {
        String ret = "[";
        for(int i=0; i<num.length; i++){
            if(i != num.length -1){
                ret += num[i] + ",";
            }else{
                ret += num[i];
            }
        }
        return ret + "]";
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            for (int i = 0; i < 20; i++) {
                main.test();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
    public boolean canBeIncreasing(int[] nums) {
        boolean asc = true;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                if (asc) {
                    if (i - 1 < 0 || nums[i + 1] > nums[i - 1]) {
                        asc = false;
                    }
                    else if (i + 2 >= n || nums[i + 2] > nums[i]) {
                        asc = false;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
