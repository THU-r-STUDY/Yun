package Tree;

import java.util.Scanner;

public class Tree_1991 {

    // 노드 클래스 정의
    public static class treeNode {
        char parent;
        treeNode left;
        treeNode right;

        // 생성자
        public treeNode(char parent, treeNode left, treeNode right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 노드의 개수를 입력받음
        int nodeNum = input.nextInt();

        // 루트 노드 생성.
        // 노드 값은 A, 자식노드는 아직 생성 전이므로 null을 가리킴
        treeNode rootNode = new treeNode('A', null, null);

        // 노드의 개수만큼 반복문 반복
        // 루트 노드를 생성해놨지만, 자식 노드는 없는 상태이므로 사용자로부터 자식 노드의 값을 입력받고, 자식노드를 생성하는 과정이 필요하므로
        // nodeNum - 1 이 아니라 nodeNum 만큼 진행해야 함
        for (int i = 0; i<nodeNum; i++){

            // charAt(0) : 입력받은 문자열의 첫 번째 문자를 반환
            char parentValue = input.next().charAt(0);
            char leftValue = input.next().charAt(0);
            char rightValue = input.next().charAt(0);

            // rootNode는 항상 new treeNode('A', null, null); 이 값임.
            makeNode(rootNode, parentValue, leftValue, rightValue);
        }

        // 트리 순회
        preOrder(rootNode);
        System.out.println();
        inOrder(rootNode);
        System.out.println();
        postOrder(rootNode);

    }

    // 노드 생성 및 연결
    public static void makeNode(treeNode rootNode, char parent, char left, char right) {
        // 루트 노드의 값과 입력받은 루트값이 동일하다면, 루트 노드의 자식노드들 생성
        // 맨 처음에는 루트노드('A', null, null)과 비교
        // main에 있는 반복문의 두번째부터 재귀함수로 빠짐
        // ('A', null, null)가 아니라 ('A', null, null)의 자식노드가 rootNode가 됨 -> 반복
        if (rootNode.parent == parent) {
            if (left != '.') {
                rootNode.left = new treeNode(left, null, null);
            }
            if (right != '.') {
                rootNode.right = new treeNode(right, null, null);
            }
        }
        else {
            // 왼쪽 자식 노드가 존재하면 왼쪽 자식 노드에 자식노드 추가
            if (rootNode.left != null) {
                makeNode(rootNode.left, parent, left, right);
            }
            // 오른쪽 자식 노드가 존재하면 오른쪽 자식 노드에 자식노드 추가
            if (rootNode.right != null) {
                makeNode(rootNode.right, parent, left, right);
            }
        }
    }

    // 전위 순회 연산, DLR
    public static void preOrder(treeNode treenode) {
        if (treenode != null) {
            System.out.print(treenode.parent); // 현재 노드 출력
            preOrder(treenode.left); // 현재 노드의 왼쪽 서브트리를 순회
            preOrder(treenode.right); // 현재 노드의 오른쪽 서브트리를 순회
        }
    }

    // 중위 순회 연산, LDR
    public static void inOrder(treeNode treenode) {
        if (treenode != null) {
            inOrder(treenode.left); // 현재 노드의 왼쪽 서브트리를 순회
            System.out.print(treenode.parent); // 현재 노드 출력
            inOrder(treenode.right); // 현재 노드의 오른쪽 서브트리를 순회
        }
    }

    // 후위 순회 연산, LRD
    public static void postOrder(treeNode treenode) {
        if (treenode != null) {
            postOrder(treenode.left); // 현재 노드의 왼쪽 서브트리를 순회
            postOrder(treenode.right); //현재 노드의 오른쪽 서브트리를 순회
            System.out.print(treenode.parent); //현재 노드 출력
        }
    }
}
