package Highspot;

import java.util.ArrayList;

 /*[7, 3] "N" "RAALAL"

 Write a robot simulator.

 A robot factory’s test facility needs a program to verify robot movements.

 The robots have three possible movements:

 turn right
 turn left
 advance
 Robots are placed on a hypothetical infinite grid, facing a particular direction (north, east, south, or west) at a set of {x,y} coordinates, e.g., {3,8}, with coordinates increasing to the north and east.

 The robot then receives a number of instructions, at which point the testing facility verifies the robot’s new position, and in which direction it is pointing.

 The letter-string “RAALAL” means:
 Turn right
 Advance twice
 Turn left
 Advance once
 Turn left yet again
 Say a robot starts at {7, 3} facing north. Then running this stream of instructions should leave it at {9, 4} facing west.*/

public class RobotSimulation {


    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        //N    E       S     W
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


        int x = 7, y = 3, dir = 0;
        String instructions = "RAALAL";

        /*Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc--){
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int curDirection = sc.nextInt();
            String instructions = sc.next();
            printFinalPosition(startX, startY, curDirection, instructions);
        }*/

        for (Character ch : instructions.toCharArray()) {
            if (ch == 'R') {
                dir = (dir + 1) % 4;
            } else if (ch == 'L') {
                if (dir == 0) {
                    dir = 3;
                } else dir -= 1;
            } else {
                x += dirs[dir][0];
                y += dirs[dir][1];
            }
        }

        System.out.println("x : " + x + " y : " + y + " direction : " + dir);


    }

    /*public void printFinalPosition(int startX, int startY, int curDirection, String instructions){
        if(instructions.isEmpty()){
            throw new Inv
        }

    }*/

}