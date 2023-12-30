package walker.impl;

import node.Node;
import walker.NodeWalker;

import java.util.Optional;

public class BuildHierarchyNodeWalker implements NodeWalker<Optional<Node>> {
    private final int childId;
    private final HasChildWalker hasChildWalker;
    private final FindNodeWalker findNodeWalker;

    public BuildHierarchyNodeWalker(int childId) {
        this.childId = childId;
        this.hasChildWalker = new HasChildWalker(childId);
        this.findNodeWalker = new FindNodeWalker(childId);
    }

    @Override
    public Optional<Node> walk(Node source) {
        if (source.hasId(childId)) {
            return Optional.of(CopyHierarchyNodeWalker.INSTANCE.walk(source));
        } else if (Boolean.FALSE.equals(source.walk(hasChildWalker))) {
            return Optional.empty();
        }
        return source.walk(findNodeWalker).walk(this);

    }
}
