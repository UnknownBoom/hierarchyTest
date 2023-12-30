package walker.impl;

import node.Node;
import walker.NodeWalker;
import walker.support.api.HierarchyNodeContainer;
import walker.support.impl.DequeHierarchyNodeContainer;

import java.util.ArrayDeque;
import java.util.Deque;

public class HierarchyCollectorWalker implements NodeWalker<HierarchyNodeContainer> {
    public static final HierarchyCollectorWalker INSTANCE = new HierarchyCollectorWalker();

    @Override
    public HierarchyNodeContainer walk(Node child) {
        Deque<Node> hierarchy = new ArrayDeque<>();
        hierarchy.addLast(child);
        Node parent = child;
        while (parent.hasParent()) {
            parent = parent.getParent();
            hierarchy.addFirst(parent);
        }
        return new DequeHierarchyNodeContainer(hierarchy);
    }
}
