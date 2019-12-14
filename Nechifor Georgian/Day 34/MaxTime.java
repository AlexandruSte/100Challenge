//https://leetcode.com/discuss/interview-question/396769/google-oa-2019-maximum-time

public class MaxTime {

public String getMaxTime(String s) {
        String h = s.substring(0, 2);
        String m = s.substring(3, 5);
        char[] hour = h.toCharArray();
        char[] min = m.toCharArray();

        if (hour[0] == '?') {
            hour[0] = '2';
            try {
                h = hour[0] + "" + hour[1];
                if (Integer.parseInt(h) >= 24)
                    hour[0] = '1';
            } catch (NumberFormatException e) { }
        }

        if (hour[1] == '?') {
            if (hour[0] == '1' || hour[0] == '0') {
                hour[1] = '9';
            } else
                hour[1] = '3';
        }

        if (min[0] == '?')
            min[0] = '5';

        if (min[1] == '?')
            min[1] = '9';

        h = hour[0] + "" + hour[1];
        m = min[0] + "" + min[1];
        return h + ":" + m;
    }
}
