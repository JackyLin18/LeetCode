package com.dynamic;

/**
 * @ClassName Test
 * @Author Jacky
 * @Description
 **/
public class Test {
    int endx, endy;

    public static void main(String[] args) {
        new Test().findRoads(3, 2, -1,-1);
    }

    public void findRoads(int x, int y, int nox, int noy) {
        endx = x;
        endy = y;
        getRoads(0, 0, new StringBuilder(), nox, noy);
    }

    public void getRoads(int startx, int starty, StringBuilder s,
                         int nox, int noy) {
        if (nox == startx && noy == starty) {
            return;
        }
        s.append("(").append(startx).append(",").append(starty).append(")");
        if (startx < endx) {
            getRoads(startx + 1, starty, new StringBuilder(s),
            nox,noy);
        }
        if (starty < endy) {
            getRoads(startx, starty + 1, new StringBuilder(s),
            nox,noy);
        }
        if (startx == endx && starty == endy) {
            System.out.println(s.toString());
        }
    }
}
