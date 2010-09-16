// This file is part of the "IBController".
// Copyright (C) 2004 Steven M. Kearns (skearns23@yahoo.com )
// Copyright (C) 2004, 2005, 2006, 2007, 2008, 2009, 2010 Richard L King (rlking@aultan.com)
// For conditions of distribution and use, see copyright notice in COPYING.txt

// IBController is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// IBController is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with Foobar.  If not, see <http://www.gnu.org/licenses/>.

package ibcontroller;

import java.awt.Window;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

class GatewayMainWindowFrameHandler  implements WindowHandler {
    public void handleWindow(Window window, int eventID) {
        if (eventID != WindowEvent.WINDOW_OPENED) return;

        TwsListener.setMainWindow((JFrame) window);
        if (Settings.getBoolean("MinimizeMainWindow", false)) {
            TwsListener.getMainWindow().setExtendedState(java.awt.Frame.ICONIFIED);
        }
    }

    public boolean recogniseWindow(Window window) {
        if (! (window instanceof JFrame)) return false;

        return (((JFrame) window).getTitle().contains("Interactive Brokers Gateway") ||
                ((JFrame) window).getTitle().contains("IB Gateway"));
    }

}
