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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblprompt = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblresult = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsender = null;
public static String _text = "";
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="End Sub";
return "";
}
public static String  _btnaction_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnaction_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnaction_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub btnAction_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="btnSender = Sender";
mostCurrent._btnsender = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Select btnSender.Tag";
switch (BA.switchObjectToInt(mostCurrent._btnsender.getTag(),(Object)("AC"),(Object)("BS"),(Object)("Dot"))) {
case 0: {
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="lblPrompt.Text = \"\"";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="lblResult.Text = \"\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(""));
 break; }
case 1: {
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="If lblPrompt.Text.Length > 0 Then";
if (mostCurrent._lblprompt.getText().length()>0) { 
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText().substring((int) (0),(int) (mostCurrent._lblprompt.getText().length()-1))));
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="Solve";
_solve();
 };
 break; }
case 2: {
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText()+mostCurrent._btnsender.getText()));
 break; }
default: {
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText()+mostCurrent._btnsender.getText()));
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="Solve";
_solve();
 break; }
}
;
RDebugUtils.currentLine=524306;
 //BA.debugLineNum = 524306;BA.debugLine="If lblPrompt.Text.Length < 10 Then";
if (mostCurrent._lblprompt.getText().length()<10) { 
RDebugUtils.currentLine=524307;
 //BA.debugLineNum = 524307;BA.debugLine="lblPrompt.TextSize = 50";
mostCurrent._lblprompt.setTextSize((float) (50));
 }else 
{RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="Else If lblPrompt.Text.Length < 20 Then";
if (mostCurrent._lblprompt.getText().length()<20) { 
RDebugUtils.currentLine=524309;
 //BA.debugLineNum = 524309;BA.debugLine="lblPrompt.TextSize = 40";
mostCurrent._lblprompt.setTextSize((float) (40));
 }else {
RDebugUtils.currentLine=524311;
 //BA.debugLineNum = 524311;BA.debugLine="lblPrompt.TextSize = 30";
mostCurrent._lblprompt.setTextSize((float) (30));
 }}
;
RDebugUtils.currentLine=524313;
 //BA.debugLineNum = 524313;BA.debugLine="End Sub";
return "";
}
public static String  _solve() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "solve", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "solve", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub Solve";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="text = lblPrompt.Text";
mostCurrent._text = mostCurrent._lblprompt.getText();
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Log(\"START: \" & text)";
anywheresoftware.b4a.keywords.Common.LogImpl("8393218","START: "+mostCurrent._text,0);
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="lblResult.Text = \"\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="ProcessOperators(\"÷\")";
_processoperators("÷");
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="ProcessOperators(\"x\")";
_processoperators("x");
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="ProcessOperators(\"%\")";
_processoperators("%");
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="ProcessOperators(\"+\")";
_processoperators("+");
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="ProcessOperators(\"-\")";
_processoperators("-");
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="Log(\" \")";
anywheresoftware.b4a.keywords.Common.LogImpl("8393226"," ",0);
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="Log(\"RESULT: \" & text)";
anywheresoftware.b4a.keywords.Common.LogImpl("8393227","RESULT: "+mostCurrent._text,0);
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="lblResult.Text = text";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(mostCurrent._text));
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="Log(\"---------------------------------\")";
anywheresoftware.b4a.keywords.Common.LogImpl("8393229","---------------------------------",0);
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperation_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnoperation_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnoperation_click", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub btnOperation_Click()";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="btnSender = Sender";
mostCurrent._btnsender = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Select btnSender.Tag";
switch (BA.switchObjectToInt(mostCurrent._btnsender.getTag(),(Object)("="),(Object)("x"))) {
case 0: {
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="If lblResult.Text = \"∞\" Then";
if ((mostCurrent._lblresult.getText()).equals("∞")) { 
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="lblPrompt.Text = lblResult.Text";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()));
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="lblResult.Text = \"\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(""));
 }else 
{RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="Else If lblPrompt.Text = \"\" Then";
if ((mostCurrent._lblprompt.getText()).equals("")) { 
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="Exit";
if (true) break;
 }else 
{RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="Else If Not(IsNumber(lblResult.Text)) Then";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._lblresult.getText()))) { 
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="lblResult.Text = \"Expression Error\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence("Expression Error"));
 }else {
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="lblPrompt.Text = lblResult.Text";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblresult.getText()));
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="lblResult.Text = \"\"";
mostCurrent._lblresult.setText(BA.ObjectToCharSequence(""));
 }}}
;
 break; }
case 1: {
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="lblPrompt.Text = lblPrompt.Text & \"x\"";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText()+"x"));
 break; }
default: {
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
mostCurrent._lblprompt.setText(BA.ObjectToCharSequence(mostCurrent._lblprompt.getText()+mostCurrent._btnsender.getText()));
 break; }
}
;
RDebugUtils.currentLine=458772;
 //BA.debugLineNum = 458772;BA.debugLine="If lblPrompt.Text.Length < 10 Then";
if (mostCurrent._lblprompt.getText().length()<10) { 
RDebugUtils.currentLine=458773;
 //BA.debugLineNum = 458773;BA.debugLine="lblPrompt.TextSize = 50";
mostCurrent._lblprompt.setTextSize((float) (50));
 }else 
{RDebugUtils.currentLine=458774;
 //BA.debugLineNum = 458774;BA.debugLine="Else If lblPrompt.Text.Length < 20 Then";
if (mostCurrent._lblprompt.getText().length()<20) { 
RDebugUtils.currentLine=458775;
 //BA.debugLineNum = 458775;BA.debugLine="lblPrompt.TextSize = 40";
mostCurrent._lblprompt.setTextSize((float) (40));
 }else {
RDebugUtils.currentLine=458777;
 //BA.debugLineNum = 458777;BA.debugLine="lblPrompt.TextSize = 30";
mostCurrent._lblprompt.setTextSize((float) (30));
 }}
;
RDebugUtils.currentLine=458779;
 //BA.debugLineNum = 458779;BA.debugLine="End Sub";
return "";
}
public static String  _getnumberleft(int _ind) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getnumberleft", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "getnumberleft", new Object[] {_ind}));}
int _leftctr = 0;
int _row = 0;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Private Sub GetNumberLeft(ind As Int) As String";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Dim leftCtr As Int = ind";
_leftctr = _ind;
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="For row = ind - 1 To 0 Step -1";
{
final int step2 = -1;
final int limit2 = (int) (0);
_row = (int) (_ind-1) ;
for (;_row >= limit2 ;_row = _row + step2 ) {
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="If IsNumber(text.CharAt(row)) Or text.CharAt(row";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.ObjectToString(mostCurrent._text.charAt(_row))) || mostCurrent._text.charAt(_row)==BA.ObjectToChar(".")) { 
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="leftCtr = row";
_leftctr = _row;
 }else 
{RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="Else If text.CharAt(row) = \"-\" Then";
if (mostCurrent._text.charAt(_row)==BA.ObjectToChar("-")) { 
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="leftCtr = row";
_leftctr = _row;
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="Exit";
if (true) break;
 }else {
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="Exit";
if (true) break;
 }}
;
 }
};
RDebugUtils.currentLine=262157;
 //BA.debugLineNum = 262157;BA.debugLine="If leftCtr = ind Then";
if (_leftctr==_ind) { 
RDebugUtils.currentLine=262159;
 //BA.debugLineNum = 262159;BA.debugLine="Return \"\"";
if (true) return "";
 }else {
RDebugUtils.currentLine=262161;
 //BA.debugLineNum = 262161;BA.debugLine="Return text.SubString2(leftCtr, ind)";
if (true) return mostCurrent._text.substring(_leftctr,_ind);
 };
RDebugUtils.currentLine=262163;
 //BA.debugLineNum = 262163;BA.debugLine="End Sub";
return "";
}
public static String  _getnumberright(int _ind) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getnumberright", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "getnumberright", new Object[] {_ind}));}
int _rightctr = 0;
int _row = 0;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub GetNumberRight(ind As Int) As String";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Dim rightCtr As Int = ind";
_rightctr = _ind;
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="For row = ind + 1 To text.Length - 1 Step 1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._text.length()-1);
_row = (int) (_ind+1) ;
for (;_row <= limit2 ;_row = _row + step2 ) {
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="If text.CharAt(row) = \"-\" And row = ind + 1 Then";
if (mostCurrent._text.charAt(_row)==BA.ObjectToChar("-") && _row==_ind+1) { 
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="rightCtr = row";
_rightctr = _row;
 }else 
{RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="Else If IsNumber(text.CharAt(row)) Or text.CharA";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.ObjectToString(mostCurrent._text.charAt(_row))) || mostCurrent._text.charAt(_row)==BA.ObjectToChar(".")) { 
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="rightCtr = row";
_rightctr = _row;
 }else {
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="Exit";
if (true) break;
 }}
;
 }
};
RDebugUtils.currentLine=327692;
 //BA.debugLineNum = 327692;BA.debugLine="If rightCtr = ind Then";
if (_rightctr==_ind) { 
RDebugUtils.currentLine=327694;
 //BA.debugLineNum = 327694;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=327696;
 //BA.debugLineNum = 327696;BA.debugLine="Return text.SubString2(ind + 1, rightCtr + 1)";
if (true) return mostCurrent._text.substring((int) (_ind+1),(int) (_rightctr+1));
RDebugUtils.currentLine=327697;
 //BA.debugLineNum = 327697;BA.debugLine="End Sub";
return "";
}
public static String  _processoperators(String _operator) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "processoperators", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "processoperators", new Object[] {_operator}));}
int _ind = 0;
String _strleft = "";
String _strright = "";
String _strrem = "";
float _int1 = 0f;
float _int2 = 0f;
float _res = 0f;
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Private Sub ProcessOperators(operator As String)";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Log(\" \")";
anywheresoftware.b4a.keywords.Common.LogImpl("8196609"," ",0);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Log(\"Operator : (\" & operator & \") ~~~~~\")";
anywheresoftware.b4a.keywords.Common.LogImpl("8196610","Operator : ("+_operator+") ~~~~~",0);
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="Do While text.IndexOf2(operator,1) <> -1";
while (mostCurrent._text.indexOf(_operator,(int) (1))!=-1) {
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="If operator = \"-\" Then";
if ((_operator).equals("-")) { 
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="Dim ind As Int = text.IndexOf2(operator,1)";
_ind = mostCurrent._text.indexOf(_operator,(int) (1));
 }else {
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="Dim ind As Int = text.IndexOf(operator)";
_ind = mostCurrent._text.indexOf(_operator);
 };
RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="Dim strLeft As String = GetNumberLeft(ind)";
_strleft = _getnumberleft(_ind);
RDebugUtils.currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="Dim strRight As String = GetNumberRight(ind)";
_strright = _getnumberright(_ind);
RDebugUtils.currentLine=196621;
 //BA.debugLineNum = 196621;BA.debugLine="If strLeft = \"\" Or strRight = \"\" Or strRight = \"";
if ((_strleft).equals("") || (_strright).equals("") || (_strright).equals("-")) { 
RDebugUtils.currentLine=196622;
 //BA.debugLineNum = 196622;BA.debugLine="Log(\"Invalid\")";
anywheresoftware.b4a.keywords.Common.LogImpl("8196622","Invalid",0);
RDebugUtils.currentLine=196623;
 //BA.debugLineNum = 196623;BA.debugLine="text = \"\"";
mostCurrent._text = "";
RDebugUtils.currentLine=196624;
 //BA.debugLineNum = 196624;BA.debugLine="Return ' Exit the subroutine if invalid";
if (true) return "";
 };
RDebugUtils.currentLine=196627;
 //BA.debugLineNum = 196627;BA.debugLine="Dim strRem As String = strLeft & operator & strR";
_strrem = _strleft+_operator+_strright;
RDebugUtils.currentLine=196628;
 //BA.debugLineNum = 196628;BA.debugLine="Dim int1 As Float = strLeft.As(Float)";
_int1 = ((float)(Double.parseDouble(_strleft)));
RDebugUtils.currentLine=196629;
 //BA.debugLineNum = 196629;BA.debugLine="Dim int2 As Float = strRight.As(Float)";
_int2 = ((float)(Double.parseDouble(_strright)));
RDebugUtils.currentLine=196630;
 //BA.debugLineNum = 196630;BA.debugLine="Dim res As Float";
_res = 0f;
RDebugUtils.currentLine=196632;
 //BA.debugLineNum = 196632;BA.debugLine="Select operator";
switch (BA.switchObjectToInt(_operator,"x","÷","%","+","-")) {
case 0: {
RDebugUtils.currentLine=196634;
 //BA.debugLineNum = 196634;BA.debugLine="res = int1 * int2";
_res = (float) (_int1*_int2);
 break; }
case 1: {
RDebugUtils.currentLine=196637;
 //BA.debugLineNum = 196637;BA.debugLine="res = int1 / int2";
_res = (float) (_int1/(double)_int2);
 break; }
case 2: {
RDebugUtils.currentLine=196640;
 //BA.debugLineNum = 196640;BA.debugLine="res = (int1 * int2) / 100";
_res = (float) ((_int1*_int2)/(double)100);
 break; }
case 3: {
RDebugUtils.currentLine=196642;
 //BA.debugLineNum = 196642;BA.debugLine="res = int1 + int2";
_res = (float) (_int1+_int2);
 break; }
case 4: {
RDebugUtils.currentLine=196645;
 //BA.debugLineNum = 196645;BA.debugLine="res = int1 - int2";
_res = (float) (_int1-_int2);
 break; }
}
;
RDebugUtils.currentLine=196651;
 //BA.debugLineNum = 196651;BA.debugLine="Log(\"[ \" & (text.Replace(strRem,\"(\" & strRem & \"";
anywheresoftware.b4a.keywords.Common.LogImpl("8196651","[ "+(mostCurrent._text.replace(_strrem,"("+_strrem+")")+" ]"+" = "+"[ "+mostCurrent._text.replace(_strrem,"("+anywheresoftware.b4a.keywords.Common.NumberFormat2(_res,(int) (0),(int) (13),(int) (0),anywheresoftware.b4a.keywords.Common.False)+")"))+" ]",0);
RDebugUtils.currentLine=196652;
 //BA.debugLineNum = 196652;BA.debugLine="text = text.Replace(strRem, NumberFormat2(res, 0";
mostCurrent._text = mostCurrent._text.replace(_strrem,anywheresoftware.b4a.keywords.Common.NumberFormat2(_res,(int) (0),(int) (13),(int) (0),anywheresoftware.b4a.keywords.Common.False));
 }
;
RDebugUtils.currentLine=196656;
 //BA.debugLineNum = 196656;BA.debugLine="End Sub";
return "";
}
}