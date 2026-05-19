class TreeNode {
    int key;
    int val;

    TreeNode left;
    TreeNode right;

    TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class TreeMap {

    TreeNode root = null;
    HashMap<Integer, TreeNode> map = new HashMap<>();

    public TreeMap() {
    }

    public void insert(int key, int val) {

        // update existing
        if (map.containsKey(key)) {
            map.get(key).val = val;
            return;
        }

        root = insertHelper(root, key, val);
    }

    private TreeNode insertHelper(TreeNode curr, int key, int val) {

        // create node
        if (curr == null) {
            TreeNode node = new TreeNode(key, val);
            map.put(key, node);
            return node;
        }

        if (key < curr.key) {
            curr.left = insertHelper(curr.left, key, val);
        }
        else if (key > curr.key) {
            curr.right = insertHelper(curr.right, key, val);
        }

        return curr;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        return map.get(key).val;
    }

    public int getMin() {

        if (root == null) return -1;

        TreeNode curr = root;

        while (curr.left != null) {
            curr = curr.left;
        }

        return curr.val;
    }

    public int getMax() {

        if (root == null) return -1;

        TreeNode curr = root;

        while (curr.right != null) {
            curr = curr.right;
        }

        return curr.val;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
        map.remove(key);
    }

    private TreeNode removeHelper(TreeNode curr, int key) {

        if (curr == null) return null;

        if (key < curr.key) {
            curr.left = removeHelper(curr.left, key);
        }
        else if (key > curr.key) {
            curr.right = removeHelper(curr.right, key);
        }
        else {

            // 0 or 1 child

            if (curr.left == null) {
                return curr.right;
            }

            if (curr.right == null) {
                return curr.left;
            }

            // 2 children

            TreeNode successor = findMin(curr.right);

            curr.key = successor.key;
            curr.val = successor.val;

            curr.right =
                removeHelper(curr.right, successor.key);
        }

        return curr;
    }

    private TreeNode findMin(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public List<Integer> getInorderKeys() {

        List<Integer> result = new ArrayList<>();

        inorderTraversal(root, result);

        return result;
    }

    private void inorderTraversal(
        TreeNode root,
        List<Integer> result
    ) {

        if (root == null) return;

        inorderTraversal(root.left, result);

        result.add(root.key);

        inorderTraversal(root.right, result);
    }
}