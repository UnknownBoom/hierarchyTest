package walker.support.impl;

import node.Node;
import walker.support.api.HierarchyNodeContainer;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;

public class DequeHierarchyNodeContainer implements HierarchyNodeContainer {
    private final Deque<Node> fromParentToChildHierarchy;
    private final Collection<Node> unmodifiableView;

    public DequeHierarchyNodeContainer(Deque<Node> fromParentToChildHierarchy) {
        this.fromParentToChildHierarchy = fromParentToChildHierarchy;
        this.unmodifiableView = Collections.unmodifiableCollection(fromParentToChildHierarchy);
    }

    @Override
    public Iterator<Node> fromParentToChildIterator() {
        return unmodifiableView.iterator();
    }


}
