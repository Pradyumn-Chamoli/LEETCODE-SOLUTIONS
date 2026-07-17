class Node{
    public int key,val;
    public Node prev , next;

    Node(){
        key=val=-1;
        next=prev=null;
    }

    Node(int k , int value){
        key = k;
        val = value;
        next=prev=null;
    }
}


class LRUCache {
    private Map<Integer,Node> mpp;
    private int cap;
    private Node head;
    private Node tail;

    private void deleteNode(Node node){

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }

    private void insertAfterHead(Node node){
        Node nextNode = head.next;
        head.next=node;
        nextNode.prev = node;
        node.prev=head;
        node.next=nextNode;

    }

    public LRUCache(int capacity) {
        cap = capacity;
        mpp = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next=tail;
        tail.prev = head;

    }

    public int get(int key) {
        if(!mpp.containsKey(key)){
            return -1;
        }

        Node node = mpp.get(key);
        int val = node.val;

        deleteNode(node);

        insertAfterHead(node);

        return val;
       
    }

    public void put(int key, int value) {
        if(mpp.containsKey(key)){

            Node node = mpp.get(key);
            node.val = value;

            deleteNode(node);

            insertAfterHead(node);

            return;
        }

        if(mpp.size()==cap){

            Node node = tail.prev ;

            mpp.remove(node.key);

            deleteNode(node);

            
        }

        Node newNode = new Node(key , value);

        mpp.put(key,newNode);

        insertAfterHead(newNode);

      
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */