package walker.impl;

import node.Node;
import walker.NodeWalker;

public class FindNodeWalker implements NodeWalker<Node> {
    private final int childId;
    private final HasChildWalker hasChildWalker;
    private static final String EXPECTED_NODE_NOT_FOUND_TEMPLATE = "Node: %s not contains child with id: %s";

    public FindNodeWalker(int childId) {
        this.childId = childId;
        this.hasChildWalker = new HasChildWalker(childId);
    }

    @Override
    public Node walk(Node source) {
        return source.getChildren().stream()
                .filter(child -> child.walk(hasChildWalker))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(EXPECTED_NODE_NOT_FOUND_TEMPLATE.formatted(source.getId(), childId)));
    }
}
