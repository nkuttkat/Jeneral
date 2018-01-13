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

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import jeneral.model.JeneralGame;
import jeneral.model.JeneralPlayer;
import jeneral.model.map.JeneralGameField;
import jeneral.model.map.JeneralGameMap;
import jeneral.model.map.JeneralTerrain;
import jeneral.view.map.GameFieldView;
import jeneral.view.map.GameMapView;
import jeneral.view.units.BuggyView;
import jeneral.view.units.CruiserView;
import jeneral.view.units.FighterView;
import jeneral.view.units.TankView;
import jeneral.view.units.TruckView;

import abstractgame.unit.AbstractUnit;

/**
 * The Class TestMapBuilder.
 *
 * @author Nils Kuttkat
 */
public class TestMapBuilder {

    /**
     * The listener interface for receiving gameFieldContextMenu events. The
     * class that is interested in processing a gameFieldContextMenu event
     * implements this interface, and the object created with that class is
     * registered with a component using the component's <code>addGameFieldContextMenuListener<code> method. When
     * the gameFieldContextMenu event occurs, that object's appropriate
     * method is invoked.
     *
     * @see GameFieldContextMenuEvent
     */
    private class GameFieldContextMenuListener implements ActionListener {

        /* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            JeneralGameField gameField = (JeneralGameField) selectedGameFieldView
                    .getModel();
            gameField.setTerrain(JeneralTerrain.valueOf(event
                    .getActionCommand()));
            selectedGameFieldView.repaint();
        }

    }

    /**
     * The listener interface for receiving gameFieldView events. The class that
     * is interested in processing a gameFieldView event implements this
     * interface, and the object created with that class is registered with a
     * component using the component's <code>addGameFieldViewListener<code> method. When
     * the gameFieldView event occurs, that object's appropriate
     * method is invoked.
     *
     * @see GameFieldViewEvent
     */
    private class GameFieldViewListener extends MouseAdapter {

        /* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseClicked(MouseEvent event) {
            if (moveMode == true) {

            }
        }

        /* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseEntered(MouseEvent event) {
            GameFieldView field = (GameFieldView) event.getComponent();
            fieldLabel.setText(field.getModel().toString());
        }

        /* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseReleased(MouseEvent event) {
            if (event.getButton() == MouseEvent.BUTTON3) {
                selectedGameFieldView = (GameFieldView) event.getComponent();
                popupMenu
                        .show(event.getComponent(), event.getX(), event.getY());
            }
        }
    }

    /**
     * The listener interface for receiving gameMenu events. The class that is
     * interested in processing a gameMenu event implements this interface, and
     * the object created with that class is registered with a component using
     * the component's <code>addGameMenuListener<code> method. When
     * the gameMenu event occurs, that object's appropriate
     * method is invoked.
     *
     * @see GameMenuEvent
     */
    private class GameMenuListener implements ActionListener {

        /* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand() == "Save map") {
                TestMapBuilder.this.saveMap();
            } else if (event.getActionCommand() == "Load map") {
                TestMapBuilder.this.loadMap();
            }
        }

    }

    /**
     * The listener interface for receiving unitView events. The class that is
     * interested in processing a unitView event implements this interface, and
     * the object created with that class is registered with a component using
     * the component's <code>addUnitViewListener<code> method. When
     * the unitView event occurs, that object's appropriate
     * method is invoked.
     *
     * @see UnitViewEvent
     */
    private class UnitViewListener extends MouseAdapter {

        /* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseClicked(MouseEvent event) {
            selectedUnit = null;
            TestMapBuilder.this.moveModeOn();

            if (((AbstractUnit) event.getSource()).getPosition() == null) {
                if (event.getComponent() instanceof TruckView) {
                    selectedUnit = new Truck(game,
                            TestMapBuilder.this.getCurrentPlayer());
                } else if (event.getComponent() instanceof TankView) {
                    selectedUnit = new Tank(game,
                            TestMapBuilder.this.getCurrentPlayer());
                } else if (event.getComponent() instanceof BuggyView) {
                    selectedUnit = new Buggy(game,
                            TestMapBuilder.this.getCurrentPlayer());
                } else if (event.getComponent() instanceof CruiserView) {
                    selectedUnit = new Cruiser(game,
                            TestMapBuilder.this.getCurrentPlayer());
                } else if (event.getComponent() instanceof FighterView) {
                    selectedUnit = new Fighter(game,
                            TestMapBuilder.this.getCurrentPlayer());
                }
            } else {

            }
        }

        /* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
        }

        /* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
         */
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
        }
    }

    /**
     * Launch the application.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TestMapBuilder window = new TestMapBuilder();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * The button group.
     */
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * The field label.
     */
    private JLabel fieldLabel;

    /**
     * The frame.
     */
    private JFrame frame;

    /**
     * The game.
     */
    private JeneralGame game;

    /**
     * The game map.
     */
    private JeneralGameMap gameMap;

    /**
     * The game map view.
     */
    private GameMapView gameMapView;

    /**
     * The move mode.
     */
    private boolean moveMode = false;

    /**
     * The player2.
     */
    private JeneralPlayer player1, player2;

    /**
     * The player1 radio button.
     */
    private JRadioButton player1RadioButton;

    /**
     * The player2 radio button.
     */
    private JRadioButton player2RadioButton;

    /**
     * The popup menu.
     */
    private JPopupMenu popupMenu;

    /**
     * The scroll pane.
     */
    private JScrollPane scrollPane;

    /**
     * The selected game field view.
     */
    private GameFieldView selectedGameFieldView;

    /**
     * The selected unit.
     */
    @SuppressWarnings("unused")
    private AbstractUnit selectedUnit;

    /**
     * Create the application.
     */
    public TestMapBuilder() {
        initialize();
    }

    /**
     * Gets the current player.
     *
     * @return the current player
     */
    public JeneralPlayer getCurrentPlayer() {
        JeneralPlayer player = null;

        if (player1RadioButton.isSelected()) {
            player = player1;
        } else if (player2RadioButton.isSelected()) {
            player = player2;
        }

        return player;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        gameMap = new JeneralGameMap(20, 20);
        game = new JeneralGame(gameMap);
        player1 = new JeneralPlayer("nils", game);
        player2 = new JeneralPlayer("rene", game);

        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(1.0);
        frame.getContentPane().add(splitPane);

        scrollPane = new JScrollPane();
        splitPane.setLeftComponent(scrollPane);

        gameMapView = new GameMapView(gameMap, new GameFieldViewListener());
        scrollPane.setViewportView(gameMapView);

        popupMenu = new JPopupMenu();
        popupMenu.setBounds(0, 0, 200, 50);
        for (JeneralTerrain terrain : JeneralTerrain.values()) {
            JMenuItem menuItem = new JMenuItem(terrain.toString());
            popupMenu.add(menuItem);
            menuItem.addActionListener(new GameFieldContextMenuListener());
        }
        gameMapView.add(popupMenu);

        JSplitPane splitPane_1 = new JSplitPane();
        splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setRightComponent(splitPane_1);

        JPanel panel = new JPanel();
        splitPane_1.setLeftComponent(panel);

        JLabel lblNewLabel = new JLabel("Field:");
        panel.add(lblNewLabel);

        fieldLabel = new JLabel("");
        panel.add(fieldLabel);

        JPanel panel_1 = new JPanel();
        splitPane_1.setRightComponent(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        player1RadioButton = new JRadioButton("Player1");
        buttonGroup.add(player1RadioButton);
        panel_1.add(player1RadioButton);

        player2RadioButton = new JRadioButton("Player2");
        buttonGroup.add(player2RadioButton);
        panel_1.add(player2RadioButton);

        TruckView truckView = new TruckView(null);
        truckView.addMouseMotionListener(new UnitViewListener());
        panel_1.add(truckView);

        TankView tankView = new TankView(new Tank(game, null));
        tankView.addMouseMotionListener(new UnitViewListener());
        panel_1.add(tankView);

        FighterView fighterView = new FighterView(new Fighter(game, null));
        fighterView.addMouseMotionListener(new UnitViewListener());
        panel_1.add(fighterView);

        BuggyView buggyView = new BuggyView(new Buggy(game, null));
        buggyView.addMouseMotionListener(new UnitViewListener());
        panel_1.add(buggyView);

        CruiserView cruiserView = new CruiserView(new Cruiser(game, null));
        cruiserView.addMouseMotionListener(new UnitViewListener());
        panel_1.add(cruiserView);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Save map");
        mntmNewMenuItem.addActionListener(new GameMenuListener());

        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Load map");
        mntmNewMenuItem_1.addActionListener(new GameMenuListener());
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("New map");
        mnNewMenu.add(mntmNewMenuItem_2);
    }

    /**
     * Load map.
     */
    public void loadMap() {
        InputStream fileInputStream = null;
        String fileName = "";
        FileDialog fileDialog = new FileDialog(this.frame);
        fileDialog.setMode(FileDialog.LOAD);
        fileDialog.setVisible(true);

        try {
            if (fileDialog.getDirectory() != null && fileDialog.getFile() != null) {
                fileName = fileDialog.getDirectory() + fileDialog.getFile();

            } else if (fileDialog.getFile() != null) {
                fileName = fileDialog.getFile();
            }

            fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.gameMap = (JeneralGameMap) objectInputStream.readObject();
            gameMapView = new GameMapView(this.gameMap, new GameFieldViewListener());
            scrollPane.setViewportView(gameMapView);
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Move mode off.
     */
    public void moveModeOff() {
        this.moveMode = false;
        this.gameMapView.setCursor(Cursor
                .getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    /**
     * Move mode on.
     */
    public void moveModeOn() {
        this.moveMode = true;
        this.gameMapView.setCursor(Cursor
                .getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    /**
     * Save map.
     */
    public void saveMap() {
        OutputStream fileOutputStream = null;
        String fileName = "";
        FileDialog fileDialog = new FileDialog(this.frame);
        fileDialog.setMode(FileDialog.SAVE);
        fileDialog.setVisible(true);

        try {
            if (fileDialog.getDirectory() != null
                    && fileDialog.getFile() != null) {
                fileName = fileDialog.getDirectory() + fileDialog.getFile();

            } else if (fileDialog.getFile() != null) {
                fileName = fileDialog.getFile();
            }

            fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    fileOutputStream);
            objectOutputStream.writeObject(gameMap);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
