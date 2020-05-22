package Objects.FirerStrategy;

import Factory.I_Factory;
import Objects.GameObjs.Tank;

public interface Firer{
    void fire(Tank tank, I_Factory factory);
}
