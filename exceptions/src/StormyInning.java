/**
 * Created by Dmitriy on 25.12.2019.
 */
class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}
class UmpireException extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}

    public void meth() throws UmpireException {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    public StormyInning() throws RainedOut, BaseballException, UmpireException {}
    public StormyInning(String s) throws Foul, BaseballException {}

//    void walk() throw PopFoul{}
//    public void event() throws RainedOut {}
    public void rainHard() throws RainedOut {}
    public void event() {}
    public void atBat() throws Strike {}

    public void meth() throws UmpireException {
        super.meth();
        throw new UmpireException();
    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
            si.meth();
        }catch(UmpireException e) {
            System.out.println("UmpireException");
        } catch(PopFoul e) {
            System.out.println("Pop foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("RaindeOut");
        } catch (BaseballException e) {
            System.out.println("Общее исключение");
        }
    }
}
