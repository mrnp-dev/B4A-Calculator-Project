package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblprompt = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblresult = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsender = null;
public static String _text = "";
public b4a.example.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _btnaction_click() throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Private Sub btnAction_Click";
 //BA.debugLineNum = 169;BA.debugLine="btnSender = Sender";
mostCurrent._btnsender = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 170;BA.debugLine="Select btnSender.Tag";
switch (BA.switchObjectToInt(mostCurrent._btnsender.getTag(),(Object)("AC"),(Object)("BS"),(Object)("Dot"))) {
case 0: {
 //BA.debugLineNum = 172;BA.debugLine="lblPrompt.Text = \"\"";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 173;BA.debugLine="lblResult.Text = \"\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(""));
 break; }
case 1: {
 //BA.debugLineNum = 176;BA.debugLine="If lblPrompt.Text.Length > 0 Then";
if (mostCurrent._lblprompt.getText().length()>0) { 
 //BA.debugLineNum = 177;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText().substring((int) (0),(int) (mostCurrent._lblprompt.getText().length()-1))));
 //BA.debugLineNum = 178;BA.debugLine="Solve";
_solve();
 };
 break; }
case 2: {
 //BA.debugLineNum = 181;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText()+mostCurrent._btnsender.getText()));
 break; }
default: {
 //BA.debugLineNum = 183;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText()+mostCurrent._btnsender.getText()));
 //BA.debugLineNum = 184;BA.debugLine="Solve";
_solve();
 break; }
}
;
 //BA.debugLineNum = 186;BA.debugLine="If lblPrompt.Text.Length < 10 Then";
if (mostCurrent._lblprompt.getText().length()<10) { 
 //BA.debugLineNum = 187;BA.debugLine="lblPrompt.TextSize = 50";
mostCurrent._lblprompt.setTextSize((float) (50));
 }else if(mostCurrent._lblprompt.getText().length()<20) { 
 //BA.debugLineNum = 189;BA.debugLine="lblPrompt.TextSize = 40";
mostCurrent._lblprompt.setTextSize((float) (40));
 }else {
 //BA.debugLineNum = 191;BA.debugLine="lblPrompt.TextSize = 30";
mostCurrent._lblprompt.setTextSize((float) (30));
 };
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperation_click() throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Private Sub btnOperation_Click()";
 //BA.debugLineNum = 140;BA.debugLine="btnSender = Sender";
mostCurrent._btnsender = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 141;BA.debugLine="Select btnSender.Tag";
switch (BA.switchObjectToInt(mostCurrent._btnsender.getTag(),(Object)("="),(Object)("x"))) {
case 0: {
 //BA.debugLineNum = 143;BA.debugLine="If lblResult.Text = \"∞\" Then";
if ((mostCurrent._lblresult.getText()).equals("∞")) { 
 //BA.debugLineNum = 144;BA.debugLine="lblPrompt.Text = lblResult.Text";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()));
 //BA.debugLineNum = 145;BA.debugLine="lblResult.Text = \"\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(""));
 }else if((mostCurrent._lblprompt.getText()).equals("")) { 
 //BA.debugLineNum = 147;BA.debugLine="Exit";
if (true) break;
 }else if(anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._lblresult.getText()))) { 
 //BA.debugLineNum = 149;BA.debugLine="lblResult.Text = \"Expression Error\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence("Expression Error"));
 }else {
 //BA.debugLineNum = 151;BA.debugLine="lblPrompt.Text = lblResult.Text";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()));
 //BA.debugLineNum = 152;BA.debugLine="lblResult.Text = \"\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(""));
 };
 break; }
case 1: {
 //BA.debugLineNum = 155;BA.debugLine="lblPrompt.Text = lblPrompt.Text & \"x\"";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText()+"x"));
 break; }
default: {
 //BA.debugLineNum = 157;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText()+mostCurrent._btnsender.getText()));
 break; }
}
;
 //BA.debugLineNum = 159;BA.debugLine="If lblPrompt.Text.Length < 10 Then";
if (mostCurrent._lblprompt.getText().length()<10) { 
 //BA.debugLineNum = 160;BA.debugLine="lblPrompt.TextSize = 50";
mostCurrent._lblprompt.setTextSize((float) (50));
 }else if(mostCurrent._lblprompt.getText().length()<20) { 
 //BA.debugLineNum = 162;BA.debugLine="lblPrompt.TextSize = 40";
mostCurrent._lblprompt.setTextSize((float) (40));
 }else {
 //BA.debugLineNum = 164;BA.debugLine="lblPrompt.TextSize = 30";
mostCurrent._lblprompt.setTextSize((float) (30));
 };
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _getnumberleft(int _ind) throws Exception{
int _leftctr = 0;
int _row = 0;
 //BA.debugLineNum = 86;BA.debugLine="Private Sub GetNumberLeft(ind As Int) As String";
 //BA.debugLineNum = 87;BA.debugLine="Dim leftCtr As Int = ind";
_leftctr = _ind;
 //BA.debugLineNum = 88;BA.debugLine="For row = ind - 1 To 0 Step -1";
{
final int step2 = -1;
final int limit2 = (int) (0);
_row = (int) (_ind-1) ;
for (;_row >= limit2 ;_row = _row + step2 ) {
 //BA.debugLineNum = 89;BA.debugLine="If IsNumber(text.CharAt(row)) Or text.CharAt(row";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.ObjectToString(mostCurrent._text.charAt(_row))) || mostCurrent._text.charAt(_row)==BA.ObjectToChar(".") || mostCurrent._text.charAt(_row)==BA.ObjectToChar("-")) { 
 //BA.debugLineNum = 90;BA.debugLine="leftCtr = row";
_leftctr = _row;
 }else {
 //BA.debugLineNum = 92;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 96;BA.debugLine="If leftCtr = ind Then";
if (_leftctr==_ind) { 
 //BA.debugLineNum = 98;BA.debugLine="Return \"\"";
if (true) return "";
 }else {
 //BA.debugLineNum = 100;BA.debugLine="Return text.SubString2(leftCtr, ind)";
if (true) return mostCurrent._text.substring(_leftctr,_ind);
 };
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public static String  _getnumberright(int _ind) throws Exception{
int _rightctr = 0;
int _row = 0;
 //BA.debugLineNum = 104;BA.debugLine="Private Sub GetNumberRight(ind As Int) As String";
 //BA.debugLineNum = 105;BA.debugLine="Dim rightCtr As Int = ind";
_rightctr = _ind;
 //BA.debugLineNum = 106;BA.debugLine="For row = ind + 1 To text.Length - 1 Step 1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._text.length()-1);
_row = (int) (_ind+1) ;
for (;_row <= limit2 ;_row = _row + step2 ) {
 //BA.debugLineNum = 107;BA.debugLine="If text.CharAt(row) = \"-\" And row = ind + 1 Then";
if (mostCurrent._text.charAt(_row)==BA.ObjectToChar("-") && _row==_ind+1) { 
 //BA.debugLineNum = 108;BA.debugLine="rightCtr = row";
_rightctr = _row;
 }else if(anywheresoftware.b4a.keywords.Common.IsNumber(BA.ObjectToString(mostCurrent._text.charAt(_row))) || mostCurrent._text.charAt(_row)==BA.ObjectToChar(".")) { 
 //BA.debugLineNum = 110;BA.debugLine="rightCtr = row";
_rightctr = _row;
 }else {
 //BA.debugLineNum = 112;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 116;BA.debugLine="If rightCtr = ind Then";
if (_rightctr==_ind) { 
 //BA.debugLineNum = 118;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 120;BA.debugLine="Return text.SubString2(ind + 1, rightCtr + 1)";
if (true) return mostCurrent._text.substring((int) (_ind+1),(int) (_rightctr+1));
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private lblPrompt As Label";
mostCurrent._lblprompt = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lblResult As Label";
mostCurrent._lblresult = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private btnSender As Button";
mostCurrent._btnsender = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Dim text As String";
mostCurrent._text = "";
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _processoperators(String _operator) throws Exception{
int _ind = 0;
String _strleft = "";
String _strright = "";
String _strrem = "";
float _int1 = 0f;
float _int2 = 0f;
float _res = 0f;
 //BA.debugLineNum = 35;BA.debugLine="Private Sub ProcessOperators(operator As String)";
 //BA.debugLineNum = 36;BA.debugLine="Log(\" \")";
anywheresoftware.b4a.keywords.Common.LogImpl("7196609"," ",0);
 //BA.debugLineNum = 37;BA.debugLine="Log(\"Operator : (\" & operator & \") ~~~~~\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7196610","Operator : ("+_operator+") ~~~~~",0);
 //BA.debugLineNum = 38;BA.debugLine="Do While text.IndexOf2(operator,1) <> -1";
while (mostCurrent._text.indexOf(_operator,(int) (1))!=-1) {
 //BA.debugLineNum = 39;BA.debugLine="If operator = \"-\" Then";
if ((_operator).equals("-")) { 
 //BA.debugLineNum = 40;BA.debugLine="Dim ind As Int = text.IndexOf2(operator,1)";
_ind = mostCurrent._text.indexOf(_operator,(int) (1));
 }else {
 //BA.debugLineNum = 42;BA.debugLine="Dim ind As Int = text.IndexOf(operator)";
_ind = mostCurrent._text.indexOf(_operator);
 };
 //BA.debugLineNum = 45;BA.debugLine="Dim strLeft As String = GetNumberLeft(ind)";
_strleft = _getnumberleft(_ind);
 //BA.debugLineNum = 46;BA.debugLine="Dim strRight As String = GetNumberRight(ind)";
_strright = _getnumberright(_ind);
 //BA.debugLineNum = 48;BA.debugLine="If strLeft = \"\" Or strRight = \"\" Or strRight = \"";
if ((_strleft).equals("") || (_strright).equals("") || (_strright).equals("-")) { 
 //BA.debugLineNum = 49;BA.debugLine="Log(\"Invalid\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7196622","Invalid",0);
 //BA.debugLineNum = 50;BA.debugLine="text = \"\"";
mostCurrent._text = "";
 //BA.debugLineNum = 51;BA.debugLine="Return ' Exit the subroutine if invalid";
if (true) return "";
 };
 //BA.debugLineNum = 54;BA.debugLine="Dim strRem As String = strLeft & operator & strR";
_strrem = _strleft+_operator+_strright;
 //BA.debugLineNum = 55;BA.debugLine="Dim int1 As Float = strLeft.As(Float)";
_int1 = ((float)(Double.parseDouble(_strleft)));
 //BA.debugLineNum = 56;BA.debugLine="Dim int2 As Float = strRight.As(Float)";
_int2 = ((float)(Double.parseDouble(_strright)));
 //BA.debugLineNum = 57;BA.debugLine="Dim res As Float";
_res = 0f;
 //BA.debugLineNum = 59;BA.debugLine="Select operator";
switch (BA.switchObjectToInt(_operator,"x","÷","%","+","-")) {
case 0: {
 //BA.debugLineNum = 61;BA.debugLine="res = int1 * int2";
_res = (float) (_int1*_int2);
 break; }
case 1: {
 //BA.debugLineNum = 64;BA.debugLine="res = int1 / int2";
_res = (float) (_int1/(double)_int2);
 break; }
case 2: {
 //BA.debugLineNum = 67;BA.debugLine="res = (int1 * int2) / 100";
_res = (float) ((_int1*_int2)/(double)100);
 break; }
case 3: {
 //BA.debugLineNum = 69;BA.debugLine="res = int1 + int2";
_res = (float) (_int1+_int2);
 break; }
case 4: {
 //BA.debugLineNum = 72;BA.debugLine="res = int1 - int2";
_res = (float) (_int1-_int2);
 break; }
}
;
 //BA.debugLineNum = 78;BA.debugLine="Log(\"[ \" & (text.Replace(strRem,\"(\" & strRem & \"";
anywheresoftware.b4a.keywords.Common.LogImpl("7196651","[ "+(mostCurrent._text.replace(_strrem,"("+_strrem+")")+" ]"+" = "+"[ "+mostCurrent._text.replace(_strrem,"("+anywheresoftware.b4a.keywords.Common.NumberFormat2(_res,(int) (0),(int) (13),(int) (0),anywheresoftware.b4a.keywords.Common.False)+")"))+" ]",0);
 //BA.debugLineNum = 79;BA.debugLine="text = text.Replace(strRem, NumberFormat2(res, 0";
mostCurrent._text = mostCurrent._text.replace(_strrem,anywheresoftware.b4a.keywords.Common.NumberFormat2(_res,(int) (0),(int) (13),(int) (0),anywheresoftware.b4a.keywords.Common.False));
 }
;
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public static String  _solve() throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="Private Sub Solve";
 //BA.debugLineNum = 124;BA.debugLine="text = lblPrompt.Text";
mostCurrent._text = mostCurrent._lblprompt.getText();
 //BA.debugLineNum = 125;BA.debugLine="Log(\"START: \" & text)";
anywheresoftware.b4a.keywords.Common.LogImpl("7393218","START: "+mostCurrent._text,0);
 //BA.debugLineNum = 127;BA.debugLine="lblResult.Text = \"\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 128;BA.debugLine="ProcessOperators(\"÷\")";
_processoperators("÷");
 //BA.debugLineNum = 129;BA.debugLine="ProcessOperators(\"x\")";
_processoperators("x");
 //BA.debugLineNum = 130;BA.debugLine="ProcessOperators(\"%\")";
_processoperators("%");
 //BA.debugLineNum = 131;BA.debugLine="ProcessOperators(\"-\")";
_processoperators("-");
 //BA.debugLineNum = 132;BA.debugLine="ProcessOperators(\"+\")";
_processoperators("+");
 //BA.debugLineNum = 133;BA.debugLine="Log(\" \")";
anywheresoftware.b4a.keywords.Common.LogImpl("7393226"," ",0);
 //BA.debugLineNum = 134;BA.debugLine="Log(\"RESULT: \" & text)";
anywheresoftware.b4a.keywords.Common.LogImpl("7393227","RESULT: "+mostCurrent._text,0);
 //BA.debugLineNum = 135;BA.debugLine="lblResult.Text = text";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._text));
 //BA.debugLineNum = 136;BA.debugLine="Log(\"---------------------------------\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7393229","---------------------------------",0);
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
}
