package stringAndChar;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

    private boolean flag = false;
    private String add ="";

    public List<String> removeComments(String[] source) {

        List<String> ans = new ArrayList<>();
        for (String s : source) {
            String p = check(s, this.flag);
            if (!"".equals(p)) {
                if (!this.flag){
                    if (!add.equals("")){
                        add += p;
                        ans.add(this.add);
                        add = "";
                    }
                    else{
                        ans.add(p);
                    }
                }
                else{
                    add += p;
                }
            }
            if (!add.equals("") && !flag){
                ans.add(this.add);
                this.add = "";
            }
        }
        return ans;
    }

    private String check(String s, boolean flag) {

        int idx;
        int i1;
        int i2;

        if (!flag){
            i1 = s.indexOf("/*");
            i2 = s.indexOf("//");
            if (i1 != -1 && i2 != -1){
                if (i1 < i2){
                    String remain = s.substring(i1+2);
                    int newIdx;
                    if ((newIdx = remain.indexOf("*/")) != -1) return s.substring(0, i1) + check(remain.substring(newIdx+2), false);
                    this.flag = true;
                    return s.substring(0, i1);
                }else{
                    return s.substring(0, i2);
                }
            }
            if (i2 != -1){
                return s.substring(0, i2);
            }
            if (i1 != -1){
                String remain = s.substring(i1+2);
                int newIdx;
                if ((newIdx = remain.indexOf("*/")) != -1) return s.substring(0, i1) + remain.substring(newIdx+2);
                this.flag = true;
                return s.substring(0, i1);
            }
            return s;
        }else {
            if ((idx = s.indexOf("*/")) != -1){
                this.flag = false;
                return s.substring(idx+2);
            }
            return "";
        }
    }

    public static void main(String[] args) {

        RemoveComments sol = new RemoveComments();
        List<String> list = sol.removeComments(new String[]{"a/*/b//*c","blank","d//*e/*/f"});
        list.forEach(System.out::println);
    }

}
