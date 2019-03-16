package org.arcanium.game.world.map;

/**
 * Created by Jacob on 8/13/2017.
 */
public class RunningDirection {

    public static enum RunDir {
	EE(8), N_EE(10), N_WW(9), NN(13), NN_E(14), NN_EE(15), NN_W(12), NN_WW(11), S_EE(6), S_WW(5), SS(2), SS_E(3), SS_EE(4), SS_W(1), SS_WW(0), WW(7);
	private int dir;

        RunDir(int dir) {
            this.dir = dir;
        }

        public int intValue() {
            return dir;
        }

        public int npcIntValue() {
            throw new UnsupportedOperationException("The GNP protocol does not support 2 step running directions!");
        }

        @Override
        public String toString() {
            return "[run] [dir=" + dir + ", type=" + super.toString() + "]";
        }
    }


    public static RunDir runningDirectionFor(int dirX, int dirY) {
        switch (dirX) {
            case -2:
                switch (dirY) {
                    case -2:
                        return RunDir.SS_WW;
                    case -1:
                        return RunDir.S_WW;
                    case 0:
                        return RunDir.WW;
                    case 1:
                        return RunDir.N_WW;
                    case 2:
                        return RunDir.NN_WW;
                }
                return null;
            case -1:
                switch (dirY) {
                    case -2:
                        return RunDir.SS_W;
                    case 2:
                        return RunDir.NN_W;
                }
                return null;
            case 0:
                switch (dirY) {
                    case -2:
                        return RunDir.SS;
                    case 2:
                        return RunDir.NN;
                }
                return null;
            case 1:
                switch (dirY) {
                    case -2:
                        return RunDir.SS_E;
                    case 2:
                        return RunDir.NN_E;
                }
                return null;
            case 2:
                switch (dirY) {
                    case -2:
                        return RunDir.SS_EE;
                    case -1:
                        return RunDir.S_EE;
                    case 0:
                        return RunDir.EE;
                    case 1:
                        return RunDir.N_EE;
                    case 2:
                        return RunDir.NN_EE;
                }
                return null;
        }
        return null;
    }

}
