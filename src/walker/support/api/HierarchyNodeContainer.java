package walker.support.api;

import node.Node;

import java.util.Iterator;

public interface HierarchyNodeContainer {
    Iterator<Node> fromParentToChildIterator();
}
