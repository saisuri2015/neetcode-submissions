/**

--
--

[5, 4, 1, 9, 3]
 r
[5, 4, 1, 9, 3]
    r

--

[5, 4, 1, 9, 3]
 L  R
[4, 5, 1, 9, 3]
 L  R
 X
--
--

[4, 5, 1, 9, 3]
       r

--

[4, 5, 1, 9, 3]
    L  R
[4, 1, 5, 9, 3]
    L  R
[1, 4, 5, 9, 3]
 L  R
 X

--
--

[1, 4, 5, 9, 3]
          r

[1, 4, 5, 9, 3]
             r

--

[1, 4, 5, 9, 3]
          L  R
[1, 4, 5, 3, 9]
          L  R
[1, 4, 5, 3, 9]
       L  R
[1, 4, 3, 5, 9]
       L  R
[1, 4, 3, 5, 9]
    L  R
[1, 3, 4, 5, 9]
    L  R
[1, 3, 4, 5, 9]
 L  R
 X

 --
 --

 [1, 3, 4, 5, 9]
                r
                x

--
X
--
*/

public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> answer = new ArrayList<>();
        if (pairs.size() <= 1) {
            if (pairs.size() == 0)
                return answer;
            answer.add(new ArrayList<>(pairs));
            return answer;
        }
        answer.add(new ArrayList<>(pairs));
        for (int i = 1; i < pairs.size(); i++) {
            int right = i, left = i - 1;
            while (right >= 1 && pairs.get(right).key < pairs.get(left).key) {
                Pair rightPair = pairs.get(right);
                Pair leftPair = pairs.get(left);
                pairs.set(left, rightPair);
                pairs.set(right, leftPair);
                right--;
                left--;
            }
            answer.add(new ArrayList<>(pairs));
        }
        return answer;
    }
}
