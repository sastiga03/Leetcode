import java.util.*;

class Solution {

    class State {
        int r, c, energy, mask, moves;

        State(int r, int c, int energy, int mask, int moves) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        char[][] mat = new char[m][n];

        int sr = 0, sc = 0;
        int litter = 0;

        int[][] index = new int[m][n];

        for (int[] row : index) {
            Arrays.fill(row, -1);
        }

        // Create matrix + find S + number L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                mat[i][j] = classroom[i].charAt(j);

                if (mat[i][j] == 'S') {
                    sr = i;
                    sc = j;
                }

                if (mat[i][j] == 'L') {
                    index[i][j] = litter;
                    litter++;
                }
            }
        }

        // No litter
        if (litter == 0)
            return 0;

        // Example: 3 litter -> 111
        int all = (1 << litter) - 1;

        /*
            visited[r][c][mask]

            Stores maximum energy with which
            we have reached this state.
        */
        int[][][] visited = new int[m][n][1 << litter];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }

        Queue<State> q = new LinkedList<>();

        // Start
        q.offer(new State(sr, sc, energy, 0, 0));

        visited[sr][sc][0] = energy;

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            State cur = q.poll();

            // All litter collected
            if (cur.mask == all) {
                return cur.moves;
            }

            for (int[] d : dir) {

                int nr = cur.r + d[0];
                int nc = cur.c + d[1];

                // Outside
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                // Obstacle
                if (mat[nr][nc] == 'X')
                    continue;

                // Cannot move without energy
                if (cur.energy == 0)
                    continue;

                // Spend 1 energy
                int newEnergy = cur.energy - 1;

                int newMask = cur.mask;

                // Reset
                if (mat[nr][nc] == 'R') {
                    newEnergy = energy;
                }

                // Litter
                if (mat[nr][nc] == 'L') {

                    int id = index[nr][nc];

                    newMask = newMask | (1 << id);
                }

                /*
                    If we already reached this
                    position + mask with MORE energy,
                    this path is useless.
                */
                if (visited[nr][nc][newMask] >= newEnergy) {
                    continue;
                }

                // This is a better state
                visited[nr][nc][newMask] = newEnergy;

                q.offer(new State(
                    nr,
                    nc,
                    newEnergy,
                    newMask,
                    cur.moves + 1
                ));
            }
        }

        return -1;
    }
}