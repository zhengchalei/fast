package io.github.zhengchalei.core.util;

import io.github.zhengchalei.core.base.TreeNode;
import io.github.zhengchalei.core.consts.AthenaConst;
import io.github.zhengchalei.core.exception.DataAnomaliesException;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Tree 龙套
 *
 * @author zhengchalei
 */
public class TreeUtil {

    /**
     * 多节点树
     *
     * @param list 列表
     * @return {@link TreeNode}<{@link T}>
     */
    public static <T extends TreeNode<T, ID>, ID extends Serializable> Collection<T> tree(Collection<T> list) {
        // 找到 Root
        final Set<T> root = list.stream()
                .filter(item -> item.getParentId() == null || item.getParentId() == AthenaConst.DEFAULT_ROOT)
                .collect(Collectors.toSet());
        // 递归大法
        for (T tidTreeNode : root) {
            genChildren(tidTreeNode, list);
        }
        return root;
    }

    /**
     * 单节点树
     *
     * @param list 列表
     * @return {@link TreeNode}<{@link T}>
     */
    public static <T extends TreeNode<T, ID>, ID extends Serializable> T rootTree(Collection<T> list) {
        final long count = list.stream().filter(treeNode -> AthenaConst.DEFAULT_ROOT.equals(treeNode.getParentId())).count();

        if (count > 1) {
            // 数据异常, 具有多个根节点
            throw new DataAnomaliesException();
        }
        return tree(list).iterator().next();
    }


    private static <T extends TreeNode<T, ID>, ID extends Serializable> T genChildren(final T root, final Collection<T> list) {
        list.stream()
                .filter(item -> root.getId().equals(item.getParentId()))
                // 过滤空子节点
                .peek(item -> root.setChildren(root.getChildren() == null ? new HashSet<>() : (Set<T>) root.getChildren()))
                // 递归
                .forEach(item -> root.getChildren().add(genChildren(item, list)));
        //返回数据
        return root;
    }

}
