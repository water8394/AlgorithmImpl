package dp;

public class JumpFloors {


    private int JumpFloor(int target) {
        if (target <= 2) return target;
        return JumpFloor(target -1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        JumpFloors sol = new JumpFloors();
        System.out.println(sol.JumpFloor(4));
    }
}
