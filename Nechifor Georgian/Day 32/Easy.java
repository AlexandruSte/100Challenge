import java.util.ArrayList;
import java.util.List;

public class Easy {

    //https://leetcode.com/problems/roman-to-integer/
    public int romanToInt(String s) {
        int rez = 0;
        char[] romans = s.toCharArray();
        for (int i = 0; i < romans.length; i++) {
            if (romans[i] == 'I')
                rez += 1;
            if (romans[i] == 'V') {
                if (i > 0 && romans[i - 1] == 'I')
                    rez += 3;
                else
                    rez += 5;
            }
            if (romans[i] == 'X') {
                if (i > 0 && romans[i - 1] == 'I')
                    rez += 8;
                else
                    rez += 10;
            }
            if (romans[i] == 'L') {
                if (i > 0 && romans[i - 1] == 'X') {
                    rez += 30;
                } else
                    rez += 50;
            }
            if (romans[i] == 'C') {
                if (i > 0 && romans[i - 1] == 'X')
                    rez += 80;
                else
                    rez += 100;
            }
            if (romans[i] == 'D') {
                if (i > 0 && romans[i - 1] == 'C')
                    rez += 300;
                else
                    rez += 500;
            }
            if (romans[i] == 'M') {
                if (i > 0 && romans[i - 1] == 'C')
                    rez += 800;
                else
                    rez += 1000;
            }
        }

        return rez;
    }

    public int romanToInt_map(String s) {
        int[] map = new int[256];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;

        char[] rom = s.toCharArray();
        int pre = 1;
        int nr = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = map[rom[i]];
            if (cur < pre)
                nr -= cur;
            else {
                pre = cur;
                nr += cur;
            }
        }

        return nr;
    }

    //https://leetcode.com/problems/valid-parentheses/
    enum parenthesis {openRound, closeRound, openSquare, closeSquare, openBracket, closeBracket};

    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        if(s.length() == 1) return false;
        List<parenthesis> last = new ArrayList<>();
        parenthesis lastOpen = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                last.add(parenthesis.openRound);
                lastOpen = parenthesis.openRound;
            } else if (c == '{') {
                last.add(parenthesis.openBracket);
                lastOpen = parenthesis.openBracket;
            } else if (c == '[') {
                last.add(parenthesis.openSquare);
                lastOpen = parenthesis.openSquare;
            } else if (c == ']') {
                if (lastOpen != parenthesis.openSquare)
                    return false;
                else {
                    last.remove(last.size() - 1);
                    if(last.size() > 0)
                        lastOpen = last.get(last.size() - 1);
                }
            } else if (c == '}') {
                if (lastOpen != parenthesis.openBracket)
                    return false;
                else {
                    last.remove(last.size() - 1);
                    if(last.size() > 0)
                        lastOpen = last.get(last.size() - 1);
                }
            } else if (c == ')') {
                if (lastOpen != parenthesis.openRound)
                    return false;
                else {
                    last.remove(last.size() - 1);
                    if(last.size() > 0)
                        lastOpen = last.get(last.size() - 1);
                }
            }
        }

        return last.size() <= 0;
    }
}
