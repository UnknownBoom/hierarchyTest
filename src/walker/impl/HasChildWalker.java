package walker.impl;

import node.Node;
import walker.NodeWalker;

public class HasChildWalker implements NodeWalker<Boolean> {
    private final int childId;

    public HasChildWalker(int childId) {
        this.childId = childId;
    }


    @Override
    public Boolean walk(Node source) {
        if (source.hasId(childId)) {
            return true;
        }
        if (source.hasChildren()) {
            return source.getChildren().stream().anyMatch(node -> node.walk(this));
        }
        return false;

    }
}
