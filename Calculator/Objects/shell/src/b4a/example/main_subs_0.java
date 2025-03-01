package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(536870912);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("btnAction_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,134);
if (RapidSub.canDelegate("btnaction_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnaction_click");}
 BA.debugLineNum = 134;BA.debugLine="Private Sub btnAction_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 135;BA.debugLine="btnSender = Sender";
Debug.ShouldStop(64);
main.mostCurrent._btnsender = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 136;BA.debugLine="Select btnSender.Tag";
Debug.ShouldStop(128);
switch (BA.switchObjectToInt(main.mostCurrent._btnsender.runMethod(false,"getTag"),RemoteObject.createImmutable(("AC")),RemoteObject.createImmutable(("BS")),RemoteObject.createImmutable(("Dot")))) {
case 0: {
 BA.debugLineNum = 138;BA.debugLine="lblPrompt.Text = \"\"";
Debug.ShouldStop(512);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 139;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(1024);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 break; }
case 1: {
 BA.debugLineNum = 141;BA.debugLine="If lblPrompt.Text.Length > 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 142;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(8192);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 BA.debugLineNum = 143;BA.debugLine="Solve";
Debug.ShouldStop(16384);
_solve();
 };
 break; }
case 2: {
 BA.debugLineNum = 146;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
Debug.ShouldStop(131072);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 break; }
default: {
 BA.debugLineNum = 148;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
Debug.ShouldStop(524288);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 BA.debugLineNum = 149;BA.debugLine="Solve";
Debug.ShouldStop(1048576);
_solve();
 break; }
}
;
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("btnOperation_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,122);
if (RapidSub.canDelegate("btnoperation_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnoperation_click");}
 BA.debugLineNum = 122;BA.debugLine="Private Sub btnOperation_Click()";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="btnSender = Sender";
Debug.ShouldStop(67108864);
main.mostCurrent._btnsender = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 124;BA.debugLine="Select btnSender.Tag";
Debug.ShouldStop(134217728);
switch (BA.switchObjectToInt(main.mostCurrent._btnsender.runMethod(false,"getTag"),RemoteObject.createImmutable(("=")))) {
case 0: {
 BA.debugLineNum = 126;BA.debugLine="Solve";
Debug.ShouldStop(536870912);
_solve();
 BA.debugLineNum = 127;BA.debugLine="lblPrompt.Text = lblResult.Text";
Debug.ShouldStop(1073741824);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblresult.runMethod(true,"getText")));
 BA.debugLineNum = 128;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 break; }
default: {
 BA.debugLineNum = 130;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
Debug.ShouldStop(2);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 break; }
}
;
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("GetNumberLeft (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,77);
if (RapidSub.canDelegate("getnumberleft")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getnumberleft", _ind);}
RemoteObject _leftctr = RemoteObject.createImmutable(0);
int _row = 0;
Debug.locals.put("ind", _ind);
 BA.debugLineNum = 77;BA.debugLine="Private Sub GetNumberLeft(ind As Int) As String";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Dim leftCtr As Int = ind";
Debug.ShouldStop(8192);
_leftctr = _ind;Debug.locals.put("leftCtr", _leftctr);Debug.locals.put("leftCtr", _leftctr);
 BA.debugLineNum = 79;BA.debugLine="For row = ind - 1 To 0 Step -1";
Debug.ShouldStop(16384);
{
final int step2 = -1;
final int limit2 = 0;
_row = RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step2 > 0 && _row <= limit2) || (step2 < 0 && _row >= limit2) ;_row = ((int)(0 + _row + step2))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 80;BA.debugLine="If IsNumber(text.CharAt(row)) Or text.CharAt(row";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.ObjectToString(main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))))))) || RemoteObject.solveBoolean("=",main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))),BA.ObjectToChar(".")) || RemoteObject.solveBoolean("=",main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))),BA.ObjectToChar("-"))) { 
 BA.debugLineNum = 81;BA.debugLine="leftCtr = row";
Debug.ShouldStop(65536);
_leftctr = BA.numberCast(int.class, _row);Debug.locals.put("leftCtr", _leftctr);
 }else {
 BA.debugLineNum = 83;BA.debugLine="Exit";
Debug.ShouldStop(262144);
if (true) break;
 };
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 87;BA.debugLine="If leftCtr = ind Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_leftctr,BA.numberCast(double.class, _ind))) { 
 BA.debugLineNum = 89;BA.debugLine="Return \"\"";
Debug.ShouldStop(16777216);
if (true) return BA.ObjectToString("");
 }else {
 BA.debugLineNum = 91;BA.debugLine="Return text.SubString2(leftCtr, ind)";
Debug.ShouldStop(67108864);
if (true) return main.mostCurrent._text.runMethod(true,"substring",(Object)(_leftctr),(Object)(_ind));
 };
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("GetNumberRight (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,95);
if (RapidSub.canDelegate("getnumberright")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getnumberright", _ind);}
RemoteObject _rightctr = RemoteObject.createImmutable(0);
int _row = 0;
Debug.locals.put("ind", _ind);
 BA.debugLineNum = 95;BA.debugLine="Private Sub GetNumberRight(ind As Int) As String";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="Dim rightCtr As Int = ind";
Debug.ShouldStop(-2147483648);
_rightctr = _ind;Debug.locals.put("rightCtr", _rightctr);Debug.locals.put("rightCtr", _rightctr);
 BA.debugLineNum = 97;BA.debugLine="For row = ind + 1 To text.Length - 1 Step 1";
Debug.ShouldStop(1);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._text.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "+",1, 1).<Integer>get().intValue() ;
for (;(step2 > 0 && _row <= limit2) || (step2 < 0 && _row >= limit2) ;_row = ((int)(0 + _row + step2))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 98;BA.debugLine="If IsNumber(text.CharAt(row)) Or text.CharAt(row";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.ObjectToString(main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))))))) || RemoteObject.solveBoolean("=",main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))),BA.ObjectToChar("."))) { 
 BA.debugLineNum = 99;BA.debugLine="rightCtr = row";
Debug.ShouldStop(4);
_rightctr = BA.numberCast(int.class, _row);Debug.locals.put("rightCtr", _rightctr);
 }else {
 BA.debugLineNum = 101;BA.debugLine="Exit";
Debug.ShouldStop(16);
if (true) break;
 };
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 105;BA.debugLine="If rightCtr = ind Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_rightctr,BA.numberCast(double.class, _ind))) { 
 BA.debugLineNum = 107;BA.debugLine="Return \"\"";
Debug.ShouldStop(1024);
if (true) return BA.ObjectToString("");
 };
 BA.debugLineNum = 109;BA.debugLine="Return text.SubString2(ind + 1, rightCtr + 1)";
Debug.ShouldStop(4096);
if (true) return main.mostCurrent._text.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_rightctr,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
 //BA.debugLineNum = 26;BA.debugLine="Dim text As String";
main.mostCurrent._text = RemoteObject.createImmutable("");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

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
		Debug.PushSubsStack("ProcessOperators (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,33);
if (RapidSub.canDelegate("processoperators")) { return b4a.example.main.remoteMe.runUserSub(false, "main","processoperators", _operator);}
RemoteObject _ind = RemoteObject.createImmutable(0);
RemoteObject _str1 = RemoteObject.createImmutable("");
RemoteObject _str2 = RemoteObject.createImmutable("");
RemoteObject _strrem = RemoteObject.createImmutable("");
RemoteObject _int1 = RemoteObject.createImmutable(0f);
RemoteObject _int2 = RemoteObject.createImmutable(0f);
RemoteObject _res = RemoteObject.createImmutable(0f);
Debug.locals.put("operator", _operator);
 BA.debugLineNum = 33;BA.debugLine="Private Sub ProcessOperators(operator As String)";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="Do While text.IndexOf(operator) <> -1";
Debug.ShouldStop(2);
while (RemoteObject.solveBoolean("!",main.mostCurrent._text.runMethod(true,"indexOf",(Object)(_operator)),BA.numberCast(double.class, -(double) (0 + 1)))) {
 BA.debugLineNum = 35;BA.debugLine="Dim ind As Int = text.IndexOf(operator)";
Debug.ShouldStop(4);
_ind = main.mostCurrent._text.runMethod(true,"indexOf",(Object)(_operator));Debug.locals.put("ind", _ind);Debug.locals.put("ind", _ind);
 BA.debugLineNum = 36;BA.debugLine="Dim str1 As String = GetNumberLeft(ind)";
Debug.ShouldStop(8);
_str1 = _getnumberleft(_ind);Debug.locals.put("str1", _str1);Debug.locals.put("str1", _str1);
 BA.debugLineNum = 37;BA.debugLine="Dim str2 As String = GetNumberRight(ind)";
Debug.ShouldStop(16);
_str2 = _getnumberright(_ind);Debug.locals.put("str2", _str2);Debug.locals.put("str2", _str2);
 BA.debugLineNum = 39;BA.debugLine="If str1 = \"\" Or str2 = \"\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_str1,BA.ObjectToString("")) || RemoteObject.solveBoolean("=",_str2,BA.ObjectToString(""))) { 
 BA.debugLineNum = 41;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(256);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 42;BA.debugLine="Return ' Exit the subroutine if invalid";
Debug.ShouldStop(512);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 45;BA.debugLine="Dim strRem As String = str1 & operator & str2";
Debug.ShouldStop(4096);
_strrem = RemoteObject.concat(_str1,_operator,_str2);Debug.locals.put("strRem", _strrem);Debug.locals.put("strRem", _strrem);
 BA.debugLineNum = 46;BA.debugLine="Dim int1 As Float = str1.As(Float)";
Debug.ShouldStop(8192);
_int1 = (BA.numberCast(float.class, _str1));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 47;BA.debugLine="Dim int2 As Float = str2.As(Float)";
Debug.ShouldStop(16384);
_int2 = (BA.numberCast(float.class, _str2));Debug.locals.put("int2", _int2);Debug.locals.put("int2", _int2);
 BA.debugLineNum = 48;BA.debugLine="Dim res As Float";
Debug.ShouldStop(32768);
_res = RemoteObject.createImmutable(0f);Debug.locals.put("res", _res);
 BA.debugLineNum = 50;BA.debugLine="If operator = \"X\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_operator,BA.ObjectToString("X"))) { 
 BA.debugLineNum = 51;BA.debugLine="res = int1 * int2";
Debug.ShouldStop(262144);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "*",0, 0));Debug.locals.put("res", _res);
 }else 
{ BA.debugLineNum = 52;BA.debugLine="Else If operator = \"%\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_operator,BA.ObjectToString("%"))) { 
 BA.debugLineNum = 53;BA.debugLine="res = (int1 * int2) / 100";
Debug.ShouldStop(1048576);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "*",0, 0)),RemoteObject.createImmutable(100)}, "/",0, 0));Debug.locals.put("res", _res);
 }else 
{ BA.debugLineNum = 54;BA.debugLine="Else If operator = \"/\" Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_operator,BA.ObjectToString("/"))) { 
 BA.debugLineNum = 55;BA.debugLine="res = int1 / int2";
Debug.ShouldStop(4194304);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "/",0, 0));Debug.locals.put("res", _res);
 }else 
{ BA.debugLineNum = 56;BA.debugLine="Else If operator = \"+\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_operator,BA.ObjectToString("+"))) { 
 BA.debugLineNum = 57;BA.debugLine="res = int1 + int2";
Debug.ShouldStop(16777216);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "+",1, 0));Debug.locals.put("res", _res);
 }else 
{ BA.debugLineNum = 58;BA.debugLine="Else If operator = \"-\" Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_operator,BA.ObjectToString("-"))) { 
 BA.debugLineNum = 59;BA.debugLine="res = int1 - int2";
Debug.ShouldStop(67108864);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "-",1, 0));Debug.locals.put("res", _res);
 }}}}}
;
 BA.debugLineNum = 62;BA.debugLine="Log(\"Res: \"&res)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5196637",RemoteObject.concat(RemoteObject.createImmutable("Res: "),_res),0);
 BA.debugLineNum = 63;BA.debugLine="Log(\"NFO: \" & NumberFormat2(res, 1, 10, 0, False";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5196638",RemoteObject.concat(RemoteObject.createImmutable("NFO: "),main.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, _res)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.getField(true,"False")))),0);
 BA.debugLineNum = 65;BA.debugLine="Log(\"Initial text: \" & text)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5196640",RemoteObject.concat(RemoteObject.createImmutable("Initial text: "),main.mostCurrent._text),0);
 BA.debugLineNum = 66;BA.debugLine="text = text.Replace(strRem, NumberFormat2(res, 1";
Debug.ShouldStop(2);
main.mostCurrent._text = main.mostCurrent._text.runMethod(true,"replace",(Object)(_strrem),(Object)(main.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, _res)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.getField(true,"False")))));
 BA.debugLineNum = 67;BA.debugLine="Log(\"Updated text: \" & text)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5196642",RemoteObject.concat(RemoteObject.createImmutable("Updated text: "),main.mostCurrent._text),0);
 BA.debugLineNum = 69;BA.debugLine="Log(\"Text: \" & text)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5196644",RemoteObject.concat(RemoteObject.createImmutable("Text: "),main.mostCurrent._text),0);
 BA.debugLineNum = 71;BA.debugLine="lblResult.Text = text";
Debug.ShouldStop(64);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._text));
 }
;
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Solve (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,112);
if (RapidSub.canDelegate("solve")) { return b4a.example.main.remoteMe.runUserSub(false, "main","solve");}
 BA.debugLineNum = 112;BA.debugLine="Private Sub Solve";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="text = lblPrompt.Text";
Debug.ShouldStop(65536);
main.mostCurrent._text = main.mostCurrent._lblprompt.runMethod(true,"getText");
 BA.debugLineNum = 114;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(131072);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 115;BA.debugLine="ProcessOperators(\"/\")";
Debug.ShouldStop(262144);
_processoperators(RemoteObject.createImmutable("/"));
 BA.debugLineNum = 116;BA.debugLine="ProcessOperators(\"X\")";
Debug.ShouldStop(524288);
_processoperators(RemoteObject.createImmutable("X"));
 BA.debugLineNum = 117;BA.debugLine="ProcessOperators(\"-\")";
Debug.ShouldStop(1048576);
_processoperators(RemoteObject.createImmutable("-"));
 BA.debugLineNum = 118;BA.debugLine="ProcessOperators(\"+\")";
Debug.ShouldStop(2097152);
_processoperators(RemoteObject.createImmutable("+"));
 BA.debugLineNum = 119;BA.debugLine="ProcessOperators(\"%\")";
Debug.ShouldStop(4194304);
_processoperators(RemoteObject.createImmutable("%"));
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
}