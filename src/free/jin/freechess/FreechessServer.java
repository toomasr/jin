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

package free.jin.freechess;

import free.jin.LoginDialog;
import free.jin.Server;
import free.jin.User;


/**
 * An encapsulation of the properties of the freechess.org server.
 */

public class FreechessServer extends Server{



  /**
   * The default constructor.
   */

  public FreechessServer(){

  }



  /**
   * Creates a login dialog.
   */

  public LoginDialog createLoginDialog(){
    return new FreechessLoginDialog(this);
  }



  /**
   * Creates a login dialog.
   */

  public LoginDialog createLoginDialog(User user){
    if (user == null)
      return createLoginDialog();

    return new FreechessLoginDialog(user);
  }


}

