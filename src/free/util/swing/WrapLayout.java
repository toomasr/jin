/**
 * The utillib library.
 * More information is available at http://www.jinchess.com/.
 * Copyright (C) 2007 Alexander Maryanovsky.
 * All rights reserved.
 *
 * The utillib library is free software; you can redistribute
 * it and/or modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * The utillib library is distributed in the hope that it will
 * be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with utillib library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package free.util.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;

import free.util.UnsupportedOperationException;



/**
 * A layout manager which makes the sole content child span the entire area of
 * the parent.
 */

public class WrapLayout implements LayoutManager2{
  
  
  
  /**
   * Our sole instance.
   */
  
  private static final WrapLayout INSTANCE = new WrapLayout();
  
  
  
  /**
   * Returns our sole instance.
   */
  
  public static WrapLayout getInstance(){
    return INSTANCE;
  }
  
  
  
  /**
   * Returns the component to be laid out in the specified container, or
   * <code>null</code> if none. Throws an exception if the specified container
   * may not be laid out by us.
   */
  
  private Component getComponent(Container parent){
    if (parent.getLayout() != this)
      throw new IllegalStateException("parent.getLayout() != this");
    
    int componentCount = parent.getComponentCount();
    if (componentCount > 1)
      throw new IllegalStateException("Only a single component is allowed");
    else if (componentCount == 0)
      return null;
    else
      return parent.getComponent(0);
  }
  
  
  
  /**
   * Lays out the specified container.
   */
  
  public void layoutContainer(Container parent){
    Component component = getComponent(parent);
    if (component == null)
      return;
    
    Dimension size = parent.getSize();
    Insets insets = parent.getInsets();
    component.setBounds(insets.left, insets.top,
        size.width - insets.left - insets.right, size.height - insets.top - insets.bottom);
  }
  
  
  
  /**
   * Appends the specified insets to the specified <code>Dimension</code> object
   * and returns it.
   */
  
  private static Dimension append(Dimension size, Insets insets){
    size.width += insets.left + insets.right;
    size.height += insets.top + insets.bottom;
    
    return size;
  }
  
  
  
  /**
   * Returns the minimum size of the specified container, when laid out by us.
   */
  
  public Dimension minimumLayoutSize(Container parent){
    Component component = getComponent(parent);
    Dimension size = component == null ? new Dimension(0, 0) : component.getMinimumSize();
    Insets insets = parent.getInsets();
    
    return append(size, insets);
  }
  
  
  
  /**
   * Returns the preferred size of the specified container, when laid out by us.
   */
  
  public Dimension preferredLayoutSize(Container parent){
    Component component = getComponent(parent);
    Dimension size = component == null ? new Dimension(0, 0) : component.getPreferredSize();
    Insets insets = parent.getInsets();
    
    return append(size, insets);
  }
  
  
  
  /**
   * Returns the maximum size of the specified container, when laid out by us.
   */
  
  public Dimension maximumLayoutSize(Container parent){
    Component component = getComponent(parent);
    Dimension size = component == null ? new Dimension(0, 0) : component.getMaximumSize();
    Insets insets = parent.getInsets();
    
    return append(size, insets);
  }
  
  
  
  /**
   * Throws an exception.
   */
  
  public void addLayoutComponent(String name, Component comp){
    throw new UnsupportedOperationException("deprecated addLayoutComponent(String, Component)");
  }
  
  
  
  /**
   * Adds the specified component to the layout.
   */
  
  public void addLayoutComponent(Component comp, Object constraints){
    
  }
  
  
  
  /**
   * Removes the specified component from the layout.
   */
  
  public void removeLayoutComponent(Component comp){
    
  }
  
  
  
  /**
   * Returns the x-axis layout alignment of the specified container.
   */
  
  public float getLayoutAlignmentX(Container target){
    return Component.CENTER_ALIGNMENT;
  }
  
  
  
  /**
   * Returns the y-axis layout alignment of the specified container.
   */
  
  public float getLayoutAlignmentY(Container target){
    return Component.CENTER_ALIGNMENT;
  }
  
  
  
  /**
   * Invalidates the layout, dropping any cached values.
   */
  
  public void invalidateLayout(Container target){
    
  }
  
  
  
}
