package com.gyanblog.ds;

import com.gyanblog.utils.ArrayUtils;

/**
 * Young Tableau
 * Explanation of code: https://www.gyanblog.com/gyan/coding-interview/young-tableau-implementation/
 */
public class YoungTableau {
    private int[][] matrix;
    private int size;

    public YoungTableau(int[][] matrix, int size) {
        this.matrix = matrix;
        this.size = size;

        //build young tableau from given matrix
        this.buildYoungTableau();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<this.size; i++) {
            for (int j=0; j<size; j++) {
                sb.append(this.matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Return [-1,-1], if there is no child element
     */
    private int[] getLeft(int r, int c) {
        if (r >= this.size-1) {
            return new int[]{-1, -1};
        }

        return new int[]{r+1, c};
    }
    /**
     * Return [-1,-1], if there is no child element
     */
    private int[] getRight(int r, int c) {
        if (c >= this.size-1) {
            return new int[]{-1, -1};
        }
        return new int[]{r, c+1};
    }

    /**
     * Check if the cell is within the matrix
     */
    private boolean isCellValid(int[] cell) {
        return cell[0]>=0 && cell[0]<this.size && cell[1]>=0 && cell[1]<this.size;
    }


    /**
     * Main the property of young tableau
     */
    private void tableau_heapify(int r, int c) {
        int[] left = this.getLeft(r, c);
        int[] right = this.getRight(r, c);

        int[] smallest = new int[]{r, c};

        // System.out.println(r + ", " + c);
        //check if the cell is less than both of its children
        if (this.isCellValid(left) && this.matrix[left[0]][left[1]] < this.matrix[r][c]) {
            //save address of left cell
            smallest = left;
        }

        if (this.isCellValid(right) && this.matrix[right[0]][right[1]] < this.matrix[smallest[0]][smallest[1]]) {
            //save address of right cell
            smallest = right;
        }

        //Check if we found changed address in our smallest variables.
        //If yes, swap them. And, recursively call this method on that cell address
        if (this.isCellValid(smallest) && (smallest[0] != r || smallest[1] != c)) {
            //swap
            int t = this.matrix[r][c];
            this.matrix[r][c] = this.matrix[smallest[0]][smallest[1]];
            this.matrix[smallest[0]][smallest[1]] = t;

            // recursive call tableau_heapify
            this.tableau_heapify(smallest[0], smallest[1]);
        }
    }

    private void buildYoungTableau() {
        for (int i=this.size-1; i>=0; i--) {
            for (int j=this.size-1; j>=0; j--) {
                this.tableau_heapify(i, j);
            }
        }
    }

    /**
     * Get element at (0,0), and make matrix tableau_heapify again
     */
    public int extractMin() {
        int min = this.matrix[0][0];

        //put a max value here, just to denote that it has been taken out.
        this.matrix[0][0] = Integer.MAX_VALUE;

        //lets maintain tableau property
        this.tableau_heapify(0, 0);

        //all is set
        return min;
    }

    /** 
     * a recursive method to search an element
     * @return null if not found
     */
    private int[] search(int element, int[] currentCell) {
        if (!this.isCellValid(currentCell)) {
            return null;
        }
        int currentElement = this.matrix[currentCell[0]][currentCell[1]];
        if (element == currentElement) {
            return currentCell;
        }

        if (element < currentElement) {
            // move left
            // decrement col by 1
            currentCell[1]--;
            return this.search(element, currentCell);
        }
        else { //(element > currentElement) {
            //move down
            //increment row by 0
            currentCell[0] ++;
            return this.search(element, currentCell);
        }
    }

    /**
     * Search the given element and return its index in matrix
     */
    public int[] searchElement(int element) {
        //we will start from top right corner to find the element
        return this.search(element, new int[]{0, this.size-1});
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {12, 7, 11},
            {8, 9, 1},
            {4, 5, Integer.MAX_VALUE}
        };
        YoungTableau t = new YoungTableau(matrix, 3);
        System.out.println(t);
        System.out.println("------------------");

        System.out.println("Searching index of 8: " + ArrayUtils.toString(t.searchElement(8)));
        System.out.println("Searching index of 12: " + ArrayUtils.toString(t.searchElement(12)));
        System.out.println("Searching index of 4: " + ArrayUtils.toString(t.searchElement(4)));
        System.out.println("Searching index of 1: " + ArrayUtils.toString(t.searchElement(1)));

        System.out.println("Min: " + t.extractMin());
        System.out.println("------------------");
        System.out.println(t);
        System.out.println("------------------");

        System.out.println("Min: " + t.extractMin());
        System.out.println("------------------");
        System.out.println(t);
        System.out.println("------------------");

        System.out.println("Min: " + t.extractMin());
        System.out.println("------------------");
        System.out.println(t);
        System.out.println("------------------");

        System.out.println("Min: " + t.extractMin());
        System.out.println("------------------");
        System.out.println(t);
        System.out.println("------------------");
    }
}
