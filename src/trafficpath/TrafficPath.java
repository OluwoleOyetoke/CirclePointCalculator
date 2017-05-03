/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Oluwole_Jnr
 */
public class TrafficPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
      
        
      
        
   //getCentreTrack(233, 129, 0, 129 );// Zone 1 Centre Car
   //getCentreTrack(89, 6, 89, 339 );// Zone 2 Centre Car
   //getCentreTrack(6, 189, 239, 189 );// Zone 3 Centre Car
   //getCentreTrack(149, 313, 149, 0 );// Zone 4 Centre Car


   
      // getRightTracker(233, 114, 164, 114, 1); //Zone 1 Car Right
       //getRightTracker(74, 6, 74, 114, 2); //Zone 2 Car Right
      //getRightTracker(6, 204, 74, 204, 3); //Zone 3 Car Right
   //    getRightTracker(164, 313, 164, 204, 4); //Zone 4 Car Right
   
        
        
//LEFT FOR ZONE 1 TO 4        
//getZone1LeftCarTrack();
//getZone2LeftCarTrack();
//getZone3LeftCarTrack();
getZone4LeftCarTrack();

    }
    
    
    static void getCentreTrack(int startx, int starty, int endx, int endy){
        
        ArrayList listx = new ArrayList();
        ArrayList listy = new ArrayList();
        
        int xMove=startx;
        int yMove=starty;
        
           listx.add(xMove);
           listy.add(yMove);
        
        if(starty==endy){
            while(xMove!=endx){
            if(startx>=endx){
               
                xMove = xMove-1;
                 listx.add(xMove);
                listy.add(yMove);
            }else{
              
                xMove = xMove+1; 
                  listx.add(xMove);
                listy.add(yMove);
            }
            }
        }
        else if(startx==endx){
               while(yMove!=endy){
            if(starty>=endy){
              
                yMove = yMove-1;
                  listx.add(xMove);
                listy.add(yMove);
            }else{
               
                yMove = yMove+1;
                 listx.add(xMove);
                listy.add(yMove);
            }
            }
        }
        
        
        
            printList(listx,  listy);
    }
    
    
    //turn, 0 =left, 1 = right
    static void getRightTracker(int startx, int starty, int midendx, int midendy, int zone){
        
        
         ArrayList listx = new ArrayList();
        ArrayList listy = new ArrayList();
        
        int xMove=startx;
        int yMove=starty;
        
           listx.add(xMove);
           listy.add(yMove);
        
        if(starty==midendy){
            while(xMove!=midendx){
            if(startx>=midendx){
               
                xMove = xMove-1;
                 listx.add(xMove);
                listy.add(yMove);
            }else{
              
                xMove = xMove+1; 
                  listx.add(xMove);
                listy.add(yMove);
            }
            }
        }
        else if(startx==midendx){
               while(yMove!=midendy){
            if(starty>=midendy){
              
                yMove = yMove-1;
                  listx.add(xMove);
                listy.add(yMove);
            }else{
               
                yMove = yMove+1;
                 listx.add(xMove);
                listy.add(yMove);
            }
            }
        }
        
        
        
        if(zone==1){
            while(yMove>0){
                yMove = yMove-1;
                listx.add(xMove);
                listy.add(yMove);
            }
        } else if(zone==2){
            while(xMove>0){
                xMove = xMove-1;
                listx.add(xMove);
                listy.add(yMove);
            }
        }else if(zone==3){
            while(yMove<319){
                yMove = yMove+1;
                listx.add(xMove);
                listy.add(yMove);
            }
        }else if(zone==4){
            while(xMove<239){
                xMove = xMove+1;
                listx.add(xMove);
                listy.add(yMove);
            }
        }
        
        
        
            printList(listx,  listy);
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     static void getZone4LeftCarTrack() {

        int h = 89;
        int k = 189;

        int Orientation = 1; //0==x, 1==y;

        ArrayList xCurv = zone4CurvGen(h, k, 0);
        ArrayList yCurv = zone4CurvGen(h, k, 1);
        
         //printList(xCurv, yCurv);
        
       
        int[] sortedyCurvArray = convertListToArray(yCurv);
        Arrays.sort(sortedyCurvArray );
        

        
      
        ArrayList sortedXCurv = new ArrayList();
        ArrayList sortedYCurv =  new ArrayList();
        int least=0;
        int leastIndex=0;
       
       
        for(int i=0; i<sortedyCurvArray.length; i++){
            for(int j=0; j<sortedyCurvArray.length; j++){
            if(Integer.parseInt(yCurv.get(j).toString())==sortedyCurvArray[i]){
                sortedXCurv.add(xCurv.get(j).toString());
                sortedYCurv.add(yCurv.get(j).toString());
            }
            
            }
        }
        
        Collections.reverse(sortedXCurv);
         Collections.reverse(sortedYCurv);
       //  printList(sortedXCurv, sortedYCurv);
        ArrayList xAxis = new ArrayList();
        ArrayList yAxis = new ArrayList();

        int xMovementCount = 134;
        int yMovementCount = 313;

        while (xMovementCount > 0) {

            if (yMovementCount == 189) {
                //begin moving on the curve
                for (int i = 0; i < sortedXCurv.size(); i++) {
                    xAxis.add(sortedXCurv.get(i));
                    yAxis.add(sortedYCurv.get(i));
                    xMovementCount = Integer.parseInt(sortedXCurv.get(i).toString());
                    yMovementCount = Integer.parseInt(sortedYCurv.get(i).toString());
                }
                
                Orientation = 0;
            } else if (Orientation == 0) {
                xMovementCount = xMovementCount - 1;
                xAxis.add(xMovementCount);
                yAxis.add(yMovementCount);
            } else {
                yMovementCount = yMovementCount - 1;
                xAxis.add(xMovementCount);
                yAxis.add(yMovementCount);
            }

        }
        printList(xAxis, yAxis);

    }
    
    
    
    
    
     static ArrayList zone4CurvGen(int h, int k, int ret) {


        int left = 0;
        int right = 0;
        int leftTotal = 0;
        int radius = 45;
        int radiusSquared = radius * radius;
        ArrayList xlist = new ArrayList();
        ArrayList ylist = new ArrayList();

        for (int y = 0; y < 320; y++) {

            for (int x = 0; x < 240; x++) {
                left = (x - h) * (x - h);
                right = (y - k) * (y - k);
                leftTotal = left + right;
                if (leftTotal == radiusSquared) {
                    if ((y >= (k-radius) && y <= k) && ((x >= h )&& (x <= h+radius))) {
                        xlist.add(x);
                        ylist.add(y);
                       // System.out.println(y);
                    }
                }

            }

        }
      //  xlist.remove(0);
       // ylist.remove(0);
      
        if (ret == 0) {
            return xlist;
        } else {
            return ylist;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     static void getZone3LeftCarTrack() {

        int h = 89;
        int k = 129;

        int Orientation = 0; //0==x, 1==y;

        ArrayList xCurv = zone3CurvGen(h, k, 0);
        ArrayList yCurv = zone3CurvGen(h, k, 1);
        
       
        int[] sortedxCurvArray = convertListToArray(xCurv);
        Arrays.sort(sortedxCurvArray);
      
        ArrayList sortedXCurv = new ArrayList();
        ArrayList sortedYCurv =  new ArrayList();
        int least=0;
        int leastIndex=0;
       
        least = Integer.parseInt(xCurv.get(0).toString());
        for(int i=0; i<sortedxCurvArray.length; i++){
            for(int j=0; j<sortedxCurvArray.length; j++){
            if(Integer.parseInt(xCurv.get(j).toString())==sortedxCurvArray[i]){
                sortedXCurv.add(xCurv.get(j).toString());
                sortedYCurv.add(yCurv.get(j).toString());
            }
            
            }
        }
        // printList(sortedXCurv, sortedYCurv);
        ArrayList xAxis = new ArrayList();
        ArrayList yAxis = new ArrayList();

        int xMovementCount = 6;
        int yMovementCount = 174;

        while (yMovementCount > 0) {

            if (xMovementCount == 89) {
                //begin moving on the curve
                for (int i = 0; i < sortedXCurv.size(); i++) {
                    xAxis.add(sortedXCurv.get(i));
                    yAxis.add(sortedYCurv.get(i));
                    xMovementCount = Integer.parseInt(sortedXCurv.get(i).toString());
                    yMovementCount = Integer.parseInt(sortedYCurv.get(i).toString());
                }
                
                Orientation = 1;
            } else if (Orientation == 0) {
                xMovementCount = xMovementCount + 1;
                xAxis.add(xMovementCount);
                yAxis.add(yMovementCount);
            } else {
                yMovementCount = yMovementCount - 1;
                xAxis.add(xMovementCount);
                yAxis.add(yMovementCount);
            }

        }
       printList(xAxis, yAxis);

    }
    
    
    
    
    
     static ArrayList zone3CurvGen(int h, int k, int ret) {


        int left = 0;
        int right = 0;
        int leftTotal = 0;
        int radius = 45;
        int radiusSquared = radius * radius;
        ArrayList xlist = new ArrayList();
        ArrayList ylist = new ArrayList();

        for (int y = 0; y < 320; y++) {

            for (int x = 0; x < 240; x++) {
                left = (x - h) * (x - h);
                right = (y - k) * (y - k);
                leftTotal = left + right;
                if (leftTotal == radiusSquared) {
                    if ((y <= (k+radius) && y >= k) && ((x >= h )&& (x <= (h+radius)))) {
                        xlist.add(x);
                        ylist.add(y);
                        //System.out.println(y);
                    }
                }

            }

        }
        //xlist.remove(0);
        //ylist.remove(0);
      
        if (ret == 0) {
            return xlist;
        } else {
            return ylist;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    static void getZone2LeftCarTrack() {

        int h = 149;
        int k = 129;

        int Orientation = 1; //0==x, 1==y;

        ArrayList xCurv = zone2CurvGen(h, k, 0);
        ArrayList yCurv = zone2CurvGen(h, k, 1);

        ArrayList xAxis = new ArrayList();
        ArrayList yAxis = new ArrayList();

        int xMovementCount = 104;
        int yMovementCount = 6;

        while (xMovementCount < 240) {

            if (yMovementCount == 129) {
                //begin moving on the curve
                for (int i = 0; i < xCurv.size(); i++) {
                    xAxis.add(xCurv.get(i));
                    yAxis.add(yCurv.get(i));
                    xMovementCount = Integer.parseInt(xCurv.get(i).toString());
                    yMovementCount = Integer.parseInt(yCurv.get(i).toString());
                }
                Orientation = 0;
            } else if (Orientation == 0) {
                xMovementCount = xMovementCount + 1;
                xAxis.add(xMovementCount);
                yAxis.add(yMovementCount);
            } else {
                yMovementCount = yMovementCount + 1;
                xAxis.add(xMovementCount);
                yAxis.add(yMovementCount);
            }

        }
        printList(xAxis, yAxis);

    }
    
    
    
    
    
     static ArrayList zone2CurvGen(int h, int k, int ret) {


        int left = 0;
        int right = 0;
        int leftTotal = 0;
        int radius = 45;
        int radiusSquared = radius * radius;
        ArrayList xlist = new ArrayList();
        ArrayList ylist = new ArrayList();

        for (int y = 0; y < 320; y++) {

            for (int x = 0; x < 240; x++) {
                left = (x - h) * (x - h);
                right = (y - k) * (y - k);
                leftTotal = left + right;
                if (leftTotal == radiusSquared) {
                    if ((y <= (k+radius) && y >= k) && (x >= (h-radius) && x <= h)) {
                        xlist.add(x);
                        ylist.add(y);
                    }
                }

            }

        }
        xlist.remove(0);
        ylist.remove(0);
        if (ret == 0) {
            return xlist;
        } else {
            return ylist;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    

    static void getZone1LeftCarTrack() {

        int h = 149;
        int k = 189;

        int Orientation = 0; //0==x, 1==y;

        ArrayList xCurv = zone1CurvGen(h, k, 0);
        ArrayList yCurv = zone1CurvGen(h, k, 1);
    printList(xCurv, yCurv);
        ArrayList xAxis = new ArrayList();
        ArrayList yAxis = new ArrayList();

        int xMovementCount = 233;
        int yMovementCount = 144;

        while (yMovementCount < 320) {

            if (xMovementCount == 149) {
                //begin moving on the curve
                for (int i = 0; i < xCurv.size(); i++) {
                    xAxis.add(xCurv.get(i));
                    yAxis.add(yCurv.get(i));
                    xMovementCount = Integer.parseInt(xCurv.get(i).toString());
                    yMovementCount = Integer.parseInt(yCurv.get(i).toString());
                }
                Orientation = 1;
            } else if (Orientation == 0) {
                xMovementCount = xMovementCount - 1;
                xAxis.add(xMovementCount);
                yAxis.add(yMovementCount);
            } else {
                yMovementCount = yMovementCount + 1;
                xAxis.add(xMovementCount);
                yAxis.add(yMovementCount);
            }

        }
        printList(xAxis, yAxis);

    }

    static ArrayList zone1CurvGen(int h, int k, int ret) {
        Object[] list = new Object[2];

        int left = 0;
        int right = 0;
        int leftTotal = 0;
        int radius = 45;
        int radiusSquared = radius * radius;
        ArrayList xlist = new ArrayList();
        ArrayList ylist = new ArrayList();

        for (int y = 0; y < 320; y++) {

            for (int x = 0; x < 240; x++) {
                left = (x - h) * (x - h);
                right = (y - k) * (y - k);
                leftTotal = left + right;
                if (leftTotal == radiusSquared) {
                    if ((y <= k && y >= (k - radius)) && (x <= h && x >= (h - radius))) {
                        xlist.add(x);
                        ylist.add(y);
                    }
                }

            }

        }
        xlist.remove(0);
        ylist.remove(0);
        if (ret == 0) {
            return xlist;
        } else {
            return ylist;
        }
    }

    static void printList(ArrayList x, ArrayList y) {
        int a=1;
        for (int i = 0; i < x.size(); i++) {
            System.out.println(a+". (" + x.get(i) + ", " + y.get(i) + ")");
a++;
        }
    }
    
    
    static int[] convertListToArray(ArrayList list){
        int[] toreturn = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            toreturn[i] = Integer.parseInt(list.get(i).toString()); 
        }
        return toreturn;
    }

}
