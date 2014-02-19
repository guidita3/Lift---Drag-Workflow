/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Pereira
 */
public class Graph extends JPanel {
   public Graph() {
      setSize(500, 500);
   }

   @Override
   public void paintComponent(Graphics g) {
      Graphics2D gr = (Graphics2D) g; // this is if you want to use Graphics2D
      // now do the drawing here
      ArrayList<Integer> scores = new ArrayList<>(10);

      Random r = new Random();

      for (int i : scores) {
         i = r.nextInt(20);
         System.out.println(r);
      }

      int y1;
      int y2;

      for (int i = 0; i < scores.size() - 1; i++) {
         y1 = (scores.get(i)) * 10;
         y2 = (scores.get(i + 1)) * 10;
         gr.drawLine(i * 10, y1, (i + 1) * 10, y2);
      }
   }
}
