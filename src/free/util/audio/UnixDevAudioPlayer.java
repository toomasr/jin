/**
 * Jin - a chess client for internet chess servers.
 * More information is available at http://www.hightemplar.com/jin/.
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

package free.util.audio;

import java.io.*;
import java.util.Hashtable;
import free.util.IOUtilities;


/**
 * This is an AudioPlayer implementation for unix boxes which opens /dev/audio
 * as a file and writes the audio data into it.
 */

public class UnixDevAudioPlayer implements AudioPlayer{




  /**
   * Returns true if the file "/dev/audio" exists.
   */

  public boolean isSupported(){
    return new File("/dev/audio").exists();
  }




  /**
   * Writes the sound data of the given AudioClip into /dev/audio. Throws an 
   * IOException if unsuccessful.
   */

  public void play(AudioClip clip) throws IOException{
    OutputStream out = null;
    try{
      byte [] data = clip.getData();
      out = new FileOutputStream("/dev/audio");
      InputStream in = new ByteArrayInputStream(data);
      IOUtilities.pump(in, out);
    }
    finally{
      if (out!=null)
        out.close();
    }
  }

}
