package node;

import walker.NodeWalker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class SimpleNode implements Node {
    private final int id;
    private final Node parent;

    private final List<Node> children = new ArrayList<>();

    public SimpleNode(Node parent, int id, Collection<Node> children) {
        this.id = id;
        this.parent = parent;
        if (Objects.nonNull(children) && !children.isEmpty()) {
            this.children.addAll(children);
        }
    }

    public SimpleNode(Node parent, int id) {
        this(parent, id, Collections.emptyList());
    }

    public SimpleNode(int id) {
        this(null, id, Collections.emptyList());
    }

    @Override
    public <T> T walk(NodeWalker<T> walker) {
        return walker.walk(this);
    }

    @Override
    public void addChild(Node node) {
        this.children.add(node);
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public boolean hasId(int id) {
        return this.id == id;
    }

    @Override
    public boolean hasParent() {
        return Objects.nonNull(parent);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public List<Node> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "SimpleNode{" +
                "id=" + id +
                '}';
    }
}
