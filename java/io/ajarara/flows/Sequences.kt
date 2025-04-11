package io.ajarara.flows

import kotlin.sequences.Sequence
import kotlin.sequences.sequence

data class TreeNode(
    val value: Int,
    val left: TreeNode? = null,
    val right: TreeNode? = null) {

    fun inOrder(): Sequence<TreeNode> = sequence<TreeNode> {
        left?.let { yieldAll(it.inOrder()) }
        yield(this@TreeNode)
        right?.let { yieldAll(it.inOrder()) }
    }

    fun preOrder(): Sequence<TreeNode> = sequence<TreeNode> {
        yield(this@TreeNode)
        left?.let { yieldAll(it.preOrder()) }
        right?.let { yieldAll(it.preOrder()) }
    }

    fun postOrder(): Sequence<TreeNode> = sequence<TreeNode> {
        left?.let { yieldAll(it.postOrder()) }
        right?.let { yieldAll(it.postOrder()) }
        yield(this@TreeNode)
    }
}
