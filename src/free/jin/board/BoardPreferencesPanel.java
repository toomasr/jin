/**
 * Jin - a chess client for internet chess servers.
 * More information is available at http://www.jinchess.com/.
 * Copyright (C) 2002 Alexander Maryanovsky.
 * All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package free.jin.board;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import free.jin.plugin.PreferencesPanel;
import free.util.swing.ColorChooserButton;
import free.util.StringEncoder;
import free.util.StringParser;


/**
 * The preferences panel for the BoardManager plugin.
 */

public class BoardPreferencesPanel extends PreferencesPanel{


  
  /**
   * The BoardManager whose preferences panel this BoardPreferencesPanel is.
   */

  private final BoardManager boardManager;




  /**
   * The ColorChooserButton for selecting the color of the white pieces.
   */

  private final ColorChooserButton whiteColorChooser;




  /**
   * The ColorChooserButton for selecting the color of the black pieces.
   */

  private final ColorChooserButton blackColorChooser;




  /**
   * The ColorChooserButton for selecting the color of the outline for white
   * pieces.
   */

  private final ColorChooserButton whiteOutlineChooser;




  /**
   * The ColorChooserButton for selecting the color of the outline for black
   * pieces.
   */

  private final ColorChooserButton blackOutlineChooser;




  /**
   * The ColorChooserButton for selecting the color of the light squares.
   */

  private final ColorChooserButton lightColorChooser;




  /**
   * The ColorChooserButton for selecting the color of the dark squares.
   */

  private final ColorChooserButton darkColorChooser;



  /**
   * The ColorChooserButton for selecting the move highlighting color.
   */

  private final ColorChooserButton moveHighlightingColorChooser;



  /**
   * The ColorChooserButton for selecting the drag square highlighting color.
   */

  private final ColorChooserButton dragSquareHighlightingColorChooser;




  /**
   * Creates a new BoardPreferencesPanel with the given BoardManager.
   */

  public BoardPreferencesPanel(BoardManager boardManager){
    this.boardManager = boardManager;

    whiteColorChooser = new ColorChooserButton("White pieces", getColorProperty("white-piece-color", Color.white));
    blackColorChooser = new ColorChooserButton("Black pieces", getColorProperty("black-piece-color", Color.black));
    whiteOutlineChooser = new ColorChooserButton("White pieces' outline", getColorProperty("white-outline-color", Color.black));
    blackOutlineChooser = new ColorChooserButton("Black pieces' outline", getColorProperty("black-outline-color", Color.white));

    whiteColorChooser.setMnemonic('W');
    blackColorChooser.setMnemonic('B');
    whiteOutlineChooser.setMnemonic('p');
    blackOutlineChooser.setMnemonic('k');


    lightColorChooser = new ColorChooserButton("Light squares", getColorProperty("light-square-color", new Color(255,207,144)));
    darkColorChooser = new ColorChooserButton("Dark squares", getColorProperty("dark-square-color", new Color(143,96,79)));

    lightColorChooser.setMnemonic('L');
    darkColorChooser.setMnemonic('D');


    moveHighlightingColorChooser = new ColorChooserButton("Move highlighting", getColorProperty("move-highlighting-color", boardManager.getMoveHighlightingColor()));
    dragSquareHighlightingColorChooser = new ColorChooserButton("Drag square highlighting", getColorProperty("drag-square-highlighting-color", boardManager.getDragSquareHighlightingColor()));

    moveHighlightingColorChooser.setMnemonic('M');
    dragSquareHighlightingColorChooser.setMnemonic('s');


    ChangeListener changeNotifyListener = new ChangeListener(){
      public void stateChanged(ChangeEvent evt){
        fireStateChanged();
      }
    };

    whiteColorChooser.addChangeListener(changeNotifyListener);
    blackColorChooser.addChangeListener(changeNotifyListener);
    whiteOutlineChooser.addChangeListener(changeNotifyListener);
    blackOutlineChooser.addChangeListener(changeNotifyListener);
    lightColorChooser.addChangeListener(changeNotifyListener);
    darkColorChooser.addChangeListener(changeNotifyListener);
    moveHighlightingColorChooser.addChangeListener(changeNotifyListener);
    dragSquareHighlightingColorChooser.addChangeListener(changeNotifyListener);

    createUI();
  }




  /**
   * Returns the given color property. If there is no such property, returns the
   * given default.
   */

  private Color getColorProperty(String name, Color defaultValue){
    String value = boardManager.getProperty(name);
    if (value == null)
      return defaultValue;
    else
      return StringParser.parseColor(value);
  }




  /**
   * Creates the UI.
   */

  private void createUI(){
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JPanel piecesPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    piecesPanel.add(whiteColorChooser);
    piecesPanel.add(blackColorChooser);
    piecesPanel.add(whiteOutlineChooser);
    piecesPanel.add(blackOutlineChooser);
    Border innerBorder = new EmptyBorder(5, 5, 5, 5);
    Border outerBorder = new TitledBorder(" Piece preferences (*) ");
    piecesPanel.setBorder(new CompoundBorder(outerBorder, innerBorder));

    JPanel boardPanel = new JPanel(new GridLayout(1, 2, 5, 5));
    boardPanel.add(lightColorChooser);
    boardPanel.add(darkColorChooser);
    innerBorder = new EmptyBorder(5, 5, 5, 5);
    outerBorder = new TitledBorder(" Board preferences (*) ");
    boardPanel.setBorder(new CompoundBorder(outerBorder, innerBorder));

    JPanel highlightPanel = new JPanel(new GridLayout(1, 2, 5, 5));
    highlightPanel.add(moveHighlightingColorChooser);
    highlightPanel.add(dragSquareHighlightingColorChooser);
    innerBorder = new EmptyBorder(5, 5, 5, 5);
    outerBorder = new TitledBorder(" Highlighting preferences ");
    highlightPanel.setBorder(new CompoundBorder(outerBorder, innerBorder));

    JPanel notePanel = new JPanel(new BorderLayout());
    notePanel.add(new JLabel("* - Note that the color preferences only affect vector pieces and the solid color board"), BorderLayout.CENTER);

    add(piecesPanel);
    add(Box.createVerticalStrut(10));
    add(boardPanel);
    add(Box.createVerticalStrut(10));
    add(highlightPanel);
    add(Box.createVerticalStrut(10));
    add(notePanel);
  }




  /**
   * Applies the changes done by the user.
   */

  public void applyChanges(){
    maybeSetColorProperty("white-piece-color", whiteColorChooser.getColor());
    maybeSetColorProperty("black-piece-color", blackColorChooser.getColor());
    maybeSetColorProperty("white-outline-color", whiteOutlineChooser.getColor());
    maybeSetColorProperty("black-outline-color", blackOutlineChooser.getColor());

    maybeSetColorProperty("light-square-color", lightColorChooser.getColor());
    maybeSetColorProperty("dark-square-color", darkColorChooser.getColor());

    maybeSetColorProperty("move-highlighting-color", moveHighlightingColorChooser.getColor());
    maybeSetColorProperty("drag-square-highlighting-color", dragSquareHighlightingColorChooser.getColor());

    boardManager.refreshFromProperties(true);
  }




  /**
   * If the current value of the color property is the same as the new one, does
   * nothing. Otherwise, sets the user property to the given color.
   */

  private void maybeSetColorProperty(String name, Color newValue){
    if (newValue.equals(getColorProperty(name, null)))
      return;

    boardManager.setProperty(name, StringEncoder.encodeColor(newValue), true);
  }

}
