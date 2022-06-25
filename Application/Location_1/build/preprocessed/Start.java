import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.*;
import javax.microedition.location.*;
//author Ktdj
public class Start extends MIDlet
implements  CommandListener,Runnable, LocationListener{
    
    private Form mMainForm;
    private Command mGoCommand;

    private double topleftlat=32.863367;
    private double topleftlon=59.190000;
    private double downrightlat=32.860871;
    private double downrightlon=59.196684;
    private double mapwidth=360;
    private double mapheight=640;
    public int x=0;
    public int y=0;
    //System Amel baraye shoroo kardan e barname soraghe in tabe miravad
    public void startApp()
    {
      if (mMainForm == null) {
      mMainForm = new Form("Stand in the place where you live");
      Command exitCommand = new Command("Exit", Command.EXIT, 0);
      mGoCommand = new Command("Go", Command.SCREEN, 0);
      mMainForm.addCommand(exitCommand);
      mMainForm.addCommand(mGoCommand);
      mMainForm.setCommandListener(this);
      }
      map a = new map(this);
      a.setFullScreenMode(true);
      Display.getDisplay(this).setCurrent(a);
      Display.getDisplay(this).setCurrent(mMainForm); 
    }

    //System Amel baraye Motevaghef kardane barname jahat e pasokh gooyi be ye tamas ya SMS, in method ra farakhani mikonad.
    public void pauseApp(){}
    public void providerStateChanged(LocationProvider provider, int newState) {}
   
    public void commandAction(Command c, Displayable d) {
    if (c.getCommandType() == Command.EXIT) {
      destroyApp(true);
      notifyDestroyed();
    }
    else if (c == mGoCommand) {
      Thread t = new Thread(this);
      t.start();
  
    }
  }
   
   public void run() {
    while(true)
    {
    try {
      Criteria c = new Criteria();
      LocationProvider lp = LocationProvider.getInstance(c);

      if (lp == null)  return;
      
      Location l = lp.getLocation(10);
      QualifiedCoordinates qc = l.getQualifiedCoordinates();
      double lat = qc.getLatitude();
      double lon = qc.getLongitude();
      
      LocationListener ll = this;
      lp.setLocationListener(ll, 4, 1, 1);
      convertcoordinatetoxy(lat,lon);
      
      map a = new map(this);
      a.set(x, y);
      a.setFullScreenMode(true);
      Display.getDisplay(this).setCurrent(a);
    }
    catch (LocationException le) {}
    catch (InterruptedException ie) {}
    }
  }

  // LocationListener methods.

  public void locationUpdated(LocationProvider provider, Location location) {
      
    QualifiedCoordinates qc = location.getQualifiedCoordinates();

    double lat = qc.getLatitude();
    double lon = qc.getLongitude();
    convertcoordinatetoxy(lat,lon);
    
    map a = new map(this);
    a.set(x, y);
    a.setFullScreenMode(true);
    Display.getDisplay(this).setCurrent(a);
 }
  
public void convertcoordinatetoxy(double lat,double lon)
  {
    double dx,dy;
    dx=(lat-topleftlat)/(downrightlat-topleftlat);
    dy=(lon-topleftlon)/(downrightlon-topleftlon);
    
    x=(int)(dx*mapwidth);
    y=(int)(dy*mapheight);
  }
 
    //System amel dar hengame khateme ye barname in Method ra farakhani mikonad.
    public void destroyApp(boolean b){}
    //Vazife in tabe bastan e barname ast
    public void exit()
    {
        //In khat, baes e takhrib va bastan e barname mishavad.
        notifyDestroyed();
    }
}
