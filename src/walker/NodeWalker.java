package walker;

import node.Node;

public interface NodeWalker<T> {

    T walk(Node node);
}
