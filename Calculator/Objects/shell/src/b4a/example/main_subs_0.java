package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,33);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(2);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="edtPrompt.Enabled = False";
Debug.ShouldStop(4);
main.mostCurrent._edtprompt.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 36;BA.debugLine="promptTxtColor = lblPrompt.TextColor";
Debug.ShouldStop(8);
main._prompttxtcolor = main.mostCurrent._lblprompt.runMethod(true,"getTextColor");
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnaction_click() throws Exception{
try {
		Debug.PushSubsStack("btnAction_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,270);
if (RapidSub.canDelegate("btnaction_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnaction_click");}
 BA.debugLineNum = 270;BA.debugLine="Private Sub btnAction_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 271;BA.debugLine="btnSender = Sender";
Debug.ShouldStop(16384);
main.mostCurrent._btnsender = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 273;BA.debugLine="Select btnSender.Tag";
Debug.ShouldStop(65536);
switch (BA.switchObjectToInt(main.mostCurrent._btnsender.runMethod(false,"getTag"),RemoteObject.createImmutable(("AC")),RemoteObject.createImmutable(("BS")),RemoteObject.createImmutable(("Dot")),RemoteObject.createImmutable(("logs")))) {
case 0: {
 BA.debugLineNum = 275;BA.debugLine="lblPrompt.Text = \"\"";
Debug.ShouldStop(262144);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 276;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(524288);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 277;BA.debugLine="lblLog.Text = \"\"";
Debug.ShouldStop(1048576);
main.mostCurrent._lbllog.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 break; }
case 1: {
 BA.debugLineNum = 279;BA.debugLine="If lblPrompt.Text.Length > 0 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(">",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 280;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(8388608);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 BA.debugLineNum = 281;BA.debugLine="Solve";
Debug.ShouldStop(16777216);
_solve();
 };
 break; }
case 2: {
 BA.debugLineNum = 284;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
Debug.ShouldStop(134217728);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 break; }
case 3: {
 BA.debugLineNum = 286;BA.debugLine="If Not(lblLog.Visible) Then";
Debug.ShouldStop(536870912);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main.mostCurrent._lbllog.runMethod(true,"getVisible"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 287;BA.debugLine="lblLog.Visible = True";
Debug.ShouldStop(1073741824);
main.mostCurrent._lbllog.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 289;BA.debugLine="lblLog.Visible = False";
Debug.ShouldStop(1);
main.mostCurrent._lbllog.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 break; }
default: {
 BA.debugLineNum = 292;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
Debug.ShouldStop(8);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 BA.debugLineNum = 293;BA.debugLine="Solve";
Debug.ShouldStop(16);
_solve();
 break; }
}
;
 BA.debugLineNum = 295;BA.debugLine="If lblPrompt.TextColor <> promptTxtColor Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("!",main.mostCurrent._lblprompt.runMethod(true,"getTextColor"),BA.numberCast(double.class, main._prompttxtcolor))) { 
 BA.debugLineNum = 296;BA.debugLine="lblPrompt.SetTextColorAnimated(400,promptTxtColo";
Debug.ShouldStop(128);
main.mostCurrent._lblprompt.runVoidMethod ("SetTextColorAnimated",(Object)(BA.numberCast(int.class, 400)),(Object)(main._prompttxtcolor));
 };
 BA.debugLineNum = 298;BA.debugLine="If lblPrompt.Text.Length < 10 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("<",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 10))) { 
 BA.debugLineNum = 299;BA.debugLine="lblPrompt.TextSize = 50";
Debug.ShouldStop(1024);
main.mostCurrent._lblprompt.runMethod(true,"setTextSize",BA.numberCast(float.class, 50));
 }else 
{ BA.debugLineNum = 300;BA.debugLine="Else If lblPrompt.Text.Length < 20 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("<",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 301;BA.debugLine="lblPrompt.TextSize = 40";
Debug.ShouldStop(4096);
main.mostCurrent._lblprompt.runMethod(true,"setTextSize",BA.numberCast(float.class, 40));
 }else {
 BA.debugLineNum = 303;BA.debugLine="lblPrompt.TextSize = 30";
Debug.ShouldStop(16384);
main.mostCurrent._lblprompt.runMethod(true,"setTextSize",BA.numberCast(float.class, 30));
 }}
;
 BA.debugLineNum = 305;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnoperation_click() throws Exception{
try {
		Debug.PushSubsStack("btnOperation_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,160);
if (RapidSub.canDelegate("btnoperation_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnoperation_click");}
RemoteObject _prev = RemoteObject.createImmutable('\0');
RemoteObject _prev2 = RemoteObject.createImmutable('\0');
 BA.debugLineNum = 160;BA.debugLine="Private Sub btnOperation_Click()";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="btnSender = Sender";
Debug.ShouldStop(1);
main.mostCurrent._btnsender = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 162;BA.debugLine="Dim prev As Char";
Debug.ShouldStop(2);
_prev = RemoteObject.createImmutable('\0');Debug.locals.put("prev", _prev);
 BA.debugLineNum = 163;BA.debugLine="If lblPrompt.Text.Length > 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean(">",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 164;BA.debugLine="prev = lblPrompt.Text.CharAt(lblPrompt.Text.Leng";
Debug.ShouldStop(8);
_prev = main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"charAt",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)));Debug.locals.put("prev", _prev);
 }else {
 BA.debugLineNum = 167;BA.debugLine="prev = \"`\"";
Debug.ShouldStop(64);
_prev = BA.ObjectToChar("`");Debug.locals.put("prev", _prev);
 };
 BA.debugLineNum = 170;BA.debugLine="If prev = \"-\" And lblPrompt.Text.Length = 1 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_prev,BA.ObjectToChar("-")) && RemoteObject.solveBoolean("=",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 171;BA.debugLine="Return";
Debug.ShouldStop(1024);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 174;BA.debugLine="Select btnSender.Tag";
Debug.ShouldStop(8192);
switch (BA.switchObjectToInt(main.mostCurrent._btnsender.runMethod(false,"getTag"),RemoteObject.createImmutable(("=")),RemoteObject.createImmutable(("-")),RemoteObject.createImmutable(("+")))) {
case 0: {
 BA.debugLineNum = 176;BA.debugLine="If lblResult.Text = \"∞\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",main.mostCurrent._lblresult.runMethod(true,"getText"),BA.ObjectToString("∞"))) { 
 BA.debugLineNum = 177;BA.debugLine="lblResult.SetTextSizeAnimated(200,40)";
Debug.ShouldStop(65536);
main.mostCurrent._lblresult.runVoidMethod ("SetTextSizeAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(float.class, 40)));
 BA.debugLineNum = 179;BA.debugLine="Exit";
Debug.ShouldStop(262144);
if (true) break;
 }else 
{ BA.debugLineNum = 180;BA.debugLine="Else If lblPrompt.Text = \"\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",main.mostCurrent._lblprompt.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 181;BA.debugLine="Exit";
Debug.ShouldStop(1048576);
if (true) break;
 }else 
{ BA.debugLineNum = 182;BA.debugLine="Else If lblResult.Text = \"Cannot divide by 0\" T";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main.mostCurrent._lblresult.runMethod(true,"getText"),BA.ObjectToString("Cannot divide by 0"))) { 
 BA.debugLineNum = 183;BA.debugLine="Exit";
Debug.ShouldStop(4194304);
if (true) break;
 }else 
{ BA.debugLineNum = 184;BA.debugLine="Else If Not(IsNumber(lblResult.Text)) Then";
Debug.ShouldStop(8388608);
if (main.mostCurrent.__c.runMethod(true,"Not",(Object)(main.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(main.mostCurrent._lblresult.runMethod(true,"getText"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 185;BA.debugLine="lblResult.Text = \"Expression Error\"";
Debug.ShouldStop(16777216);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence("Expression Error"));
 }else {
 BA.debugLineNum = 187;BA.debugLine="lblPopAnimation(lblPrompt, 400,Colors.Yellow)";
Debug.ShouldStop(67108864);
_lblpopanimation(main.mostCurrent._lblprompt,BA.numberCast(int.class, 400),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow"));
 BA.debugLineNum = 188;BA.debugLine="lblPrompt.Text = lblResult.Text";
Debug.ShouldStop(134217728);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblresult.runMethod(true,"getText")));
 BA.debugLineNum = 189;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(268435456);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 }}}}
;
 break; }
case 1: {
 BA.debugLineNum = 192;BA.debugLine="Select prev";
Debug.ShouldStop(-2147483648);
switch (BA.switchObjectToInt(_prev,BA.ObjectToChar("-"),BA.ObjectToChar("+"))) {
case 0: {
 BA.debugLineNum = 194;BA.debugLine="If lblPrompt.Text.Length > 1 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean(">",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 195;BA.debugLine="Dim prev2 As Char = lblPrompt.Text.CharAt(lb";
Debug.ShouldStop(4);
_prev2 = main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"charAt",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(2)}, "-",1, 1)));Debug.locals.put("prev2", _prev2);Debug.locals.put("prev2", _prev2);
 }else {
 BA.debugLineNum = 197;BA.debugLine="Exit";
Debug.ShouldStop(16);
if (true) break;
 };
 BA.debugLineNum = 200;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(128);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 BA.debugLineNum = 201;BA.debugLine="lblPrompt.Text = lblPrompt.Text & \"+\"";
Debug.ShouldStop(256);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),RemoteObject.createImmutable("+"))));
 BA.debugLineNum = 202;BA.debugLine="If prev2 = \"+\" Or prev2 = \"x\" Or prev2 = \"%\"";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_prev2,BA.ObjectToChar("+")) || RemoteObject.solveBoolean("=",_prev2,BA.ObjectToChar("x")) || RemoteObject.solveBoolean("=",_prev2,BA.ObjectToChar("%")) || RemoteObject.solveBoolean("=",_prev2,BA.ObjectToChar("÷"))) { 
 BA.debugLineNum = 203;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0";
Debug.ShouldStop(1024);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(2)}, "-",1, 1)))));
 BA.debugLineNum = 204;BA.debugLine="lblPrompt.Text = lblPrompt.Text & \"+\"";
Debug.ShouldStop(2048);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),RemoteObject.createImmutable("+"))));
 };
 break; }
case 1: {
 BA.debugLineNum = 208;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(32768);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 BA.debugLineNum = 209;BA.debugLine="lblPrompt.Text = lblPrompt.Text & \"-\"";
Debug.ShouldStop(65536);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),RemoteObject.createImmutable("-"))));
 break; }
default: {
 BA.debugLineNum = 212;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.T";
Debug.ShouldStop(524288);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 BA.debugLineNum = 213;BA.debugLine="If lblPrompt.TextColor <> promptTxtColor Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("!",main.mostCurrent._lblprompt.runMethod(true,"getTextColor"),BA.numberCast(double.class, main._prompttxtcolor))) { 
 BA.debugLineNum = 214;BA.debugLine="lblPrompt.SetTextColorAnimated(400,promptTxtCo";
Debug.ShouldStop(2097152);
main.mostCurrent._lblprompt.runVoidMethod ("SetTextColorAnimated",(Object)(BA.numberCast(int.class, 400)),(Object)(main._prompttxtcolor));
 };
 break; }
}
;
 BA.debugLineNum = 217;BA.debugLine="Solve";
Debug.ShouldStop(16777216);
_solve();
 break; }
case 2: {
 BA.debugLineNum = 220;BA.debugLine="Select prev";
Debug.ShouldStop(134217728);
switch (BA.switchObjectToInt(_prev,BA.ObjectToChar("`"),BA.ObjectToChar("-"),BA.ObjectToChar("+"),BA.ObjectToChar("x"),BA.ObjectToChar("÷"),BA.ObjectToChar("%"))) {
case 0: {
 BA.debugLineNum = 222;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 break; }
case 1: {
 BA.debugLineNum = 224;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 BA.debugLineNum = 225;BA.debugLine="lblPrompt.Text = lblPrompt.Text & \"+\"";
Debug.ShouldStop(1);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),RemoteObject.createImmutable("+"))));
 break; }
case 2: {
 BA.debugLineNum = 227;BA.debugLine="Exit";
Debug.ShouldStop(4);
if (true) break;
 break; }
case 3: 
case 4: 
case 5: {
 BA.debugLineNum = 229;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(16);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 BA.debugLineNum = 230;BA.debugLine="lblPrompt.Text = lblPrompt.Text & \"+\"";
Debug.ShouldStop(32);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),RemoteObject.createImmutable("+"))));
 break; }
default: {
 BA.debugLineNum = 232;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.T";
Debug.ShouldStop(128);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 BA.debugLineNum = 233;BA.debugLine="If lblPrompt.TextColor <> promptTxtColor Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("!",main.mostCurrent._lblprompt.runMethod(true,"getTextColor"),BA.numberCast(double.class, main._prompttxtcolor))) { 
 BA.debugLineNum = 234;BA.debugLine="lblPrompt.SetTextColorAnimated(400,promptTxtCo";
Debug.ShouldStop(512);
main.mostCurrent._lblprompt.runVoidMethod ("SetTextColorAnimated",(Object)(BA.numberCast(int.class, 400)),(Object)(main._prompttxtcolor));
 };
 break; }
}
;
 BA.debugLineNum = 237;BA.debugLine="Solve";
Debug.ShouldStop(4096);
_solve();
 break; }
default: {
 BA.debugLineNum = 239;BA.debugLine="Select prev";
Debug.ShouldStop(16384);
switch (BA.switchObjectToInt(_prev,BA.ObjectToChar("`"),BA.ObjectToChar("-"),BA.ObjectToChar("+"),BA.ObjectToChar("x"),BA.ObjectToChar("%"),BA.ObjectToChar("÷"))) {
case 0: {
 BA.debugLineNum = 241;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return RemoteObject.createImmutable("");
 break; }
case 1: {
 BA.debugLineNum = 243;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(262144);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 break; }
case 2: {
 BA.debugLineNum = 245;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(1048576);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 break; }
case 3: {
 BA.debugLineNum = 247;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(4194304);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 break; }
case 4: {
 BA.debugLineNum = 249;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(16777216);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 break; }
case 5: {
 BA.debugLineNum = 251;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(67108864);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 break; }
}
;
 BA.debugLineNum = 254;BA.debugLine="If lblPrompt.TextColor <> promptTxtColor Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("!",main.mostCurrent._lblprompt.runMethod(true,"getTextColor"),BA.numberCast(double.class, main._prompttxtcolor))) { 
 BA.debugLineNum = 255;BA.debugLine="lblPrompt.SetTextColorAnimated(400,promptTxtCo";
Debug.ShouldStop(1073741824);
main.mostCurrent._lblprompt.runVoidMethod ("SetTextColorAnimated",(Object)(BA.numberCast(int.class, 400)),(Object)(main._prompttxtcolor));
 };
 BA.debugLineNum = 257;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
Debug.ShouldStop(1);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 BA.debugLineNum = 258;BA.debugLine="Solve";
Debug.ShouldStop(2);
_solve();
 break; }
}
;
 BA.debugLineNum = 261;BA.debugLine="If lblPrompt.Text.Length < 10 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("<",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 10))) { 
 BA.debugLineNum = 262;BA.debugLine="lblPrompt.TextSize = 50";
Debug.ShouldStop(32);
main.mostCurrent._lblprompt.runMethod(true,"setTextSize",BA.numberCast(float.class, 50));
 }else 
{ BA.debugLineNum = 263;BA.debugLine="Else If lblPrompt.Text.Length < 20 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("<",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 264;BA.debugLine="lblPrompt.TextSize = 40";
Debug.ShouldStop(128);
main.mostCurrent._lblprompt.runMethod(true,"setTextSize",BA.numberCast(float.class, 40));
 }else {
 BA.debugLineNum = 266;BA.debugLine="lblPrompt.TextSize = 30";
Debug.ShouldStop(512);
main.mostCurrent._lblprompt.runMethod(true,"setTextSize",BA.numberCast(float.class, 30));
 }}
;
 BA.debugLineNum = 268;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getnumberleft(RemoteObject _ind) throws Exception{
try {
		Debug.PushSubsStack("GetNumberLeft (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,101);
if (RapidSub.canDelegate("getnumberleft")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getnumberleft", _ind);}
RemoteObject _leftctr = RemoteObject.createImmutable(0);
int _row = 0;
Debug.locals.put("ind", _ind);
 BA.debugLineNum = 101;BA.debugLine="Private Sub GetNumberLeft(ind As Int) As String";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="Dim leftCtr As Int = ind";
Debug.ShouldStop(32);
_leftctr = _ind;Debug.locals.put("leftCtr", _leftctr);Debug.locals.put("leftCtr", _leftctr);
 BA.debugLineNum = 103;BA.debugLine="For row = ind - 1 To 0 Step -1";
Debug.ShouldStop(64);
{
final int step2 = -1;
final int limit2 = 0;
_row = RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step2 > 0 && _row <= limit2) || (step2 < 0 && _row >= limit2) ;_row = ((int)(0 + _row + step2))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 104;BA.debugLine="If IsNumber(text.CharAt(row)) Or text.CharAt(row";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.ObjectToString(main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))))))) || RemoteObject.solveBoolean("=",main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))),BA.ObjectToChar("."))) { 
 BA.debugLineNum = 105;BA.debugLine="leftCtr = row";
Debug.ShouldStop(256);
_leftctr = BA.numberCast(int.class, _row);Debug.locals.put("leftCtr", _leftctr);
 }else 
{ BA.debugLineNum = 106;BA.debugLine="Else If text.CharAt(row) = \"-\" And row = 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))),BA.ObjectToChar("-")) && RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_row),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 107;BA.debugLine="leftCtr = row";
Debug.ShouldStop(1024);
_leftctr = BA.numberCast(int.class, _row);Debug.locals.put("leftCtr", _leftctr);
 BA.debugLineNum = 108;BA.debugLine="Exit";
Debug.ShouldStop(2048);
if (true) break;
 }else {
 BA.debugLineNum = 110;BA.debugLine="Exit";
Debug.ShouldStop(8192);
if (true) break;
 }}
;
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 114;BA.debugLine="If leftCtr = ind Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_leftctr,BA.numberCast(double.class, _ind))) { 
 BA.debugLineNum = 116;BA.debugLine="Return \"\"";
Debug.ShouldStop(524288);
if (true) return BA.ObjectToString("");
 }else {
 BA.debugLineNum = 118;BA.debugLine="Return text.SubString2(leftCtr, ind)";
Debug.ShouldStop(2097152);
if (true) return main.mostCurrent._text.runMethod(true,"substring",(Object)(_leftctr),(Object)(_ind));
 };
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getnumberright(RemoteObject _ind) throws Exception{
try {
		Debug.PushSubsStack("GetNumberRight (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,122);
if (RapidSub.canDelegate("getnumberright")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getnumberright", _ind);}
RemoteObject _rightctr = RemoteObject.createImmutable(0);
int _row = 0;
Debug.locals.put("ind", _ind);
 BA.debugLineNum = 122;BA.debugLine="Private Sub GetNumberRight(ind As Int) As String";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="Dim rightCtr As Int = ind";
Debug.ShouldStop(67108864);
_rightctr = _ind;Debug.locals.put("rightCtr", _rightctr);Debug.locals.put("rightCtr", _rightctr);
 BA.debugLineNum = 124;BA.debugLine="For row = ind + 1 To text.Length - 1 Step 1";
Debug.ShouldStop(134217728);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._text.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "+",1, 1).<Integer>get().intValue() ;
for (;(step2 > 0 && _row <= limit2) || (step2 < 0 && _row >= limit2) ;_row = ((int)(0 + _row + step2))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 125;BA.debugLine="If text.CharAt(row) = \"-\" And row = ind + 1 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))),BA.ObjectToChar("-")) && RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_row),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "+",1, 1)))) { 
 BA.debugLineNum = 126;BA.debugLine="rightCtr = row";
Debug.ShouldStop(536870912);
_rightctr = BA.numberCast(int.class, _row);Debug.locals.put("rightCtr", _rightctr);
 }else 
{ BA.debugLineNum = 127;BA.debugLine="Else If IsNumber(text.CharAt(row)) Or text.CharA";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.ObjectToString(main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))))))) || RemoteObject.solveBoolean("=",main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))),BA.ObjectToChar("."))) { 
 BA.debugLineNum = 128;BA.debugLine="rightCtr = row";
Debug.ShouldStop(-2147483648);
_rightctr = BA.numberCast(int.class, _row);Debug.locals.put("rightCtr", _rightctr);
 }else {
 BA.debugLineNum = 130;BA.debugLine="Exit";
Debug.ShouldStop(2);
if (true) break;
 }}
;
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 134;BA.debugLine="If rightCtr = ind Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_rightctr,BA.numberCast(double.class, _ind))) { 
 BA.debugLineNum = 136;BA.debugLine="Return \"\"";
Debug.ShouldStop(128);
if (true) return BA.ObjectToString("");
 };
 BA.debugLineNum = 138;BA.debugLine="Return text.SubString2(ind + 1, rightCtr + 1)";
Debug.ShouldStop(512);
if (true) return main.mostCurrent._text.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_rightctr,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private lblPrompt As Label";
main.mostCurrent._lblprompt = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lblResult As Label";
main.mostCurrent._lblresult = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private btnSender As Button";
main.mostCurrent._btnsender = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private lblLog As Label";
main.mostCurrent._lbllog = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private edtPrompt As EditText";
main.mostCurrent._edtprompt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim text As String";
main.mostCurrent._text = RemoteObject.createImmutable("");
 //BA.debugLineNum = 30;BA.debugLine="Dim promptTxtColor As Int";
main._prompttxtcolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblpopanimation(RemoteObject _label,RemoteObject _time,RemoteObject _color) throws Exception{
try {
		Debug.PushSubsStack("lblPopAnimation (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,307);
if (RapidSub.canDelegate("lblpopanimation")) { return b4a.example.main.remoteMe.runUserSub(false, "main","lblpopanimation", _label, _time, _color);}
RemoteObject _origsize = RemoteObject.createImmutable(0f);
Debug.locals.put("label", _label);
Debug.locals.put("time", _time);
Debug.locals.put("color", _color);
 BA.debugLineNum = 307;BA.debugLine="Private Sub lblPopAnimation(label As Label, time A";
Debug.ShouldStop(262144);
 BA.debugLineNum = 308;BA.debugLine="Log(label.TextSize)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4589825",BA.NumberToString(_label.runMethod(true,"getTextSize")),0);
 BA.debugLineNum = 309;BA.debugLine="Dim origSize As Float = label.TextSize";
Debug.ShouldStop(1048576);
_origsize = _label.runMethod(true,"getTextSize");Debug.locals.put("origSize", _origsize);Debug.locals.put("origSize", _origsize);
 BA.debugLineNum = 310;BA.debugLine="label.TextSize = 10";
Debug.ShouldStop(2097152);
_label.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 312;BA.debugLine="label.SetTextColorAnimated(time,color)";
Debug.ShouldStop(8388608);
_label.runVoidMethod ("SetTextColorAnimated",(Object)(_time),(Object)(_color));
 BA.debugLineNum = 313;BA.debugLine="label.SetTextSizeAnimated(time,origSize)";
Debug.ShouldStop(16777216);
_label.runVoidMethod ("SetTextSizeAnimated",(Object)(_time),(Object)(_origsize));
 BA.debugLineNum = 314;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _processoperators(RemoteObject _operator) throws Exception{
try {
		Debug.PushSubsStack("ProcessOperators (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,40);
if (RapidSub.canDelegate("processoperators")) { return b4a.example.main.remoteMe.runUserSub(false, "main","processoperators", _operator);}
RemoteObject _ind = RemoteObject.createImmutable(0);
RemoteObject _strleft = RemoteObject.createImmutable("");
RemoteObject _strright = RemoteObject.createImmutable("");
RemoteObject _strrem = RemoteObject.createImmutable("");
RemoteObject _int1 = RemoteObject.createImmutable(0f);
RemoteObject _int2 = RemoteObject.createImmutable(0f);
RemoteObject _res = RemoteObject.createImmutable(0f);
Debug.locals.put("operator", _operator);
 BA.debugLineNum = 40;BA.debugLine="Private Sub ProcessOperators(operator As String)";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="If text.IndexOf2(operator,1) <> -1 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("!",main.mostCurrent._text.runMethod(true,"indexOf",(Object)(_operator),(Object)(BA.numberCast(int.class, 1))),BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 42;BA.debugLine="Log(\" \")";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4196610",RemoteObject.createImmutable(" "),0);
 BA.debugLineNum = 44;BA.debugLine="Log(\"Operator : (\" & operator & \") ~~~~~\")";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4196612",RemoteObject.concat(RemoteObject.createImmutable("Operator : ("),_operator,RemoteObject.createImmutable(") ~~~~~")),0);
 };
 BA.debugLineNum = 47;BA.debugLine="Do While text.IndexOf2(operator,1) <> -1";
Debug.ShouldStop(16384);
while (RemoteObject.solveBoolean("!",main.mostCurrent._text.runMethod(true,"indexOf",(Object)(_operator),(Object)(BA.numberCast(int.class, 1))),BA.numberCast(double.class, -(double) (0 + 1)))) {
 BA.debugLineNum = 48;BA.debugLine="If operator = \"-\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_operator,BA.ObjectToString("-"))) { 
 BA.debugLineNum = 49;BA.debugLine="Dim ind As Int = text.IndexOf2(operator,1)";
Debug.ShouldStop(65536);
_ind = main.mostCurrent._text.runMethod(true,"indexOf",(Object)(_operator),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("ind", _ind);Debug.locals.put("ind", _ind);
 }else {
 BA.debugLineNum = 51;BA.debugLine="Dim ind As Int = text.IndexOf(operator)";
Debug.ShouldStop(262144);
_ind = main.mostCurrent._text.runMethod(true,"indexOf",(Object)(_operator));Debug.locals.put("ind", _ind);Debug.locals.put("ind", _ind);
 };
 BA.debugLineNum = 54;BA.debugLine="Dim strLeft As String = GetNumberLeft(ind)";
Debug.ShouldStop(2097152);
_strleft = _getnumberleft(_ind);Debug.locals.put("strLeft", _strleft);Debug.locals.put("strLeft", _strleft);
 BA.debugLineNum = 55;BA.debugLine="Dim strRight As String = GetNumberRight(ind)";
Debug.ShouldStop(4194304);
_strright = _getnumberright(_ind);Debug.locals.put("strRight", _strright);Debug.locals.put("strRight", _strright);
 BA.debugLineNum = 57;BA.debugLine="If strLeft = \"\" Or strRight = \"\" Or strRight = \"";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_strleft,BA.ObjectToString("")) || RemoteObject.solveBoolean("=",_strright,BA.ObjectToString("")) || RemoteObject.solveBoolean("=",_strright,BA.ObjectToString("-"))) { 
 BA.debugLineNum = 58;BA.debugLine="Log(\"Invalid\")";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4196626",RemoteObject.createImmutable("Invalid"),0);
 BA.debugLineNum = 59;BA.debugLine="text = \"\"";
Debug.ShouldStop(67108864);
main.mostCurrent._text = BA.ObjectToString("");
 BA.debugLineNum = 60;BA.debugLine="Return ' Exit the subroutine if invalid";
Debug.ShouldStop(134217728);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 64;BA.debugLine="Dim strRem As String = strLeft & operator & strR";
Debug.ShouldStop(-2147483648);
_strrem = RemoteObject.concat(_strleft,_operator,_strright);Debug.locals.put("strRem", _strrem);Debug.locals.put("strRem", _strrem);
 BA.debugLineNum = 65;BA.debugLine="Dim int1 As Float = strLeft.As(Float)";
Debug.ShouldStop(1);
_int1 = (BA.numberCast(float.class, _strleft));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 66;BA.debugLine="Dim int2 As Float = strRight.As(Float)";
Debug.ShouldStop(2);
_int2 = (BA.numberCast(float.class, _strright));Debug.locals.put("int2", _int2);Debug.locals.put("int2", _int2);
 BA.debugLineNum = 67;BA.debugLine="Dim res As Float";
Debug.ShouldStop(4);
_res = RemoteObject.createImmutable(0f);Debug.locals.put("res", _res);
 BA.debugLineNum = 69;BA.debugLine="If operator = \"÷\" And int2 = 0 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_operator,BA.ObjectToString("÷")) && RemoteObject.solveBoolean("=",_int2,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 70;BA.debugLine="text = \"Cannot divide by 0\"";
Debug.ShouldStop(32);
main.mostCurrent._text = BA.ObjectToString("Cannot divide by 0");
 BA.debugLineNum = 71;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 74;BA.debugLine="Select operator";
Debug.ShouldStop(512);
switch (BA.switchObjectToInt(_operator,BA.ObjectToString("x"),BA.ObjectToString("÷"),BA.ObjectToString("%"),BA.ObjectToString("+"),BA.ObjectToString("-"))) {
case 0: {
 BA.debugLineNum = 76;BA.debugLine="res = int1 * int2";
Debug.ShouldStop(2048);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "*",0, 0));Debug.locals.put("res", _res);
 break; }
case 1: {
 BA.debugLineNum = 79;BA.debugLine="res = int1 / int2";
Debug.ShouldStop(16384);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "/",0, 0));Debug.locals.put("res", _res);
 break; }
case 2: {
 BA.debugLineNum = 82;BA.debugLine="res = (int1 * int2) / 100";
Debug.ShouldStop(131072);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "*",0, 0)),RemoteObject.createImmutable(100)}, "/",0, 0));Debug.locals.put("res", _res);
 break; }
case 3: {
 BA.debugLineNum = 84;BA.debugLine="res = int1 + int2";
Debug.ShouldStop(524288);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "+",1, 0));Debug.locals.put("res", _res);
 break; }
case 4: {
 BA.debugLineNum = 87;BA.debugLine="res = int1 - int2";
Debug.ShouldStop(4194304);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "-",1, 0));Debug.locals.put("res", _res);
 break; }
}
;
 BA.debugLineNum = 93;BA.debugLine="lblLog.Text = lblLog.Text & CRLF & \"[ \" & (text.";
Debug.ShouldStop(268435456);
main.mostCurrent._lbllog.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lbllog.runMethod(true,"getText"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("[ "),(RemoteObject.concat(main.mostCurrent._text.runMethod(true,"replace",(Object)(_strrem),(Object)(RemoteObject.concat(RemoteObject.createImmutable("("),_strrem,RemoteObject.createImmutable(")")))),RemoteObject.createImmutable(" ]"),RemoteObject.createImmutable(" = "),RemoteObject.createImmutable("[ "),main.mostCurrent._text.runMethod(true,"replace",(Object)(_strrem),(Object)(RemoteObject.concat(RemoteObject.createImmutable("("),main.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, _res)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 13)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.getField(true,"False"))),RemoteObject.createImmutable(")")))))),RemoteObject.createImmutable(" ]"))));
 BA.debugLineNum = 94;BA.debugLine="Log(\"[ \" & (text.Replace(strRem,\"(\" & strRem & \"";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4196662",RemoteObject.concat(RemoteObject.createImmutable("[ "),(RemoteObject.concat(main.mostCurrent._text.runMethod(true,"replace",(Object)(_strrem),(Object)(RemoteObject.concat(RemoteObject.createImmutable("("),_strrem,RemoteObject.createImmutable(")")))),RemoteObject.createImmutable(" ]"),RemoteObject.createImmutable(" = "),RemoteObject.createImmutable("[ "),main.mostCurrent._text.runMethod(true,"replace",(Object)(_strrem),(Object)(RemoteObject.concat(RemoteObject.createImmutable("("),main.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, _res)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 13)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.getField(true,"False"))),RemoteObject.createImmutable(")")))))),RemoteObject.createImmutable(" ]")),0);
 BA.debugLineNum = 95;BA.debugLine="text = text.Replace(strRem, NumberFormat2(res, 0";
Debug.ShouldStop(1073741824);
main.mostCurrent._text = main.mostCurrent._text.runMethod(true,"replace",(Object)(_strrem),(Object)(main.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, _res)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 13)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.getField(true,"False")))));
 }
;
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _solve() throws Exception{
try {
		Debug.PushSubsStack("Solve (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,141);
if (RapidSub.canDelegate("solve")) { return b4a.example.main.remoteMe.runUserSub(false, "main","solve");}
 BA.debugLineNum = 141;BA.debugLine="Private Sub Solve";
Debug.ShouldStop(4096);
 BA.debugLineNum = 142;BA.debugLine="text = lblPrompt.Text";
Debug.ShouldStop(8192);
main.mostCurrent._text = main.mostCurrent._lblprompt.runMethod(true,"getText");
 BA.debugLineNum = 143;BA.debugLine="Log(\"START: \" & text)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4393218",RemoteObject.concat(RemoteObject.createImmutable("START: "),main.mostCurrent._text),0);
 BA.debugLineNum = 144;BA.debugLine="lblLog.Text = \"\"";
Debug.ShouldStop(32768);
main.mostCurrent._lbllog.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 145;BA.debugLine="lblLog.Text = \"START: \" & text & CRLF";
Debug.ShouldStop(65536);
main.mostCurrent._lbllog.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("START: "),main.mostCurrent._text,main.mostCurrent.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 147;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(262144);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 148;BA.debugLine="ProcessOperators(\"÷\")";
Debug.ShouldStop(524288);
_processoperators(RemoteObject.createImmutable("÷"));
 BA.debugLineNum = 149;BA.debugLine="ProcessOperators(\"x\")";
Debug.ShouldStop(1048576);
_processoperators(RemoteObject.createImmutable("x"));
 BA.debugLineNum = 150;BA.debugLine="ProcessOperators(\"%\")";
Debug.ShouldStop(2097152);
_processoperators(RemoteObject.createImmutable("%"));
 BA.debugLineNum = 151;BA.debugLine="ProcessOperators(\"+\")";
Debug.ShouldStop(4194304);
_processoperators(RemoteObject.createImmutable("+"));
 BA.debugLineNum = 152;BA.debugLine="ProcessOperators(\"-\")";
Debug.ShouldStop(8388608);
_processoperators(RemoteObject.createImmutable("-"));
 BA.debugLineNum = 153;BA.debugLine="Log(\" \")";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4393228",RemoteObject.createImmutable(" "),0);
 BA.debugLineNum = 154;BA.debugLine="Log(\"RESULT: \" & text)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4393229",RemoteObject.concat(RemoteObject.createImmutable("RESULT: "),main.mostCurrent._text),0);
 BA.debugLineNum = 155;BA.debugLine="lblLog.Text = lblLog.Text & CRLF & \" \" & CRLF & \"";
Debug.ShouldStop(67108864);
main.mostCurrent._lbllog.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lbllog.runMethod(true,"getText"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable(" "),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("RESULT: "),main.mostCurrent._text)));
 BA.debugLineNum = 156;BA.debugLine="lblResult.Text = text";
Debug.ShouldStop(134217728);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._text));
 BA.debugLineNum = 157;BA.debugLine="Log(\"---------------------------------\")";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4393232",RemoteObject.createImmutable("---------------------------------"),0);
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}