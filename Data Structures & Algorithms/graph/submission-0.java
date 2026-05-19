public class Graph {

    HashMap<Integer, HashSet<Integer>> nodeList;

    public Graph() {
        nodeList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        nodeList.putIfAbsent(src, new HashSet<>());
        nodeList.putIfAbsent(dst, new HashSet<>());
        nodeList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!nodeList.containsKey(src) || !nodeList.get(src).contains(dst)) {
            return false;
        }
        nodeList.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        HashSet<Integer> visited = new HashSet<>();
        return hasPathHelper(src, dst, visited);
    }

    private boolean hasPathHelper(int src, int dst, HashSet<Integer> visited) {
        if (src == dst) {
            return true;
        }
        visited.add(src);
        Iterator<Integer> iterator = nodeList.get(src).iterator();
        while (iterator.hasNext()) {
            int neighbor = iterator.next();
            if (!visited.contains(neighbor) && hasPathHelper(neighbor, dst, visited)) {
                return true;
            }
        }
        return false;
    }
}