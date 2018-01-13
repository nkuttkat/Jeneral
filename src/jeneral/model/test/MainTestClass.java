/* 
 * Copyright (C) 2018 Nils Kuttkat <nkuttkat@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jeneral.model.test;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import jeneral.model.JeneralGame;
import jeneral.model.JeneralPlayer;
import jeneral.model.map.JeneralGameField;
import jeneral.model.map.JeneralGameMap;
import jeneral.model.map.JeneralTerrain;
import jeneral.view.map.GameMapView;

import abstractgame.view.AbstractFieldView;

/**
 * The Class MainTestClass.
 *
 * @author Nils Kuttkat
 */
public class MainTestClass implements MouseListener {

    /**
     * The attribute panel.
     */
    protected JPanel attributePanel = new JPanel();

    /**
     * The pic label.
     */
    protected JLabel coordsLabel = new JLabel(), contentLabel = new JLabel(),
            picLabel = new JLabel();

    /**
     * The frame.
     */
    protected JFrame frame = new JFrame();

    /**
     * The game.
     */
    protected JeneralGame game;

    /**
     * The map.
     */
    protected JeneralGameMap map;

    /**
     * The map view.
     */
    protected GameMapView mapView;

    /**
     * The player.
     */
    protected JeneralPlayer player;

    /**
     * The player1.
     */
    protected JeneralPlayer player1;

    /**
     * The scrollpane.
     */
    protected JScrollPane scrollpane = new JScrollPane();

    /**
     * The split pane.
     */
    protected JSplitPane splitPane = new JSplitPane();

    /**
     * Instantiates a new main test class.
     */
    public MainTestClass() {
        map = new JeneralGameMap(10, 10);
        game = new JeneralGame(map);
        player = new JeneralPlayer("nils", game);
        player1 = new JeneralPlayer("dödelbert", game);
        this.initTestMap();
        mapView = new GameMapView(map, this);

        frame.setBounds(0, 0, 1000, 740);
        scrollpane.setViewportView(mapView);
        splitPane.setLeftComponent(scrollpane);
        splitPane.setRightComponent(attributePanel);
        splitPane.setDividerLocation((int) Math.round(frame.getWidth() * 0.75));

        frame.add(splitPane);
        attributePanel.add(this.coordsLabel);
        attributePanel.add(this.contentLabel);
        attributePanel.add(this.picLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Inits the test map.
     */
    public void initTestMap() {
        /* set some fields */
 /*
		 * map.setField(5, 9, new GameField(Terrain.WATER)); map.setField(5, 8,
		 * new GameField(Terrain.WATER)); map.setField(5, 7, new
		 * GameField(Terrain.WATER)); map.setField(5, 6, new
		 * GameField(Terrain.WATER)); map.setField(5, 5, new
		 * GameField(Terrain.WATER)); map.setField(6, 9, new
		 * GameField(Terrain.WATER)); map.setField(6, 8, new
		 * GameField(Terrain.WATER)); map.setField(6, 7, new
		 * GameField(Terrain.WATER)); map.setField(6, 6, new
		 * GameField(Terrain.WATER)); map.setField(6, 5, new
		 * GameField(Terrain.WATER)); map.setField(7, 9, new
		 * GameField(Terrain.WATER)); map.setField(7, 8, new
		 * GameField(Terrain.WATER)); map.setField(7, 7, new
		 * GameField(Terrain.WATER)); map.setField(7, 6, new
		 * GameField(Terrain.WATER)); map.setField(7, 5, new
		 * GameField(Terrain.WATER)); map.setField(8, 9, new
		 * GameField(Terrain.WATER)); map.setField(8, 8, new
		 * GameField(Terrain.WATER)); map.setField(8, 7, new
		 * GameField(Terrain.WATER)); map.setField(8, 6, new
		 * GameField(Terrain.WATER)); map.setField(8, 5, new
		 * GameField(Terrain.WATER)); map.setField(4, 9, new
		 * GameField(Terrain.DESERT)); map.setField(4, 8, new
		 * GameField(Terrain.DESERT)); map.setField(4, 7, new
		 * GameField(Terrain.DESERT)); map.setField(4, 6, new
		 * GameField(Terrain.DESERT)); map.setField(4, 5, new
		 * GameField(Terrain.DESERT)); map.setField(4, 4, new
		 * GameField(Terrain.MOUNTAIN)); map.setField(5, 4, new
		 * GameField(Terrain.MOUNTAIN)); map.setField(6, 4, new
		 * GameField(Terrain.MOUNTAIN)); map.setField(7, 4, new
		 * GameField(Terrain.ROUGH)); map.setField(8, 4, new
		 * GameField(Terrain.ROUGH));
         */

        map.setField(2, 1, new JeneralGameField(JeneralTerrain.WATER));
        map.setField(1, 4, new JeneralGameField(JeneralTerrain.WATER));
        map.setField(2, 4, new JeneralGameField(JeneralTerrain.WATER));
        map.setField(3, 4, new JeneralGameField(JeneralTerrain.MOUNTAIN));
        map.setField(4, 4, new JeneralGameField(JeneralTerrain.MOUNTAIN));
        map.setField(4, 3, new JeneralGameField(JeneralTerrain.MOUNTAIN));
        map.setField(5, 3, new JeneralGameField(JeneralTerrain.MOUNTAIN));
        map.setField(4, 1, new JeneralGameField(JeneralTerrain.FOREST));
        map.setField(4, 0, new JeneralGameField(JeneralTerrain.FOREST));
        map.setField(4, 2, new JeneralGameField(JeneralTerrain.DESERT));
        map.setField(5, 2, new JeneralGameField(JeneralTerrain.DESERT));

        // map.setField(0, 4, new GameField(Terrain.WATER));
    }

    /* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent arg0) {

    }

    /* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        coordsLabel.setText("Position: "
                + ((AbstractFieldView) e.getComponent()).getModel().getPosition()
                        .toString());
        contentLabel.setText(((AbstractFieldView) e.getComponent()).getModel()
                .getUnits().toString());

    }

    /* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    /* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    /* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    /**
     * Prints the map.
     */
    public void printMap() {
        int height, width;
        width = map.getFields().length;
        height = map.getFields()[0].length;
        System.out.println("Testkarte " + width + "x" + height + ":");
        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                System.out.print(map.getField(x, y) + "  ");
            }
            System.out.println();
        }

        frame.setVisible(true);
    }
}
