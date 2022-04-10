package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyPanel extends JPanel {


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        List<Integer> numeros = Arrays.asList(1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16);

        Collections.shuffle(numeros);

        double subFrameStepIterator = 0;
        double subFrameLength = (double) getWidth()/numeros.size();
        double gapPercentage = 10;
        double barGap = (gapPercentage/100) * subFrameLength;
        double barLength = (subFrameLength - (barGap * 2));

        for (int i = 0; i < numeros.size(); i++) {

            g.fillRect((int) (barGap + subFrameStepIterator), (getHeight()/numeros.size()) * numeros.get(i),
                    (int)barLength, getHeight());
            subFrameStepIterator += subFrameLength;
        }



    }

    private class Point{

        public Point() {
        }

        public void setP(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }

}
