package Units;

import java.util.ArrayList;

public interface InterfaceUnit {

    void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends);

    String getInfo();

}
