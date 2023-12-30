
package walker.impl;

import node.Node;
import node.SimpleNode;
import walker.NodeWalker;
import walker.support.api.HierarchyNodeContainer;

import java.util.Iterator;

public class CopyHierarchyNodeWalker implements NodeWalker<Node> {

    public static final CopyHierarchyNodeWalker INSTANCE = new CopyHierarchyNodeWalker();

    @Override
    public Node walk(Node child) {
        HierarchyNodeContainer hierarchy = HierarchyCollectorWalker.INSTANCE.walk(child);
        Iterator<Node> nodeIterator = hierarchy.fromParentToChildIterator();
        SimpleNode root = new SimpleNode(null, nodeIterator.next().getId());
        Node parent = root;
        while (nodeIterator.hasNext()) {
            Node nextChild = nodeIterator.next();
            SimpleNode childCopy = new SimpleNode(parent, nextChild.getId());
            parent.addChild(childCopy);
            parent = childCopy;
        }
        return root;
    }
}
