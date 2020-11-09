package 链表;


/**
 * 从单向链表中删除一个指定值相关的所有节点
 */
public class Code02_DeleteValue {

    // 从单向链表中删除一个指定值相关的所有节点
    public static Node deleteValue(Node head, int value) {
        while (head != null && head.value == value) {
            head = head.next;
        }

        // head：找到了第一个不需要删除的节点，也是新生成的链表的头
        // pre、cur：这里利用双指针，类似于快慢指针，找到后面所有需要删除的节点
        Node pre = head;
        Node cur = head;

        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    // 自定义一个Node类
    public static class Node {
        int value;
        Node next;
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
        return head;
    }

    public static void main(String[] args) {
        // 从链表中删除值为2的所有节点
        Node head = createList();
        System.out.println("初始List为：" + printList(head));
        Node deleteValue = deleteValue(head, 2);
        System.out.println("删除后List为：" + printList(deleteValue));
    }
}
