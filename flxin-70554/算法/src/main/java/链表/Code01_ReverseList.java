package 链表;


/**
 * Question1：倒转一个单向链表（这里为了减少代码量，统一使用双向链表的创建方法，使用的时候不使用pre属性即可）
 * Question2：倒转一个双向链表
 */
public class Code01_ReverseList {

    // 倒转一个单向链表
    public static Node reverseSingleList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 倒转一个双向链表
    public static Node reverseDoubleList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    // 自定义一个Node类
    public static class Node {
        int value;
        Node next;
        Node pre;
        public Node(int value) {
            this.value = value;
        }
    }

    // 输出List
    public static String printList(Node head) {
        String result = "";
        while (head != null) {
            result += head.value + "、";
            head = head.next;
        }
        return result;
    }

    // 创建一个双向链表，"1" -> "2" -> "3"
    public static Node createList() {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.next = node2;
        node2.next = node3;
        node2.pre = head;
        node3.pre = node2;
        return head;
    }


    public static void main(String[] args) {
        // 单向链表倒转
        Node head = createList();
        System.out.println("初始List为：" + printList(head));
        Node reverseSingleList = reverseSingleList(head);
        System.out.println("单向链表倒转：" + printList(reverseSingleList));

        // 双向链表倒转
        Node head2 = createList();
        System.out.println("初始List为：" + printList(head2));
        Node reverseDoubleList = reverseDoubleList(head2);
        System.out.println("双向链表倒转：" + printList(reverseDoubleList));
    }
}