package node;

import walker.NodeWalker;

import java.util.Collection;

public interface Node {
    int getId();

    Node getParent();

    Collection<Node> getChildren();

    <T> T walk(NodeWalker<T> walker);

    void addChild(Node node);

    boolean hasChildren();

    boolean hasId(int id);

    boolean hasParent();
}
