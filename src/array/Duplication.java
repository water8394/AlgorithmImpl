package array;

public class Duplication {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers.length == 0 || numbers == null){
            duplication[0] = -1;
            return false;
        }
        int[] total = new int[length];
        for (int num: numbers) {
            if (total[num] == 0){
                total[num] = 1;
            }else {
                duplication[0] = num;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(new Duplication().duplicate(new int[]{}, 6, new int[1]));

    }
}
