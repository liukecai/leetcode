package cn.edu.kust.util;

import sun.reflect.generics.tree.Tree;

public class Print {
	public static final void print2DArray(Object array) {
		int x, y;

		if (array instanceof int[][]) {
			x = ((int[][]) array).length;
			y = ((int[][]) array)[0].length;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++)
					System.out.printf("%d ", ((int[][]) array)[i][j]);
				System.out.println();
			}
			System.out.println();
			return;
		}

		if (array instanceof char[][]) {
			x = ((char[][]) array).length;
			y = ((char[][]) array)[0].length;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++)
					System.out.printf("%c ", ((char[][]) array)[i][j]);
				System.out.println();
			}
			System.out.println();
			return;
		}

		if (array instanceof long[][]) {
			x = ((long[][]) array).length;
			y = ((long[][]) array)[0].length;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++)
					System.out.printf("%d ", ((long[][]) array)[i][j]);
				System.out.println();
			}
			System.out.println();
			return;
		}
	}

	public static void printBinaryTree(TreeNode root) {
		dfs_pre(root);
	}

	private static void dfs_pre(TreeNode root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		dfs_pre(root.left);
		dfs_pre(root.right);
	}
}
