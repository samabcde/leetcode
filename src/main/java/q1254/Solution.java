package q1254;


import java.util.*;

class Solution {
    //    Given a 2D grid consists of 0s (land) and
    //    1s (water).  An island is a
    //    maximal 4-directionally connected group of
    //    0s and a closed island is an island totally
    //    (all left, top, right, bottom) surrounded by 1s.
    //
    //    Return the number of closed islands.


    //    1 <= grid.length, grid[0].length <= 100
    //    0 <= grid[i][j] <= 1
    private int height;
    private int width;
    private final Set<Point> visited = new HashSet<>();

    public int closedIsland(int[][] grid) {
        height = grid.length;
        width = grid[0].length;
        if (height == 1 || width == 1) {
            return 0;
        }
        int closedIslandCount = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Point point = new Point(x, y);
                if (!visited.add(point)) {
                    continue;
                }
                if (isWater(grid, point)) {
                    continue;
                }
                boolean isClosedIsland = checkIsClosedIsland(grid, point);
                if (isClosedIsland) {
                    closedIslandCount++;
                }
            }
        }
        return closedIslandCount;
    }

    private static boolean isWater(int[][] grid, Point point) {
        return grid[point.y][point.x] == 1;
    }

    private static boolean isLand(int[][] grid, Point point) {
        return grid[point.y][point.x] == 0;
    }

    private boolean checkIsClosedIsland(int[][] grid, Point point) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(point);
        boolean isClosed = true;
        while (!queue.isEmpty()) {
            Point next = queue.poll();
            if (isOnAnySide(next)) {
                isClosed = false;
            }
            neighbours(next).forEach(
                    neighbour -> {
                        boolean isVisited = !visited.add(neighbour);
                        if (!isVisited && isLand(grid, neighbour)) {
                            queue.add(neighbour);
                        }
                    }
            );
        }
        return isClosed;
    }

    private List<Point> neighbours(Point point) {
        List<Point> neighbours = new ArrayList<>();
        if (!isOnLeftSide(point)) {
            neighbours.add(point.left());
        }
        if (!isOnRightSide(point)) {
            neighbours.add(point.right());
        }
        if (!isOnTopSide(point)) {
            neighbours.add(point.up());
        }
        if (!isOnBottomSide(point)) {
            neighbours.add(point.down());
        }

        return neighbours;
    }

    private boolean isOnAnySide(Point point) {
        return isOnLeftSide(point) || isOnBottomSide(point) || isOnRightSide(point) || isOnTopSide(point);
    }

    private boolean isOnTopSide(Point point) {
        return point.y == height - 1;
    }

    private boolean isOnRightSide(Point point) {
        return point.x == width - 1;
    }

    private boolean isOnBottomSide(Point point) {
        return point.y == 0;
    }

    private boolean isOnLeftSide(Point point) {
        return point.x == 0;
    }

    private record Point(int x, int y) {
        private Point {
            if (x < 0 || y < 0) {
                throw new IllegalArgumentException(
                        "x:" + x + ", y:" + y + " is invalid"
                );
            }
        }

        Point up() {
            return new Point(x, y + 1);
        }

        Point down() {
            return new Point(x, y - 1);
        }

        Point left() {
            return new Point(x - 1, y);
        }

        Point right() {
            return new Point(x + 1, y);
        }
    }

}