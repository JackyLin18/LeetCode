package com.tree.util.special;

import java.util.List;

/**
 * @ClassName Node
 * @Author Jacky
 * @Description
 **/
public class SpecialNode {
    public int val;
    public List<SpecialNode> children;

    public SpecialNode() {}

    public SpecialNode(int _val) {
        val = _val;
    }

    public SpecialNode(int _val, List<SpecialNode> _children) {
        val = _val;
        children = _children;
    }
}
