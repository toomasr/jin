/**
 * Jin - a chess client for internet chess servers.
 * More information is available at http://www.jinchess.com/.
 * Copyright (C) 2008 Alexander Maryanovsky.
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

package free.jin.console.icc;

import free.jin.console.ConsoleManager;
import free.jin.console.ics.IcsCustomConsolesPrefsPanel;



/**
 * An ICC-specific <code>CustomConsolesPrefsPanel</code>.
 * 
 * @author Maryanovsky Alexander
 */

public class ChessclubCustomConsolesPrefsPanel extends IcsCustomConsolesPrefsPanel{
  
  
  
  /**
   * Creates a new <code>ChessclubCustomConsolesPrefsPanel</code> for the
   * specified console manager.
   */
  
  public ChessclubCustomConsolesPrefsPanel(ConsoleManager cm){
    super(cm);
  }
  
  
  
}
