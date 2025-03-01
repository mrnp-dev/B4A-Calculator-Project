package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_1 {


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
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("btnAction_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,144);
if (RapidSub.canDelegate("btnaction_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnaction_click");}
 BA.debugLineNum = 144;BA.debugLine="Private Sub btnAction_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="btnSender = Sender";
Debug.ShouldStop(65536);
main.mostCurrent._btnsender = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 146;BA.debugLine="Select btnSender.Tag";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(main.mostCurrent._btnsender.runMethod(false,"getTag"),RemoteObject.createImmutable(("AC")),RemoteObject.createImmutable(("BS")),RemoteObject.createImmutable(("Dot")))) {
case 0: {
 BA.debugLineNum = 148;BA.debugLine="lblPrompt.Text = \"\"";
Debug.ShouldStop(524288);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 149;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(1048576);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 break; }
case 1: {
 BA.debugLineNum = 152;BA.debugLine="If lblPrompt.Text.Length > 0 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean(">",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 153;BA.debugLine="lblPrompt.Text = lblPrompt.Text.SubString2(0,";
Debug.ShouldStop(16777216);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))));
 BA.debugLineNum = 154;BA.debugLine="Solve";
Debug.ShouldStop(33554432);
_solve();
 };
 break; }
case 2: {
 BA.debugLineNum = 157;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
Debug.ShouldStop(268435456);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 break; }
default: {
 BA.debugLineNum = 159;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
Debug.ShouldStop(1073741824);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 BA.debugLineNum = 160;BA.debugLine="Solve";
Debug.ShouldStop(-2147483648);
_solve();
 break; }
}
;
 BA.debugLineNum = 162;BA.debugLine="If lblPrompt.Text.Length >= 16 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("g",main.mostCurrent._lblprompt.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 16))) { 
 BA.debugLineNum = 163;BA.debugLine="lblPrompt.TextSize = 40";
Debug.ShouldStop(4);
main.mostCurrent._lblprompt.runMethod(true,"setTextSize",BA.numberCast(float.class, 40));
 }else {
 BA.debugLineNum = 165;BA.debugLine="lblPrompt.TextSize = 50";
Debug.ShouldStop(16);
main.mostCurrent._lblprompt.runMethod(true,"setTextSize",BA.numberCast(float.class, 50));
 };
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("btnOperation_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,130);
if (RapidSub.canDelegate("btnoperation_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnoperation_click");}
 BA.debugLineNum = 130;BA.debugLine="Private Sub btnOperation_Click()";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="btnSender = Sender";
Debug.ShouldStop(4);
main.mostCurrent._btnsender = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 132;BA.debugLine="Select btnSender.Tag";
Debug.ShouldStop(8);
switch (BA.switchObjectToInt(main.mostCurrent._btnsender.runMethod(false,"getTag"),RemoteObject.createImmutable(("=")),RemoteObject.createImmutable(("x")))) {
case 0: {
 BA.debugLineNum = 134;BA.debugLine="Solve";
Debug.ShouldStop(32);
_solve();
 BA.debugLineNum = 135;BA.debugLine="lblPrompt.Text = lblResult.Text";
Debug.ShouldStop(64);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._lblresult.runMethod(true,"getText")));
 BA.debugLineNum = 136;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(128);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 break; }
case 1: {
 BA.debugLineNum = 138;BA.debugLine="lblPrompt.Text = lblPrompt.Text & \"x\"";
Debug.ShouldStop(512);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),RemoteObject.createImmutable("x"))));
 break; }
default: {
 BA.debugLineNum = 140;BA.debugLine="lblPrompt.Text = lblPrompt.Text & btnSender.Tex";
Debug.ShouldStop(2048);
main.mostCurrent._lblprompt.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._lblprompt.runMethod(true,"getText"),main.mostCurrent._btnsender.runMethod(true,"getText"))));
 break; }
}
;
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("GetNumberLeft (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,84);
if (RapidSub.canDelegate("getnumberleft")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getnumberleft", _ind);}
RemoteObject _leftctr = RemoteObject.createImmutable(0);
int _row = 0;
Debug.locals.put("ind", _ind);
 BA.debugLineNum = 84;BA.debugLine="Private Sub GetNumberLeft(ind As Int) As String";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Dim leftCtr As Int = ind";
Debug.ShouldStop(1048576);
_leftctr = _ind;Debug.locals.put("leftCtr", _leftctr);Debug.locals.put("leftCtr", _leftctr);
 BA.debugLineNum = 86;BA.debugLine="For row = ind - 1 To 0 Step -1";
Debug.ShouldStop(2097152);
{
final int step2 = -1;
final int limit2 = 0;
_row = RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step2 > 0 && _row <= limit2) || (step2 < 0 && _row >= limit2) ;_row = ((int)(0 + _row + step2))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 87;BA.debugLine="If IsNumber(text.CharAt(row)) Or text.CharAt(row";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.ObjectToString(main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))))))) || RemoteObject.solveBoolean("=",main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))),BA.ObjectToChar("."))) { 
 BA.debugLineNum = 88;BA.debugLine="leftCtr = row";
Debug.ShouldStop(8388608);
_leftctr = BA.numberCast(int.class, _row);Debug.locals.put("leftCtr", _leftctr);
 }else {
 BA.debugLineNum = 90;BA.debugLine="Exit";
Debug.ShouldStop(33554432);
if (true) break;
 };
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 94;BA.debugLine="If leftCtr = ind Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_leftctr,BA.numberCast(double.class, _ind))) { 
 BA.debugLineNum = 96;BA.debugLine="Return \"\"";
Debug.ShouldStop(-2147483648);
if (true) return BA.ObjectToString("");
 }else {
 BA.debugLineNum = 98;BA.debugLine="Return text.SubString2(leftCtr, ind)";
Debug.ShouldStop(2);
if (true) return main.mostCurrent._text.runMethod(true,"substring",(Object)(_leftctr),(Object)(_ind));
 };
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("GetNumberRight (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,102);
if (RapidSub.canDelegate("getnumberright")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getnumberright", _ind);}
RemoteObject _rightctr = RemoteObject.createImmutable(0);
int _row = 0;
Debug.locals.put("ind", _ind);
 BA.debugLineNum = 102;BA.debugLine="Private Sub GetNumberRight(ind As Int) As String";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Dim rightCtr As Int = ind";
Debug.ShouldStop(64);
_rightctr = _ind;Debug.locals.put("rightCtr", _rightctr);Debug.locals.put("rightCtr", _rightctr);
 BA.debugLineNum = 104;BA.debugLine="For row = ind + 1 To text.Length - 1 Step 1";
Debug.ShouldStop(128);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._text.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "+",1, 1).<Integer>get().intValue() ;
for (;(step2 > 0 && _row <= limit2) || (step2 < 0 && _row >= limit2) ;_row = ((int)(0 + _row + step2))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 105;BA.debugLine="If IsNumber(text.CharAt(row)) Or text.CharAt(row";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.ObjectToString(main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))))))) || RemoteObject.solveBoolean("=",main.mostCurrent._text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _row))),BA.ObjectToChar("."))) { 
 BA.debugLineNum = 106;BA.debugLine="rightCtr = row";
Debug.ShouldStop(512);
_rightctr = BA.numberCast(int.class, _row);Debug.locals.put("rightCtr", _rightctr);
 }else {
 BA.debugLineNum = 108;BA.debugLine="Exit";
Debug.ShouldStop(2048);
if (true) break;
 };
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 112;BA.debugLine="If rightCtr = ind Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_rightctr,BA.numberCast(double.class, _ind))) { 
 BA.debugLineNum = 114;BA.debugLine="Return \"\"";
Debug.ShouldStop(131072);
if (true) return BA.ObjectToString("");
 };
 BA.debugLineNum = 116;BA.debugLine="Return text.SubString2(ind + 1, rightCtr + 1)";
Debug.ShouldStop(524288);
if (true) return main.mostCurrent._text.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_rightctr,RemoteObject.createImmutable(1)}, "+",1, 1)));
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("ProcessOperators (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,35);
if (RapidSub.canDelegate("processoperators")) { return b4a.example.main.remoteMe.runUserSub(false, "main","processoperators", _operator);}
RemoteObject _ind = RemoteObject.createImmutable(0);
RemoteObject _str1 = RemoteObject.createImmutable("");
RemoteObject _str2 = RemoteObject.createImmutable("");
RemoteObject _strrem = RemoteObject.createImmutable("");
RemoteObject _int1 = RemoteObject.createImmutable(0f);
RemoteObject _int2 = RemoteObject.createImmutable(0f);
RemoteObject _res = RemoteObject.createImmutable(0f);
Debug.locals.put("operator", _operator);
 BA.debugLineNum = 35;BA.debugLine="Private Sub ProcessOperators(operator As String)";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="Do While text.IndexOf2(operator,1) <> -1";
Debug.ShouldStop(8);
while (RemoteObject.solveBoolean("!",main.mostCurrent._text.runMethod(true,"indexOf",(Object)(_operator),(Object)(BA.numberCast(int.class, 1))),BA.numberCast(double.class, -(double) (0 + 1)))) {
 BA.debugLineNum = 37;BA.debugLine="If operator = \"-\" Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_operator,BA.ObjectToString("-"))) { 
 BA.debugLineNum = 38;BA.debugLine="Dim ind As Int = text.IndexOf2(operator,1)";
Debug.ShouldStop(32);
_ind = main.mostCurrent._text.runMethod(true,"indexOf",(Object)(_operator),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("ind", _ind);Debug.locals.put("ind", _ind);
 }else {
 BA.debugLineNum = 40;BA.debugLine="Dim ind As Int = text.IndexOf(operator)";
Debug.ShouldStop(128);
_ind = main.mostCurrent._text.runMethod(true,"indexOf",(Object)(_operator));Debug.locals.put("ind", _ind);Debug.locals.put("ind", _ind);
 };
 BA.debugLineNum = 42;BA.debugLine="Dim str1 As String = GetNumberLeft(ind)";
Debug.ShouldStop(512);
_str1 = _getnumberleft(_ind);Debug.locals.put("str1", _str1);Debug.locals.put("str1", _str1);
 BA.debugLineNum = 43;BA.debugLine="Dim str2 As String = GetNumberRight(ind)";
Debug.ShouldStop(1024);
_str2 = _getnumberright(_ind);Debug.locals.put("str2", _str2);Debug.locals.put("str2", _str2);
 BA.debugLineNum = 45;BA.debugLine="If str1 = \"\" Or str2 = \"\" Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_str1,BA.ObjectToString("")) || RemoteObject.solveBoolean("=",_str2,BA.ObjectToString(""))) { 
 BA.debugLineNum = 47;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(16384);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 48;BA.debugLine="Return ' Exit the subroutine if invalid";
Debug.ShouldStop(32768);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 51;BA.debugLine="Dim strRem As String = str1 & operator & str2";
Debug.ShouldStop(262144);
_strrem = RemoteObject.concat(_str1,_operator,_str2);Debug.locals.put("strRem", _strrem);Debug.locals.put("strRem", _strrem);
 BA.debugLineNum = 52;BA.debugLine="Dim int1 As Float = str1.As(Float)";
Debug.ShouldStop(524288);
_int1 = (BA.numberCast(float.class, _str1));Debug.locals.put("int1", _int1);Debug.locals.put("int1", _int1);
 BA.debugLineNum = 53;BA.debugLine="Dim int2 As Float = str2.As(Float)";
Debug.ShouldStop(1048576);
_int2 = (BA.numberCast(float.class, _str2));Debug.locals.put("int2", _int2);Debug.locals.put("int2", _int2);
 BA.debugLineNum = 54;BA.debugLine="Dim res As Float";
Debug.ShouldStop(2097152);
_res = RemoteObject.createImmutable(0f);Debug.locals.put("res", _res);
 BA.debugLineNum = 56;BA.debugLine="Select operator";
Debug.ShouldStop(8388608);
switch (BA.switchObjectToInt(_operator,BA.ObjectToString("x"),BA.ObjectToString("÷"),BA.ObjectToString("%"),BA.ObjectToString("+"),BA.ObjectToString("-"))) {
case 0: {
 BA.debugLineNum = 58;BA.debugLine="res = int1 * int2";
Debug.ShouldStop(33554432);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "*",0, 0));Debug.locals.put("res", _res);
 break; }
case 1: {
 BA.debugLineNum = 60;BA.debugLine="res = int1 / int2";
Debug.ShouldStop(134217728);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "/",0, 0));Debug.locals.put("res", _res);
 break; }
case 2: {
 BA.debugLineNum = 62;BA.debugLine="res = (int1 * int2) / 100";
Debug.ShouldStop(536870912);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "*",0, 0)),RemoteObject.createImmutable(100)}, "/",0, 0));Debug.locals.put("res", _res);
 break; }
case 3: {
 BA.debugLineNum = 64;BA.debugLine="res = int1 + int2";
Debug.ShouldStop(-2147483648);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "+",1, 0));Debug.locals.put("res", _res);
 break; }
case 4: {
 BA.debugLineNum = 66;BA.debugLine="res = int1 - int2";
Debug.ShouldStop(2);
_res = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_int1,_int2}, "-",1, 0));Debug.locals.put("res", _res);
 break; }
}
;
 BA.debugLineNum = 72;BA.debugLine="Log(\"Initial text: \" & text)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4196645",RemoteObject.concat(RemoteObject.createImmutable("Initial text: "),main.mostCurrent._text),0);
 BA.debugLineNum = 73;BA.debugLine="text = text.Replace(strRem, NumberFormat2(res, 0";
Debug.ShouldStop(256);
main.mostCurrent._text = main.mostCurrent._text.runMethod(true,"replace",(Object)(_strrem),(Object)(main.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, _res)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.getField(true,"False")))));
 BA.debugLineNum = 74;BA.debugLine="Log(\"Updated text: \" & text)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4196647",RemoteObject.concat(RemoteObject.createImmutable("Updated text: "),main.mostCurrent._text),0);
 BA.debugLineNum = 78;BA.debugLine="lblResult.Text = text";
Debug.ShouldStop(8192);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._text));
 }
;
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Solve (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,119);
if (RapidSub.canDelegate("solve")) { return b4a.example.main.remoteMe.runUserSub(false, "main","solve");}
 BA.debugLineNum = 119;BA.debugLine="Private Sub Solve";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 120;BA.debugLine="text = lblPrompt.Text";
Debug.ShouldStop(8388608);
main.mostCurrent._text = main.mostCurrent._lblprompt.runMethod(true,"getText");
 BA.debugLineNum = 121;BA.debugLine="lblResult.Text = \"\"";
Debug.ShouldStop(16777216);
main.mostCurrent._lblresult.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 122;BA.debugLine="ProcessOperators(\"x\")";
Debug.ShouldStop(33554432);
_processoperators(RemoteObject.createImmutable("x"));
 BA.debugLineNum = 123;BA.debugLine="ProcessOperators(\"÷\")";
Debug.ShouldStop(67108864);
_processoperators(RemoteObject.createImmutable("÷"));
 BA.debugLineNum = 124;BA.debugLine="ProcessOperators(\"%\")";
Debug.ShouldStop(134217728);
_processoperators(RemoteObject.createImmutable("%"));
 BA.debugLineNum = 125;BA.debugLine="ProcessOperators(\"-\")";
Debug.ShouldStop(268435456);
_processoperators(RemoteObject.createImmutable("-"));
 BA.debugLineNum = 126;BA.debugLine="ProcessOperators(\"+\")";
Debug.ShouldStop(536870912);
_processoperators(RemoteObject.createImmutable("+"));
 BA.debugLineNum = 127;BA.debugLine="Log(\"---------------------------------\")";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4393224",RemoteObject.createImmutable("---------------------------------"),0);
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}