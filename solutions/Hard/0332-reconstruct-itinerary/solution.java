// ──────────────────────────────────────────────────
// Problem  : 332. Reconstruct Itinerary
// Difficulty: Hard
// Tags     : Array, String, Depth-First Search, Graph Theory, Sorting, Heap (Priority Queue), Eulerian Circuit, Eulerian Path, Semi-Eulerian Graph
// Link     : https://leetcode.com/problems/reconstruct-itinerary/
// Runtime  : 11 ms (beats 7%)
// Memory   : 46908000 (beats 85%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            graph.computeIfAbsent(departure, k -> new ArrayList<>()).add(arrival);
        }

        for (List<String> destinations : graph.values()) {
            destinations.sort(Collections.reverseOrder());
        }

        List<String> newItinerary = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String currentAirport = stack.peek();

            if (graph.containsKey(currentAirport) && !graph.get(currentAirport).isEmpty()) {
                stack.push(graph.get(currentAirport).remove(graph.get(currentAirport).size() - 1));
            } else {
                newItinerary.add(stack.pop());
            }
        }

        Collections.reverse(newItinerary);
        return newItinerary;        
    }
}