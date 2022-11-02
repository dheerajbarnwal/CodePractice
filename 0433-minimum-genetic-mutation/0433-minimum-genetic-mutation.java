class Solution {

    public int minMutation(String start, String end, String[] bank) {
        char[] ch = { 'A', 'C', 'G', 'T' };
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            hs.add(bank[i]);
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int nodesInQueue = queue.size();
            for (int j = 0; j < nodesInQueue; j++) {
                String node = queue.remove();
                if (node.equals(end)) {
                    return steps;
                }

                for (char c : ch) {
                    for (int i = 0; i < node.length(); i++) {
                        String neighbor = node.substring(0, i) + c + node.substring(i + 1);
                        if (!seen.contains(neighbor) && hs.contains(neighbor)) {
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
