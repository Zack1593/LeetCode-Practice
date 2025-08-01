package BinaryTree;

import java.util.Stack;

public class TreeNode {

    public static void main(String[] args) {
//        String result = removeDuplicates("abbccdef");
//        System.out.println(result);
        testPlus();
    }

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static String removeDuplicates(String S) {
        Stack<Character> letters = new Stack<>();

        for(char character : S.toCharArray()) {
            if (!letters.isEmpty() && character == letters.peek())
                letters.pop();
            else {
                letters.push(character);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char character : letters) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static String removeKAdjacentDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> count = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                System.out.println(i);
                count.push(1);
            } else {
                int inc = count.pop() + 1;
                if (inc == k) {
                    // a a b c c c d
                    // 0 1 2 3 4 5 6
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    count.push(inc);
                }
            }
        }
        return sb.toString();
    }

    public static void testPlus() {
        int count = 0;
        for (int i = 0; i < 10; ++i) {
            int k = i;
            System.out.println("k = " + k);
        }
    }
}
