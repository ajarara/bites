package io.ajarara.flows

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TreeNodeTest {

    @Test
    fun `inOrder traversal returns correct sequence`() {
        val root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))

        val expected = listOf(4, 2, 5, 1, 3)
        val actual = root.inOrder().map { it.value }.toList()

        assertEquals(expected, actual)
    }

    @Test
    fun `preOrder traversal returns correct sequence`() {
        val root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))

        val expected = listOf(1, 2, 4, 5, 3)
        val actual = root.preOrder().map { it.value }.toList()

        assertEquals(expected, actual)
    }

    @Test
    fun `postOrder traversal returns correct sequence`() {
        val root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))

        val expected = listOf(4, 5, 2, 3, 1)
        val actual = root.postOrder().map { it.value }.toList()

        assertEquals(expected, actual)
    }

    @Test
    fun `inOrder traversal handles empty tree`() {
        val root: TreeNode? = null
        val expected = emptyList<Int>()
        val actual = root?.inOrder()?.map { it.value }?.toList() ?: emptyList()

        assertEquals(expected, actual)
    }

    @Test
    fun `preOrder traversal handles empty tree`() {
        val root: TreeNode? = null
        val expected = emptyList<Int>()
        val actual = root?.preOrder()?.map { it.value }?.toList() ?: emptyList()

        assertEquals(expected, actual)
    }

    @Test
    fun `postOrder traversal handles empty tree`() {
        val root: TreeNode? = null
        val expected = emptyList<Int>()
        val actual = root?.postOrder()?.map { it.value }?.toList() ?: emptyList()

        assertEquals(expected, actual)
    }

    @Test
    fun `inOrder traversal handles single node tree`() {
        val root = TreeNode(1)
        val expected = listOf(1)
        val actual = root.inOrder().map { it.value }.toList()

        assertEquals(expected, actual)
    }

    @Test
    fun `preOrder traversal handles single node tree`() {
        val root = TreeNode(1)
        val expected = listOf(1)
        val actual = root.preOrder().map { it.value }.toList()

        assertEquals(expected, actual)
    }

    @Test
    fun `postOrder traversal handles single node tree`() {
        val root = TreeNode(1)
        val expected = listOf(1)
        val actual = root.postOrder().map { it.value }.toList()

        assertEquals(expected, actual)
    }
}
