/*
* 2021-05-02 Sun
* Numbers from 0 to 3 to mark the directions: north = 0, east = 1, south = 2, west = 3.
* If instruction is R, the next direction is i = (i + 1) % 4.
* If instruction is L, the next direction is i = (i - 1) % 4. To avoid negative indices, use i = (i + 3) % 4 instead
* If instruction is to move, update x += directions[i][0], y += directions[i][1].

* If the robot doesn't face north at the end of the first cycle, then that's the limit cycle trajectory.
* After one cycle, the robot faces north.
* Then here is what we have after 4 cycles:
* x4=x+Δx+Δx−Δx+Δx=x+4Δx
* y4=y+Δy+Δy+Δy+Δy=y+4Δy
* After one cycle, the robot faces east.
* Then here is what we have after 4 cycles:
* x4=x+Δx+Δy−Δx−Δy=x
* y4=y+Δy−Δx−Δy+Δx=y
* After one cycle, the robot faces south.
* Then here is what we have after 4 cycles:
* x4=x+Δx−Δx+Δx−Δx=x
* y4=y+Δy−Δy+Δy−Δy=y
* After one cycle, the robot faces west.
* Then here is what we have after 4 cycles:
* x4=x+Δx−Δy−Δx+Δy=x
* y4=y+Δy+Δx−Δy−Δx=y
*/
public class Leet1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int x = 0, y = 0, i = 0;
        for(char ins: instructions.toCharArray()) {
            if(ins == 'R') {
                i = (i + 1) % 4;
            }else if(ins == 'L') {
                i = (i + 3) % 4;
            }else {
                x += dir[i][0];
                y += dir[i][1];
            }
        }
        return (x == 0 && y == 0) || i > 0;
    }
}
