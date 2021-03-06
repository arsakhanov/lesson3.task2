package ru.arsakhanov.lesson32;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    /**
     * Вставка в дерево. Суть таже что и поиск
     * Только вместо вывода элемента к нему левым или правым потомком
     * добавляем новый элемент
     *
     * @param key
     * @param data
     */
    public void insert(int key, String data) {
        Node node = new Node();
        node.key = key;
        node.data = data;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node prev;

            boolean isSerchFinished = false;
            while(!isSerchFinished) {
                prev = current;
                if (key < prev.key) {
                    current = current.leftChild;
                    if (current == null) {
                        prev.leftChild = node;
                        isSerchFinished = true;
                    }
                } else if (key>prev.key){
                    current = current.rightChild;
                    if (current == null) {
                        prev.rightChild = node;
                        isSerchFinished = true;
                    }
                }else {
                    System.out.println("Данные по ключу " + key + " уже записаны");
                    isSerchFinished = true;
                }
            }
        }
    }

    /**
     * метод делает обход двоичного дерева в ширину
     * и печатает каждый узел
     *
     * @return возвращает количество листьев в дереве
     */
    public int printLevelOrder() {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println(node);
            if (node.leftChild != null) {
                nodes.add(node.leftChild);
            }

            if (node.rightChild != null) {
                nodes.add(node.rightChild);
            }

            if (node.leftChild == null && node.rightChild == null) {
                count++;
            }

        }

        return count;
    }


}