package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FindRoadGame {
    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

        System.out.println(solution(nodeinfo));
    }

    static class binaryTree{
        int x;
        int y;
        int num;
        binaryTree left = null;
        binaryTree right = null;

        binaryTree(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        binaryTree[] node = new binaryTree[nodeinfo.length];

        for(int i=0; i<nodeinfo.length; i++) {
            node[i] = new binaryTree(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }

        Arrays.sort(node, new Comparator<binaryTree>() {
            @Override
            public int compare(binaryTree o1, binaryTree o2) {
                int y = o2.y - o1.y;

                if(y == 0)
                    return o1.x- o2.x;
                return y;
            }
        });

        binaryTree root = node[0];

        for(int i=1; i<nodeinfo.length; i++) {
            insertNode(root, node[i]);
        }

        ArrayList<Integer> nodeArrayList = new ArrayList<>();

        beforeSearch(root, nodeArrayList);
        for(int i=0; i<nodeinfo.length; i++) {
            answer[0][i] = nodeArrayList.get(i);
            System.out.print(answer[0][i]);
        }
        System.out.println();

        nodeArrayList.clear();
        afterSearch(root, nodeArrayList);
        for(int i=0; i<nodeinfo.length; i++) {
            answer[1][i] = nodeArrayList.get(i);
            System.out.print(answer[1][i]);
        }

        return answer;
    }

    public static void insertNode(binaryTree root, binaryTree insertNode) {
        if(insertNode.x < root.x) {
            if(root.left != null)
                insertNode(root.left, insertNode);
            else
                root.left = insertNode;
        }
        else {
            if(root.right != null)
                insertNode(root.right, insertNode);
            else
                root.right = insertNode;
        }
    }

    //전위
    public static void beforeSearch(binaryTree root, ArrayList<Integer> list) {
        list.add(root.num);

        if(root.left != null)
            beforeSearch(root.left, list);
        if(root.right != null){
            beforeSearch(root.right, list);
        }
    }

    //후위
    public static void afterSearch(binaryTree root, ArrayList<Integer> list) {
        if(root.left != null)
            afterSearch(root.left, list);
        if(root.right != null){
            afterSearch(root.right, list);
        }

        list.add(root.num);
    }
}
