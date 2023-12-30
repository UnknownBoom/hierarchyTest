package walker.support.impl;

import node.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NodeIterator implements Iterator<Node> {
    private final Deque<Node> processingQueue = new ArrayDeque<>();

    public NodeIterator(Node node) {
        this.processingQueue.add(node);
    }

    @Override
    public boolean hasNext() {
        return !processingQueue.isEmpty();
    }

    @Override
    public Node next() {
        Node next = processingQueue.pollLast();
        if (Objects.isNull(next)) {
            throw new NoSuchElementException();
        }
        if (next.hasChildren()) {
            next.getChildren().forEach(processingQueue::addFirst);
        }
        return next;
    }
}
