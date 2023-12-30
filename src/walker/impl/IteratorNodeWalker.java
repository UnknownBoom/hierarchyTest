package walker.impl;

import node.Node;
import walker.NodeWalker;
import walker.support.impl.NodeIterator;

import java.util.Iterator;

public class IteratorNodeWalker implements NodeWalker<Iterator<Node>> {
    public static final IteratorNodeWalker INSTANCE = new IteratorNodeWalker();

    @Override
    public Iterator<Node> walk(Node node) {
        return new NodeIterator(node);
    }
}
